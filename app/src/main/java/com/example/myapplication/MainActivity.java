package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.api.ApiService;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView btn_login, quenmk;

    EditText username, password;

    ImageView facebook, intargam, youtube;

    //code test
    private List<User> mlistuser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        mlistuser = new ArrayList<>();


        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        btn_login = findViewById(R.id.btn_login);
        facebook = findViewById(R.id.facebook);
        intargam = findViewById(R.id.intargam);
        quenmk = findViewById(R.id.quenmk);
        youtube = findViewById(R.id.youtube);

        quenmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.facebook.com/hutechuniversity");
            }
        });

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoURL("https://www.youtube.com/watch?v=x4Q7jaiUM74&ab_channel=HUTECHChannel");
            }
        });

        intargam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        getlistuse();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, Home.class);
                //startActivity(intent);
                //callapi();

                clicklogin();

            }
        });


    }

    //code test

    private void getlistuse(){
        ApiService.apiService.converUser("usename").enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mlistuser = response.body();
                Log.e("List user", mlistuser.size() + "");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call api Errorr", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clicklogin(){
        String usename = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(mlistuser.isEmpty()|| mlistuser == null){
            return;
        }
        boolean isuser = false;
        for(User user:mlistuser){
            if (usename.equals(user.getUsename())&& pass.equals(user.getPass())){
                isuser = true;
                break;
            }
        }
        if(isuser){
            Toast.makeText(MainActivity.this, "Call api success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "Call api failed", Toast.LENGTH_SHORT).show();
        }
    }



//code chính
/*    private void callapi(){
        ApiService.apiService.convertUser("1811061600", "123456").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                Toast.makeText(MainActivity.this, "Call api success", Toast.LENGTH_SHORT).show();
                User user = response.body();
                if(user != null){
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Call api failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call api Errorr", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    private void gotoURL(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}