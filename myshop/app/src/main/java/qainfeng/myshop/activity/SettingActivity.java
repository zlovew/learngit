package qainfeng.myshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.adapter.SetRecViewAdapter;

public class SettingActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mData;
    private List<String> mSub;
    private SetRecViewAdapter mSetRecViewAdapter;
    private LinearLayoutManager mManager;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initData();
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add("帮助中心");
        mData.add("意见反馈");
        mData.add("无图模式");
        mData.add("清除缓存");
        mData.add("版本检测");
        mData.add("关于我们");
        mData.add("服务协议");
        mSub = new ArrayList<>();
        mSub.add("");
        mSub.add("");
        mSub.add("建议在3G环境下开启节省流量");
        mSub.add("0.22MB");
        mSub.add("");
        mSub.add("");
        mSub.add("");
        mSetRecViewAdapter = new SetRecViewAdapter(this, mData, mSub);
        mSetRecViewAdapter.setOnItemClickListener(new SetRecViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String data) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(SettingActivity.this, HelpActivity.class));
                        break;
                }
            }
        });
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setAdapter(mSetRecViewAdapter);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_setting_content);
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ivBack = (ImageView) findViewById(R.id.iv_head_setting_back);
    }
}
