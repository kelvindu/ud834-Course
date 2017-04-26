package com.kelvindu.learning.ud834_course;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int skorA = 0;
    private int skorB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method ini menambah 3 point untuk tim A
     * */
    public void skorTigaPoinA(View v){
        skorA = skorA + 3;
        tampilkanSkorA(skorA);
    }

    /**
     * Method ini menambah 2 point untuk tim A
     * */
    public void skorDuaPoinA(View v){
        skorA = skorA + 2;
        tampilkanSkorA(skorA);
    }

    /**
     * Method ini menambah 1 point untuk tim A
     * */
    public void freeThrowA(View v){
        skorA = skorA + 1;
        tampilkanSkorA(skorA);
    }

    /**
     * Method ini menambah 3 point untuk tim B
     * */
    public void skorTigaPoinB(View v){
        skorB = skorB + 3;
        tampilkanSkorB(skorB);
    }

    /**
     * Method ini menambah 3 point untuk tim B
     * */
    public void skorDuaPoinB(View v){
        skorB = skorB + 2;
        tampilkanSkorB(skorB);
    }

    /**
     * Method ini menambah 3 point untuk tim B
     * */
    public void freeThrowB(View v){
        skorB = skorB + 1;
        tampilkanSkorB(skorB);
    }

    /**
     * Method ini mereset kembali jumlah skor tim A dan tim B
     * */
    public void tombolReset(View v){
        skorA = skorB = 0;
        tampilkanSkorA(skorA);
        tampilkanSkorB(skorB);
    }

    /**
     * Method ini menampilkan jumlah skor tim A ke layar
     * */
    private void tampilkanSkorA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Method ini menampilkan jumlah skor tim B ke layar
     * */
    private void tampilkanSkorB(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
