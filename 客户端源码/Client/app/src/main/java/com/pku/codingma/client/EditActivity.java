package com.pku.codingma.client;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class EditActivity extends AppCompatActivity {
    Button edit,delete;
    EditText account,name,sex,phone,age,pay;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result =  msg.obj.toString();

            Toast.makeText(EditActivity.this, result, Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        findView();
        setText();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    public void findView(){
        account = (EditText)findViewById(R.id.account);
        name = (EditText)findViewById(R.id.name);
        sex = (EditText)findViewById(R.id.sex);
        phone = (EditText)findViewById(R.id.phone);
        age = (EditText)findViewById(R.id.age);
        pay = (EditText)findViewById(R.id.pay);
        edit = (Button)findViewById(R.id.edit);
        delete = (Button)findViewById(R.id.delete);
    }
    public void setText(){
        Intent intent = getIntent();
        account.setText(intent.getStringExtra("account"));
        name.setText(intent.getStringExtra("name"));
        sex.setText(intent.getStringExtra("sex"));
        phone.setText(intent.getStringExtra("phone"));
        age.setText(intent.getStringExtra("age"));
        pay.setText(intent.getStringExtra("pay"));
        account.setEnabled(false);

    }

    public void edit() {
        //取得用户输入的账号和密码

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("account", account.getText().toString());
        params.put("name", name.getText().toString());
        params.put("sex", sex.getText().toString());
        params.put("phone", phone.getText().toString());
        params.put("age", age.getText().toString());
        params.put("pay", pay.getText().toString());

        try {
            String originAddress = "http://10.0.2.2:8080/as/EditServlet";
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

    public void delete() {
        //取得用户输入的账号和密码

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("account", account.getText().toString());

        try {
            String originAddress = "http://10.0.2.2:8080/as/DeleteServlet";
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
