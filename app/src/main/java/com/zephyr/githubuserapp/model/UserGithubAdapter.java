package com.zephyr.githubuserapp.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zephyr.githubuserapp.R;

import java.net.URL;
import java.util.ArrayList;

public class UserGithubAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<user_github> githubUsers = new ArrayList<user_github>();

    public void setGithubUsers(ArrayList<user_github> githubUsers1){
        githubUsers = githubUsers1;
    }

    public ArrayList<user_github> getGithubUsers(){
        return githubUsers;
    }

    public UserGithubAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return githubUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return githubUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.layout_userlist, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        user_github userGithub = (user_github)getItem(position);
        viewHolder.bind(userGithub);
        return itemView;

    }

    private class ViewHolder{
        private ImageView ivPicUserGithub;
        private TextView tvUsernameGithub;
        private TextView tvNameGithub;

        ViewHolder(View view){
            ivPicUserGithub = view.findViewById(R.id.iv_picuser);
            tvUsernameGithub = view.findViewById(R.id.tv_username);
            tvNameGithub = view.findViewById(R.id.tv_name);
        }
        void bind(user_github user_github1){
            //ivPicUserGithub.setImageResource(user_github1.getUser_pict());
            Glide.with(context).load(user_github1.getUrl_userpict()).into(ivPicUserGithub);
            tvUsernameGithub.setText(user_github1.getUsername());
            tvNameGithub.setText(user_github1.getName());
        }
    }

}

