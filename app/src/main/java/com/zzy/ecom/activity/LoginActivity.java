package com.zzy.ecom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zzy.ecom.R;
import com.zzy.ecom.entities.TransApp;
import com.zzy.ecom.internet.WebAccessUtils;
import com.zzy.ecom.entities.User;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity {
    private EditText userNameE;
    private EditText passwordE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameE = (EditText)findViewById(R.id.user_name);
        passwordE = (EditText)findViewById(R.id.password);

        Button loginBtn = (Button)findViewById(R.id.login);
        Button registerBtn = (Button)findViewById(R.id.register);
        loginBtn.setOnClickListener(listener);
        registerBtn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login:
                    String userName = userNameE.getText().toString();
                    String password = passwordE.getText().toString();
                    if (userName.length() == 0) {
                        Toast.makeText(getApplicationContext(), "用户名不能为空",
                                Toast.LENGTH_LONG).show();
                        userNameE.setText("");
                        passwordE.setText("");
                    }
                    else if (password.length() == 0) {
                        Toast.makeText(getApplicationContext(), "密码不能为空",
                                Toast.LENGTH_LONG).show();
                        userNameE.setText("");
                        passwordE.setText("");
                    }
                    else {
                        User user = new User();
                        user.setLoginName(userName);
                        user.setPassword(password);
                        Gson gson = new GsonBuilder().setDateFormat(
                                "yyyy-MM-ddhh:mm:ss").create();
                        String user_data = gson.toJson(user);
                        List<NameValuePair> pairList = new ArrayList<NameValuePair>();
                        pairList.add(new BasicNameValuePair("user", user_data));
                        String response = WebAccessUtils.httpRequest("TODO", pairList);
                        if (response.trim().equals("failure")) {
                            Toast.makeText(getApplicationContext(), "账号或密码输入错误",
                                    Toast.LENGTH_LONG).show();
                        }
                        else {
                            //TODO
                            ((TransApp)getApplicationContext()).setUser(user);
                            Intent intent = new Intent(LoginActivity.this, MainMenu.class);
                            startActivity(intent);
                        }
                    }
                    break;
                case R.id.register:
                    Intent intent = new Intent(LoginActivity.this, MainMenu.class);
                    startActivity(intent);
                    break;
            }
        }
    };


}
