package com.hyunsungkr.youtubeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class PhotoActivity extends AppCompatActivity {
    ImageView imgPhoto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        imgPhoto = findViewById(R.id.imgPhoto);

        // 이미지를 표시하려면, url이 있어야한다.
        // 따라서 메인액티비티로부터 url을 받아온다.

        String highUrl = getIntent().getStringExtra("highUrl");
        Glide.with(PhotoActivity.this).load(highUrl).placeholder(R.drawable.baseline_ondemand_video_24).into(imgPhoto);


    }
}