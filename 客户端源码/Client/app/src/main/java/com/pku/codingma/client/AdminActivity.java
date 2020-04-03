package com.pku.codingma.client;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    Button reset,remove;
    Spinner spinner;
    JSONArray resultJsonArray;
    JSONObject object;
    List<String> list;
    ArrayAdapter<String> adapter;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result =  msg.obj.toString();
            Toast.makeText(AdminActivity.this, result, Toast.LENGTH_LONG).show();

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setView();
        send("http://10.0.2.2:8080/as/AdminServlet");
        adapter = new ArrayAdapter<String>(AdminActivity.this,android.R.layout.simple_spinner_item, list);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = spinner.getSelectedItem().toString();
                if(!"请选择账号...".equals(str)){
                    send("http://10.0.2.2:8080/as/ResetServlet?account="+str);
                    Toast.makeText(AdminActivity.this,"重置成功", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(AdminActivity.this,"请选择账号...", Toast.LENGTH_LONG).show();
                }

            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = spinner.getSelectedItem().toString();
                if(!"请选择账号...".equals(str)){
                    send("http://10.0.2.2:8080/as/RemoveServlet?account="+str);
                    Toast.makeText(AdminActivity.this,"销毁成功", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(AdminActivity.this,"请选择账号...", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void setView(){
        spinner = (Spinner)findViewById(R.id.spinner);
        reset = (Button)findViewById(R.id.reset);
        remove = (Button)findViewById(R.id.remove);
        list = new ArrayList<String>();
        list.add("请选择账号...");
    }

    public void send(String url) {

        try {
            HttpUtil.sendHttpRequest(url, new HttpCallbackListener() {
                public void onFinish(String response) {
                    Message message = new Message();
                    message.obj = response;
                    String date = response;
                    //把数据传入解析josn数据方法
                    jsonJX(date);
                    //mHandler.sendMessage(message);
                }
                public void onError(Exception e) {
                    Message message = new Message();
                    message.obj = e.toString();
                    //mHandler.sendMessage(message);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jsonJX(String date) {
        //判断数据是空
        if (date != null) {
            try {
                //将字符串转换成jsonObject对象
                JSONObject jsonObject = new JSONObject(date);

                //获取到json数据中里的数组内容
                resultJsonArray = jsonObject.getJSONArray("users");

                //遍历
                for (int i = 0; i < resultJsonArray.length(); i++) {
                    object = resultJsonArray.getJSONObject(i);

                    try {
                        String account = object.getString("Account");
                        list.add(account);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Message message = new Message();
                    message.what = 1;
                    // mHandler.sendMessage(message);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
