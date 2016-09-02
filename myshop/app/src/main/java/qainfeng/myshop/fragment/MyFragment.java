package qainfeng.myshop.fragment;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

import qainfeng.myshop.R;
import qainfeng.myshop.activity.LoginActivity;
import qainfeng.myshop.activity.RecordActivity;
import qainfeng.myshop.adapter.MineRecViewAdapter;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class MyFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private MineRecViewAdapter mAdapter;
    private int[] mArr = new int[]{R.mipmap.ic_my_buy_record,R.mipmap.ic_my_get_goods,R.mipmap.ic_my_shaidan,R.mipmap.icon_prize,R.mipmap.red_pack,R.mipmap.ic_my_account_detail,R.mipmap.ic_my_address,R.mipmap.hg_icon_cs};

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.rv_mine_content);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new MineRecViewAdapter(getActivity(),mArr);
        mAdapter.addDatas(generateData());
        setHeader(mRecyclerView);
        mAdapter.setOnItemClickListener(new MineRecViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String data) {
//                Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();

                if(position==0){
                    startActivity(new Intent(getActivity(),RecordActivity.class));
                }else{
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    private ArrayList<String> generateData() {
        ArrayList<String> list=new ArrayList<>();
        list.add("我的伙购记录");
        list.add("获得的商品");
        list.add("我的晒单");
        list.add("活动奖品");
        list.add("我的红包");
        list.add("账户明细");
        list.add("收货地址管理");
        list.add("在线客服");
        return list;
    }

    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.head_mine_rv, view, false);
        mAdapter.setHeaderView(header);
    }

    @Override
    public void initData() {
    }
}
