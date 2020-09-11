package com.rosa.androidlifecycle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AndroidLifeCycle";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    TextInputEditText inp_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp_msg = findViewById(R.id.inp_msg);

        sharedPreferences = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: accessed!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: accessed!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        String msg = sharedPreferences.getString("message", "");
        inp_msg.setText(msg);
        Log.i(TAG, "onResume: accessed!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: accessed!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor.putString("message", Objects.requireNonNull(inp_msg.getText()).toString())
                .commit();
        Log.i(TAG, "onPause: accessed!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: accessed!");
    }
}