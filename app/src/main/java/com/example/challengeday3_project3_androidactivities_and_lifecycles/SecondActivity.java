package com.example.challengeday3_project3_androidactivities_and_lifecycles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private TextView city;
    private TextView age;
    private EditText review;
    private Button sendToMain_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.nameTv);
        city = findViewById(R.id.cityTv);
        age = findViewById(R.id.ageTv);
        review = findViewById(R.id.reviewEditText);
        sendToMain_btn = findViewById(R.id.buttonSendToMain);

        sendToMain_btn.setOnClickListener(this);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            name.setText(extra.getString("name_key"));
            city.setText(extra.getString("city_key"));
            age.setText(String.valueOf(extra.getInt("age_key")));
        }
        else{

        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = getIntent();
        intent.putExtra("review_key",review.getText().toString().trim());
        setResult(RESULT_OK,intent);
        finish();
    }
}
