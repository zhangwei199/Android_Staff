package com.pku.codingma.client;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class RegActivity extends AppCompatActivity {

    Button register;
    EditText account,password,password2;


    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result =  msg.obj.toString();

            Toast.makeText(RegActivity.this, result, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findView();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = account.getText().toString();
                String p0 = password.getText().toString();
                String p1 = password2.getText().toString();
                if(!"".equals(text) && !"".equals(p0) ){
                    if(p0.equals(p1)){
                        register();
                    }else{
                        Toast.makeText(RegActivity.this, "两次密码不一致", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(RegActivity.this, "请输入账号和密码", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void findView(){
        account = (EditText)findViewById(R.id.account);
        password = (EditText)findViewById(R.id.password);
        password2 = (EditText)findViewById(R.id.password2);
        register = (Button)findViewById(R.id.register);
    }

    public void register() {
        //取得用户输入的账号和密码

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("account", account.getText().toString());
        params.put("password", password.getText().toString());
        params.put("password2", password.getText().toString());

        try {
            String originAddress = "http://10.0.2.2:8080/as/RegServlet";
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
}
