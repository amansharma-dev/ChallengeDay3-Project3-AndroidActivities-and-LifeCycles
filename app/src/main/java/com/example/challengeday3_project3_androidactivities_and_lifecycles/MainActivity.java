package com.example.challengeday3_project3_androidactivities_and_lifecycles;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "MainActivity";
    public static final int REQUEST_CODE = 3;
    private EditText nameEt;
    private EditText cityEt;
    private EditText ageEt;
    private Button sendToActivityB_btn;
    private TextView reviewMessageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        nameEt = findViewById(R.id.name);
        cityEt = findViewById(R.id.city);
        ageEt = findViewById(R.id.age);
        sendToActivityB_btn = findViewById(R.id.buttonSendToB);
        reviewMessageTv = findViewById(R.id.messageFromActivityB);

        sendToActivityB_btn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "onPostResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public void onClick(View view) {



        if(!nameEt.getText().toString().trim().isEmpty() && !cityEt.getText().toString().trim().isEmpty()){

            String name =  nameEt.getText().toString().trim();
            String city = cityEt.getText().toString().trim();
            int age = Integer.parseInt(ageEt.getText().toString().trim());

            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("name_key",name);
            intent.putExtra("city_key",city);
            intent.putExtra("age_key",age);
            startActivityForResult(intent,REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            assert data != null;
            reviewMessageTv.setText(data.getStringExtra("review_key"));
        }
    }
}
