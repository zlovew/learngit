package com.qianfeng.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    LinearLayout ll_floating;
    String[] listDatas = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<listDatas.length;i++){
            listDatas[i] = "邓肯和波波--" + i;
        }

        ll_floating = (LinearLayout) findViewById(R.id.ll_floating);
        lv = (ListView) findViewById(R.id.lv);
        lv.addHeaderView(View.inflate(this, R.layout.listview_header, null));//头部内容
        lv.addHeaderView(View.inflate(this, R.layout.listview_floating, null));//ListView条目中的悬浮部分 添加到头部
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listDatas));
        //listview 滑动监听
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 1) {
                    ll_floating.setVisibility(View.VISIBLE);
                } else {
                    ll_floating.setVisibility(View.GONE);
                }
            }
        });
    }
}
