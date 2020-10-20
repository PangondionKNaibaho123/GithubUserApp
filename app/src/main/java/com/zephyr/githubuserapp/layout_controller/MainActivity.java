package com.zephyr.githubuserapp.layout_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.zephyr.githubuserapp.R;
import com.zephyr.githubuserapp.model.UserGithubAdapter;
import com.zephyr.githubuserapp.model.user_github;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserGithubAdapter userGithubAdapter;
    private String[] dataProfilePict;
    private String[] dataUsername;
    private String[] dataName;
    private ArrayList<user_github> githubUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView userGithubListview = findViewById(R.id.usergithub_listview);
        userGithubAdapter = new UserGithubAdapter(this);
        userGithubListview.setAdapter(userGithubAdapter);

        setData();
        attachData();

    }

    private void setData(){
        dataProfilePict = getResources().getStringArray(R.array.urlUserPict);
        dataUsername = getResources().getStringArray(R.array.username);
        dataName = getResources().getStringArray(R.array.name);
    }

    private void attachData(){
        githubUsers = new ArrayList<>();

        for(int i=0; i< dataName.length; i++){
            user_github userGithub = new user_github();
            userGithub.setUrl_userpict(dataProfilePict[i]);
            userGithub.setUsername(dataUsername[i]);
            userGithub.setName(dataName[i]);
            githubUsers.add(userGithub);
        }
        userGithubAdapter.setGithubUsers(githubUsers);
    }

}