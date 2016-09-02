package qainfeng.myshop.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.adapter.RecordAdapter;
import qainfeng.myshop.fragment.CallFragment;

public class RecordActivity extends AppCompatActivity {
    private TextView mTextView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mImageView;
    private ListView mListView;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private RecordAdapter mRecordAdapter;
    private PopupWindow mPopupWindow;
    private List<String> mData;
    private boolean popFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        initView();
        initData();
        setData();
        setListener();
    }

    private void setListener() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popFlag){
                    mPopupWindow.dismiss();
                    popFlag=false;
                }else{
//                    mPopupWindow.showAtLocation(mTextView, Gravity.BOTTOM,0,0);
                    mPopupWindow.showAsDropDown(mTextView);
                    popFlag=true;
                }
            }
        });
    }

    private void setData() {

    }

    private void initData() {
        mFragments=new ArrayList<>();
        mTitles=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mFragments.add(new CallFragment());
        }
        mTitles.add("全部");
        mTitles.add("进行中");
        mTitles.add("已揭晓");
        mTitles.add("pk记录");
        mRecordAdapter = new RecordAdapter(getSupportFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(mRecordAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


    }

    private void initView() {
        mImageView= (ImageView) findViewById(R.id.iv_record_back);
        mTabLayout= (TabLayout) findViewById(R.id.tl_record_title);
        mTextView= (TextView) findViewById(R.id.tv_record_select);
        mViewPager= (ViewPager) findViewById(R.id.vp_record_content);
        initPopWindow();
    }

    private void initPopWindow() {
        View view = View.inflate(this, R.layout.popwindow_record, null);
        mListView= (ListView) view.findViewById(R.id.lv_pop_record);
        mData=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("ss"+i);
        }
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,mData);
        mListView.setAdapter(adapter);
        mPopupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        mPopupWindow.setFocusable(true);
        ColorDrawable colorDrawable=new ColorDrawable(0xff0000);
        mPopupWindow.setBackgroundDrawable(colorDrawable);
        mPopupWindow.setAnimationStyle(R.style.popwin_anim_style);
    }
}
