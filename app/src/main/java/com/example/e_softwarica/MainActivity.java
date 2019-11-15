package com.example.e_softwarica;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_softwarica.models.LocalUser;
import com.example.e_softwarica.models.User;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etuser;
    private EditText etpass;
    private Button btnlogin;
    static List<User> users = new ArrayList<>();
    static List<LocalUser> localUserList = new ArrayList<>();
    LocalUser localUser = new LocalUser();
    LocalUser localUser2=new LocalUser();
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); //hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enables fullscreen
        setContentView(R.layout.activity_main);
        etuser = findViewById(R.id.etuser);
        etpass = findViewById(R.id.etpass);
        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (localUserList.size() == 0) {
            localUser.setName("kishor");
            localUser.setAge("45");
            localUser.setAddress("kapan");
            localUser.setGender("Male");
            localUserList.add(localUser);
            localUser.setUserList(localUserList);


            LocalUser localUser2 = new LocalUser();
            localUser2.setName("jan");
            localUser2.setAge("50");
            localUser2.setAddress("kritipur");
            localUser2.setGender("Female");
            localUserList.add(localUser2);
            localUser2.setUserList(localUserList);
        }
        ;
        user.setUsername("kishor");
        user.setPassword("170057");
        users.add(user);
        user.setUserList(users);

        if (TextUtils.isEmpty(etuser.getText().toString())) {
            etuser.setError("please enter username");
        } else if (TextUtils.isEmpty(etpass.getText().toString())) {
            etpass.setError("please enter password");
        } else {
            String username = etuser.getText().toString().trim();
            String password = etpass.getText().toString().trim();

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            Boolean status = user.userLogin();
            if (status) {
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Username or password dont match", Toast.LENGTH_SHORT).show();
                etuser.setText("");
                etpass.setText("");
            }



        }
    }

}
