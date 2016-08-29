package qainfeng.myshop.fragment;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.adapter.SelectAdapter;
import qainfeng.myshop.application.MyApplication;
import qainfeng.myshop.bean.NetLastAllBean;
import qainfeng.myshop.bean.SelectItemBean;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class LastFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public static final String TAG="LastFragment";

    private TextView mTextViewTitle;
    private ListView mListViewSelect;
    private ListView mListViewLast;
    private List<SelectItemBean> mSelectItemBeen;
    private String[] shoppiingItem;
    private SelectAdapter mSelectAdapter;
    private RelativeLayout mRelativeLayout;
    private RequestQueue mRequestQeue;
    private Button mButton;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_lat, null);
        mTextViewTitle = (TextView) view.findViewById(R.id.tv_title_select);
        mListViewSelect = (ListView) view.findViewById(R.id.lv_select);
//        mListViewLast = (ListView) view.findViewById(R.id.lv_last);
        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.rl_contoner);
        mButton = (Button) view.findViewById(R.id.id);
        return view;
    }

    @Override
    public void initData() {
        //设置选择的listview
        mSelectItemBeen = new ArrayList<>();
        shoppiingItem = new String[]{"全部商品", "手机平板", "电脑办公", "数码影音", "家用电器", "钟表首饰", "饰品材料", "虚拟专区", "其他商品"};

        //下载数据
        dwonload();

        //数据源
        for(int i = 0 ; i<shoppiingItem.length; i++) {
SelectItemBean selectItemBean = new SelectItemBean();
            if (i == 0) {
                selectItemBean.setSelected(true);
            } else {
                selectItemBean.setSelected(false);
            }
            selectItemBean.setShoppingItem(shoppiingItem[i]);
            mSelectItemBeen.add(selectItemBean);
        }
        mSelectAdapter = new SelectAdapter(mSelectItemBeen, getActivity());
        mListViewSelect.setAdapter(mSelectAdapter);
        //设置各种监听
        setListener();
    }

    private void dwonload() {
        mRequestQeue = MyApplication.getRequestQeue();
        StringRequest request = new StringRequest(Request.Method.GET, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //解析 数据
                parseData(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void parseData(String response) {
        Gson gson = new Gson();
        NetLastAllBean netLastAllBean = gson.fromJson(response, NetLastAllBean.class);

    }

    private void setListener() {
        mRelativeLayout.setOnClickListener(this);
        mListViewSelect.setOnItemClickListener(this);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.rl_contoner:
                int visibility = mListViewSelect.getVisibility();
                //如果打开了 就关闭  就打开
                if(visibility==View.GONE||visibility==View.INVISIBLE){
                    // 执行动画 让他进来
                    initInAnim();
                    mListViewSelect.setVisibility(View.VISIBLE);
                    mListViewSelect.setEnabled(true);
                }else if(visibility==View.VISIBLE){
//                    //  执行动画
                    initOutAnim();
                    mListViewSelect.setVisibility(View.GONE);
                    mListViewSelect.setEnabled(false);///////////////////////////还是能点
                }
                //改变flag
                break;
            case R.id.id:
                Toast.makeText(mActivity, "11111111111", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initInAnim() {
        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,Animation. RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, -1,Animation. RELATIVE_TO_SELF, 0);
        //还有两个Type Animation.RELATIVE_TO_PARENT相对于父亲    Animation.ABSOLUTE(绝对的  很少用到) 后面的是自己打大小
        ta.setDuration(1000);//设置时间
        ta.setFillAfter(true);
        mListViewSelect.startAnimation(ta);//把图片设置到动画中

    }

    private void initOutAnim() {
        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,Animation. RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,Animation. RELATIVE_TO_SELF, -1);
        //还有两个Type Animation.RELATIVE_TO_PARENT相对于父亲    Animation.ABSOLUTE(绝对的  很少用到) 后面的是自己打大小
        ta.setDuration(1000);//设置时间
        ta.setFillAfter(true);//设置是否停留在动画之后的结果
        mListViewSelect.startAnimation(ta);//把图片设置到动画中

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("ssssss", "sssssssssss");
        switch (parent.getId()) {
            //点击商品类的条目时
            case R.id.lv_select:
                Log.i("ssssss", "ddddddddddddd");
                //把其他的设置成false
                for (int i =0 ; i<mSelectItemBeen.size(); i++) {
                    mSelectItemBeen.get(i).setSelected(false);
                }
                //当前条目设置为true
                mSelectItemBeen.get(position).setSelected(true);
                //刷新适配器
                mSelectAdapter.notifyDataSetChanged();
                //并且推出去
                initOutAnim();
                break;
        }
    }
}
