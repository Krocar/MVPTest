package com.example.asus.mvptest;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import adapter.LogisticsAdapter;
import base.BaseActivity;
import bean.PostQueryInfo;
import persenter.PostPresenter;
import utils.RetrofitUtils;
import view.MainView;

@SuppressLint("Registered")
public class MainActivity extends BaseActivity implements View.OnClickListener, MainView {
    private EditText post_name_et;
    private EditText post_id_et;
    private ListView post_list_lv;
    private Button post_search_bn;
    private PostPresenter postPresenter;
    private List<PostQueryInfo.DataBean> dataArray = new ArrayList<>();
    private LogisticsAdapter logisticsAdapter;
    
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitUtils.getInstance().initOkHttp(this);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        post_name_et = (EditText)findViewById(R.id.post_company_name);
        post_id_et = (EditText)findViewById(R.id.post_id_num);
        post_list_lv = (ListView) findViewById(R.id.post_list_lv);
        post_search_bn = (Button)findViewById(R.id.post_search_bt);
    }

    private void initData() {
        logisticsAdapter = new LogisticsAdapter(getApplicationContext(),dataArray);
        postPresenter = new PostPresenter(this);
       // System.out.println("打印东西："+postPresenter);
        post_list_lv.setAdapter(logisticsAdapter);
    }

    private void initEvent() {
        post_search_bn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.post_search_bt:
                System.out.println("打印东西："+"name:"+post_name_et.getText().toString()+" "+"id:"+post_id_et.getText().toString());
                postPresenter.requestHomeData(post_name_et.getText().toString(),post_id_et.getText().toString());
                break;
        }
    }

    @Override
    public void updateListUI(PostQueryInfo postQueryInfo) {
        dataArray.clear();
        dataArray.addAll(postQueryInfo.getData());
        logisticsAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        //防止activi销毁，postPresenter对象还存在造成的内存泄漏
        if(postPresenter != null && !postPresenter.equals("")) postPresenter.detach();
        super.onDestroy();
    }
}
