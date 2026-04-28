package com.example.final1901175;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    static RequestQueue requestQueue;
    EditText nameEt;
    EditText numberEt;
    RecyclerView noticeRv;
    NoticeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEt = findViewById(R.id.nameEt);
        numberEt = findViewById(R.id.numEt);
        noticeRv = findViewById(R.id.noticeRv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        noticeRv.setLayoutManager(layoutManager);
        adapter = new NoticeAdapter();
        noticeRv.setAdapter(adapter);
        adapter.setDeleteClickListener(new clickListener() {
            @Override
            public void onItemclick(NoticeVO vo) {
                deleteNotice(vo);
            }
        });
        adapter.setUpdateClickListener(new clickListener() {
            @Override
            public void onItemclick(NoticeVO vo) {
                updateNotice(vo);
            }
        });
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }

    public void insertNotice(View view) {
        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.0.6:8086/notice/addNoticejson.do",new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                Gson gson = new Gson();
                NoticeVOList noticeList = gson.fromJson(response, NoticeVOList.class);
                adapter.items = noticeList.noticeList;
                adapter.notifyDataSetChanged();
                //processResponse(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("에러 -> " + error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("name",nameEt.getText().toString());
                params.put("number",numberEt.getText().toString());
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }
    public void deleteNotice(NoticeVO vo) {
        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.0.6:8086/notice/deleteNoticejson.do",new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                Gson gson = new Gson();
                NoticeVOList noticeList = gson.fromJson(response, NoticeVOList.class);
                adapter.items = noticeList.noticeList;
                adapter.notifyDataSetChanged();
                //processResponse(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("에러 -> " + error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("name",vo.getName());
                params.put("number",vo.getNumber());
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }
    public void updateNotice(NoticeVO vo) {
        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.0.6:8086/notice/updateNoticejson.do",new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                Gson gson = new Gson();
                NoticeVOList noticeList = gson.fromJson(response, NoticeVOList.class);
                adapter.items = noticeList.noticeList;
                adapter.notifyDataSetChanged();
                //processResponse(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("에러 -> " + error.getMessage());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("name",vo.getName());
                params.put("number",vo.getNumber());
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
    }
}