package com.pku.codingma.client;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText username;
    private EditText password;
    private Button mLoginButton;
    private Button register;
    private Button admin;
    private String originAddress = "http://10.0.2.2:8080/as/LoginServlet";

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result = "";
            Intent intent=new Intent();

            if ("true".equals(msg.obj.toString())){
                result = "登录成功";
                intent.setClass(MainActivity.this,StaffActivity.class);
                startActivity(intent);
            }else if ("false".equals(msg.obj.toString())){
                result = "账号或密码错误";
            }else {
                result = msg.obj.toString();
            }
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {

        username = (EditText) findViewById(R.id.loginaccount);
        password = (EditText) findViewById(R.id.loginpassword);
        mLoginButton = (Button) findViewById(R.id.loginButton);
        register = (Button)findViewById(R.id.reg);
        admin = (Button)findViewById(R.id.admin);
    }

    private void initEvent() {
        mLoginButton.setOnClickListener(this);
        register.setOnClickListener(this);
        admin.setOnClickListener(this);
    }

    public void login() {

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("username", username.getText().toString());
        params.put("password", password.getText().toString());
        try {
            String compeletedURL = HttpUtil.getURLWithParams(originAddress, params);
            HttpUtil.sendHttpRequest(compeletedURL, new HttpCallbackListener() {
                @Override
                public void onFinish(String response) {
                    Message message = new Message();
                    message.obj = response;
                    mHandler.sendMessage(message);
                }

                @Override
                public void onError(Exception e) {
                    Message message = new Message();
                    message.obj = e.toString();
                    mHandler.sendMessage(message);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:
                login();
                break;
            case R.id.reg:
                Intent intent = new Intent(MainActivity.this,RegActivity.class);
                startActivity(intent);
            case R.id.admin:
                if("admin".equals(username.getText().toString()) &&"admin".equals(password.getText().toString())){
                    Intent intent2 = new Intent(MainActivity.this,AdminActivity.class);
                    startActivity(intent2);
                }

        }
    }



}
