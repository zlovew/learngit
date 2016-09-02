package qainfeng.myshop.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;
import java.util.List;

import qainfeng.myshop.NetConstant.NetConstant;
import qainfeng.myshop.R;
import qainfeng.myshop.activity.MainActivity;
import qainfeng.myshop.adapter.HomeAdapter;
import qainfeng.myshop.adapter.HomeShopAdapter;
import qainfeng.myshop.application.MyApplication;
import qainfeng.myshop.bean.HomeViewPagerBean;
import qainfeng.myshop.bean.HornBean;
import qainfeng.myshop.bean.ListShopBean;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class HomeFragment extends BaseFragment {
    private FragmentManager fragmentManager;
    private ListView mListView;
    private LinearLayout mFloatingLayout;
    private RequestQueue mRequestQueue;
    private RollPagerView mViewPager;
    private  View mHeaderView;
    private List<HomeViewPagerBean> mViewPagerData;
    private List<HornBean.ListBean> mHornBeanData;
    private HomeAdapter mHomeAdapter;
    private HomeShopAdapter mHomeShopAdapter;
    private TextView mTextViewLaBa;
    private TextView mTextViewTotal;
    private TextView mTextViewNewInfo1,mTextViewNewInfo2,mTextViewNewInfo3;
    private ImageView mImageNewPicture1,mImageNewPicture2,mImageNewPicture3;
    private List<ListShopBean.ListBean> mData;
    private int position = 0;
    private Handler mHandler;
    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        mFloatingLayout = (LinearLayout) view.findViewById(R.id.ll_floating);
        mListView = (ListView) view.findViewById(R.id.lv_home_show);
        mHeaderView = View.inflate(getActivity(), R.layout.home_header, null);
        mTextViewLaBa = (TextView) mHeaderView.findViewById(R.id.tv_laba_info);
        mTextViewTotal = (TextView) mHeaderView.findViewById(R.id.tv_new_total);
        mViewPager = (RollPagerView) mHeaderView.findViewById(R.id.rpv_home_picture);
        //最新揭晓
        mImageNewPicture1 = (ImageView) mHeaderView.findViewById(R.id.iv_new_picture1);
        mImageNewPicture2 = (ImageView) mHeaderView.findViewById(R.id.iv_new_picture2);
        mImageNewPicture3 = (ImageView) mHeaderView.findViewById(R.id.iv_new_picture3);

        mTextViewNewInfo1 = (TextView) mHeaderView.findViewById(R.id.tv_new_info1);
        mTextViewNewInfo2 = (TextView) mHeaderView.findViewById(R.id.tv_new_info2);
        mTextViewNewInfo3 = (TextView) mHeaderView.findViewById(R.id.tv_new_info3);

        mListView.addHeaderView(mHeaderView);//头部内容
        mListView.addHeaderView(View.inflate(getActivity(), R.layout.fragment_listview_floating, null));//ListView条目中的悬浮部分 添加到头部
        return view;
    }




    @Override
    public void initData() {
        loadLaBaData();
        loadData();
        loadListData();
        setListener();
        //小喇叭
        //Toast.makeText(getActivity(), "数据是"+mHornBeanData.get(0).getUser_name(), Toast.LENGTH_SHORT).show();
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                String name = mHornBeanData.get(position).getUser_name();
                mTextViewLaBa.setText("恭喜 "+mHornBeanData.get(position).getUser_name()+" 获得[实时到账]50元购物卡");
                position++;
                if (position == mHornBeanData.size()){
                    position =0;
                }
                sendEmptyMessageDelayed(1,3000);
                super.handleMessage(msg);
            }
        };
    }

    private void loadListData() {
        mRequestQueue = MyApplication.getRequestQeue();
        StringRequest mRequest2 = new StringRequest(Request.Method.GET, NetConstant.HOME_LIST_PATH, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseHomeListJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "加载错误", Toast.LENGTH_SHORT).show();
            }
        });
        //给这个请求设置一个tag
        mRequest2.setTag("get3");
        mRequestQueue.add(mRequest2);
    }
    private void parseHomeListJson(String response) {
        Gson gson = new Gson();
        ListShopBean listShopBean = gson.fromJson(response, ListShopBean.class);
        mData = new ArrayList<>();
        mData.addAll(listShopBean.getList());
        mHomeShopAdapter = new HomeShopAdapter(getActivity(),mData);
        mListView.setAdapter(mHomeShopAdapter);
        mHomeShopAdapter.notifyDataSetChanged();
    }
    private void setListener() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >=1) {
                    mFloatingLayout.setVisibility(View.VISIBLE);
                   // mHeaderView.setVisibility(View.GONE);
                } else {
                    mFloatingLayout.setVisibility(View.GONE);
                    //mHeaderView.setVisibility(View.VISIBLE);
                }
            }
        });
        mTextViewTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                LastFragment lf =new LastFragment();
//                fragmentManager.beginTransaction().replace(R.id.fl_content,lf).addToBackStack(null).commit();
                Intent intent = new Intent(getActivity(),MainActivity.class);
                intent.putExtra("userloginflag",1);
                startActivity(intent);
            }
        });

    }

    private void loadLaBaData() {
        mRequestQueue = MyApplication.getRequestQeue();
        StringRequest mRequest2 = new StringRequest(Request.Method.GET, NetConstant.LABA_PATH, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getActivity(), "喇叭数据11111是"+response, Toast.LENGTH_LONG).show();
               // Log.i("TAG","喇叭数据1111是"+response);
                parseLabaJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "加载错误", Toast.LENGTH_SHORT).show();
            }
        });
        //给这个请求设置一个tag
        mRequest2.setTag("get2");
        mRequestQueue.add(mRequest2);
    }
    public void parseLabaJson(String response){
        Gson gson = new Gson();
        HornBean hornBean = gson.fromJson(response, HornBean.class);
        mHornBeanData = new ArrayList<>();
        mHornBeanData.addAll(hornBean.getList());
        mHandler.sendEmptyMessageDelayed(1,2000);
        //Toast.makeText(getActivity(), "喇叭数据222222是"+mHornBeanData.get(0).getUser_name().toString(), Toast.LENGTH_LONG).show();
        //Log.i("TAG","喇叭数据2222是"+mHornBeanData.toString());
    }
    private void loadData() {
        mRequestQueue = MyApplication.getRequestQeue();
        StringRequest mRequest = new StringRequest(Request.Method.GET, NetConstant.HOME_VIEWPAGER_PATH, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getActivity(), "数据是"+response, Toast.LENGTH_SHORT).show();
                parseJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "加载错误", Toast.LENGTH_SHORT).show();
            }
        });
        //给这个请求设置一个tag
        mRequest.setTag("get");
        mRequestQueue.add(mRequest);
    }
    private void parseJson(String response) {
        List<HomeViewPagerBean> homeViewPagerBeen = HomeViewPagerBean.arrayHomeViewPagerBeanFromData(response);
        mViewPagerData = new ArrayList<>();
        mViewPagerData.addAll(homeViewPagerBeen);
        mHomeAdapter = new HomeAdapter(getActivity(),mViewPagerData);
        mViewPager.setAdapter(mHomeAdapter);
        //刷新适配器
        mHomeAdapter.notifyDataSetChanged();
    }
}
