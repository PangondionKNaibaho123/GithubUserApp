package com.zephyr.githubuserapp.layout_controller;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.zephyr.githubuserapp.R;
import com.zephyr.githubuserapp.model.user_github;

public class ContentActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "extra_user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);


        ImageView ivContentPicUser = findViewById(R.id.iv_content_picuser);
        TextView tvContentUsername = findViewById(R.id.tv_content_username);
        TextView tvContentName = findViewById(R.id.tv_content_name);

        user_github userGithub_e1 = getIntent().getParcelableExtra(EXTRA_USER);
        Glide.with(this).load(userGithub_e1.getUrl_userpict()).into(ivContentPicUser);
        tvContentUsername.setText(userGithub_e1.getUsername());
        tvContentName.setText(userGithub_e1.getName());

    }
}