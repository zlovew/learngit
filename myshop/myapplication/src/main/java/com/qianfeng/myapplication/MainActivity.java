package com.qianfeng.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View view) {
        this.finish();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.i("wwwwwwwwww", "wwwwwwww");
    }
    public static void finsh(){
    }
}
