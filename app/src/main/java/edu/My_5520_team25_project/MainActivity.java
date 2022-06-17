package edu.My_5520_team25_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.My_5520_team25_project.game.GameMainView;


public class MainActivity extends AppCompatActivity {


    private GameMainView gameMainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameMainView = findViewById(R.id.game_main_view);

        gameMainView.startGame();

        gameMainView.puaseGame();

        gameMainView.stopGame();




    }


}
