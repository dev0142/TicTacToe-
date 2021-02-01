package com.example.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;




public class MainActivity extends AppCompatActivity {
    //0:yellow 1:Red
    int activePLayer=0;

    int[] gameState={2,2,2,2,2,2,2,2,2};

    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gameActive=true;

    public void dropIn(View view){
        ImageView counter=(ImageView) view;
        int tappedCounter=Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2 && gameActive ) {
            gameState[tappedCounter] = activePLayer;
            counter.setTranslationY(-1500);
            if (activePLayer == 0) {
                counter.setImageResource(R.drawable.yellowheart);
                activePLayer = 1;
            } else {
                counter.setImageResource(R.drawable.redheart);
                activePLayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(360).setDuration(500);

            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    //Someone has won
                    gameActive=false;
                    String winner = " ";
                    if (activePLayer == 1) {
                        winner = "Yellow heart ";

                    } else {
                        winner = "Red heart ";
                    }

                    Button playAgainButton=(Button) findViewById(R.id.playAgainButton);

                    TextView winnerText=(TextView) findViewById(R.id.winnerText);

                    winnerText.setText(winner + "has won!");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerText.setVisibility(View.VISIBLE);
                }
            }
        }

    }
    public void playAgain(View view) {
        Log.i("info", "button pressed");
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

        TextView winnerText = (TextView) findViewById(R.id.winnerText);

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerText.setVisibility(View.INVISIBLE);

        GridLayout gridlayout =(GridLayout) findViewById(R.id.gridlayout);

        for (int i = 0; i < gridlayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridlayout.getChildAt(i);
            counter.setImageDrawable(null);

        }


        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        activePLayer = 0;
        gameActive = true;
    }
    public void resetGame(View view){
        Log.i("info", "button pressed");
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

        TextView winnerText = (TextView) findViewById(R.id.winnerText);

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerText.setVisibility(View.INVISIBLE);

        GridLayout gridlayout =(GridLayout) findViewById(R.id.gridlayout);

        for (int i = 0; i < gridlayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridlayout.getChildAt(i);
            counter.setImageDrawable(null);

        }


        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        activePLayer = 0;
        gameActive = true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}