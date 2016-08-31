package qainfeng.myshop.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import qainfeng.myshop.NetConstant.NetConstant;
import qainfeng.myshop.R;
import qainfeng.myshop.activity.WebViewActivity;
import qainfeng.myshop.adapter.FindAdapter;
import qainfeng.myshop.application.MyApplication;
import qainfeng.myshop.bean.NetFindBean;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class FindFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private List<NetFindBean.FindListBean> mFindList ;
    private FindAdapter mAdapter1;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_find, null);
        mListView = (ListView) view.findViewById(R.id.lv_find);
        return view;
    }

    @Override
    public void initData() {
        mFindList = new ArrayList<>();
        //设置适配器
        mAdapter1 = new FindAdapter(mFindList, mActivity);
        mListView.setAdapter(mAdapter1);
        //下载东西 并且解析
        download();
        //设置点击侦听
        setlistener();

    }

    private void setlistener() {
        mListView.setOnItemClickListener(this);
    }

    private void download() {
        RequestQueue requestQeue = MyApplication.getRequestQeue();
        StringRequest request = new StringRequest(Request.Method.GET, NetConstant.FIND_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                NetFindBean findListBean = gson.fromJson(response, NetFindBean.class);
                mFindList.addAll(findListBean.getFindList());
                mAdapter1.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //添加到请求队列中
        requestQeue.add(request);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(mActivity, WebViewActivity.class);
        intent.putExtra("url", mFindList.get(position).getUrl());
        startActivity(intent);
    }
}
