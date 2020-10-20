package com.zephyr.githubuserapp.layout_controller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);

        final ListView userGithubListview = findViewById(R.id.usergithub_listview);
        userGithubAdapter = new UserGithubAdapter(this);
        userGithubListview.setAdapter(userGithubAdapter);

        setData();
        attachData();

        userGithubListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //ArrayList<user_github> usersGithub = new ArrayList<>();
                user_github userGithub = new user_github();
                userGithub.setUrl_userpict(dataProfilePict[i]);
                userGithub.setUsername(dataUsername[i]);
                userGithub.setName(dataName[i]);

                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                intent.putExtra(ContentActivity.EXTRA_USER, userGithub);
                startActivity(intent);
            }
        });

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