package qainfeng.myshop.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.fragment.CallFragment;
import qainfeng.myshop.fragment.FindFragment;
import qainfeng.myshop.fragment.HomeFragment;
import qainfeng.myshop.fragment.LastFragment;
import qainfeng.myshop.fragment.MyFragment;

public class MainActivity extends AppCompatActivity {

    private String[] mTextViewArrs;//name的数组
    private int[] mTabImageId;	//选择器图片的id
    private FragmentTabHost mFth;
    //Fragment 的 字节码
    private List <Class> mFragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFth = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTextViewArrs = new String[] {"首页","最新揭晓","发现","购物车","我的活够"};
        //这是tab的图片选择器的id
        mTabImageId=new int[]{R.drawable.selecor_home,R.drawable.selecor_last,R.drawable.selecor_find,R.drawable.selecor_car,R.drawable.selecor_my};
        mFragmentList = new ArrayList<>();
        mFragmentList.add(HomeFragment.class);
        mFragmentList.add(LastFragment.class);
        mFragmentList.add(FindFragment.class);
        mFragmentList.add(CallFragment.class);
        mFragmentList.add(MyFragment.class);




        //关于FragmentTabHostca
        aboutTabHost();
    }

    private void aboutTabHost() {
        // 1.设置FragmentTabHost
        mFth.setup(getApplicationContext(), getSupportFragmentManager(),
                R.id.fl_content);
        for (int i = 0; i < mTextViewArrs.length; i++) {
            // 2.根据数组的个数创建tabSpec 也就是说给他设置一个别名
            TabHost.TabSpec tabSpec = mFth.newTabSpec(mTextViewArrs[i]);
            // 3.给tabSpec设置View 也就是上面一个ImageView下面一个TextView
            tabSpec.setIndicator(getItemView(i));
            // 4.把tabspc添加到FragmentTabHost中  第二个是Fragment 第三是 bundle 可以给Fragment传值
            //假如真的要传值的话  在Fragment中 getArguments()得到bundle 最好在oncreat中拿到
            //这是实验品  第二个参数可以用一个Class数组把Fragment封装起来
            mFth.addTab(tabSpec, mFragmentList.get(i), null);
            // 5.给tabSpec设置背景 也是个选择器
            // 6.去掉分割线 否则会出现短黑线
            mFth.getTabWidget().setDividerDrawable(android.R.color.transparent);
        }
    }

    private View getItemView(int i) {
        View view = View.inflate(getApplicationContext(), R.layout.tab_view,
                null);
        ImageView iv_tab = (ImageView) view.findViewById(R.id.iv_tab);
        TextView tv_tab_name = (TextView) view.findViewById(R.id.tv_tab_name);
        //改imageView设置src 图片为选择器
        iv_tab.setImageResource(mTabImageId[i]);
        //设置文字
        tv_tab_name.setText(mTextViewArrs[i]);

        return view;
    }
}
