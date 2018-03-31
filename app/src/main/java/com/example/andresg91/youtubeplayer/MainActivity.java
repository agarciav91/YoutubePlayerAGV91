package com.example.andresg91.youtubeplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBtnSingle = (Button) findViewById(R.id.btn_playSingle);
        Button mBtnStandalone = (Button) findViewById(R.id.btn_standalone);

        mBtnSingle.setOnClickListener(this);
        mBtnStandalone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btn_playSingle:
                intent = new Intent(this, YoutubeActivity.class);
                break;

            case R.id.btn_standalone:
                intent = new Intent(this, StandaloneActivity.class);
                break;

            default:
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
