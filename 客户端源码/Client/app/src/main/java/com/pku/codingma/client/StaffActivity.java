package com.pku.codingma.client;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaffActivity extends AppCompatActivity {

    ListView listView;
    List<HashMap<String, Object>> listdata;
    HashMap<String, Object> data;
    public JSONObject object;
    Button query,add;
    EditText editText;
    JSONArray resultJsonArray;
    SimpleAdapter adapter;


    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result =  msg.obj.toString();

            setListView();

            //Toast.makeText(StaffActivity.this, result, Toast.LENGTH_LONG).show();

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        setView();
        send("http://10.0.2.2:8080/as/StaffServlet");
        setListView();

        query.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listdata.clear();
                String str = editText.getText().toString();
                String url = "http://10.0.2.2:8080/as/QueryServlet?account="+str;
                send(url);
                adapter.notifyDataSetChanged();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffActivity.this,AddActivity.class);
                StaffActivity.this.startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, Object> itemdata = listdata.get(position);
                Intent intent = new Intent(StaffActivity.this,EditActivity.class);
                intent.putExtra("account",itemdata.get("account").toString());
                intent.putExtra("name",itemdata.get("name").toString());
                intent.putExtra("sex",itemdata.get("sex").toString());
                intent.putExtra("phone",itemdata.get("phone").toString());
                intent.putExtra("age",itemdata.get("age").toString());
                intent.putExtra("pay",itemdata.get("pay").toString());
                StaffActivity.this.startActivity(intent);
            }
        });

    }


    public  void  setView(){
        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText)findViewById(R.id.edit_query);
        query = (Button)findViewById(R.id.queButton);
        add = (Button)findViewById(R.id.addButton);
        listdata = new ArrayList<HashMap<String, Object>>();
    }
    public void setListView(){
        String[] from  = {"account","name","sex","phone","age","pay"};
        int[] to = {R.id.account,R.id.name, R.id.sex, R.id.phone,R.id.age, R.id.pay};
        adapter = new SimpleAdapter(StaffActivity.this,listdata,R.layout.activity_staff_item,from,to);
        listView.setAdapter(adapter);
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
                    mHandler.sendMessage(message);
                }
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

    private void jsonJX(String date) {
        //判断数据是空
        if(date!=null){
            try {
                //将字符串转换成jsonObject对象
                JSONObject jsonObject = new JSONObject(date);

                    //获取到json数据中里的数组内容
                    resultJsonArray = jsonObject.getJSONArray("staff");
                    //遍历
                    for(int i=0;i<resultJsonArray.length();i++){
                        object=resultJsonArray.getJSONObject(i);
                        data = new HashMap<String, Object>();

                        try {
                            String account = object.getString("account");
                            String name = object.getString("name");
                            String sex = object.getString("sex");
                            String phone = object.getString("phone");
                            String age = object.getString("age");
                            String pay = object.getString("pay");

                            data.put("account",account);
                            data.put("name",name);
                            data.put("sex",sex);
                            data.put("phone",phone);
                            data.put("age",age);
                            data.put("pay",pay);
                            listdata.add(data);

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
