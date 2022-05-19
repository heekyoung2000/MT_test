package com.example.test1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class homeActivity extends AppCompatActivity {
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvDate = (TextView) findViewById(R.id.homeItem);
       // btnRefresh = (Button) findViewById(R.id.btnRefresh);

        tvDate.setText(getTime());

        //btnRefresh.setOnClickListener(this);
    }
    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 회원님의 식단입니다");
        String getTime = dateFormat.format(date);

        return getTime;
    }
}