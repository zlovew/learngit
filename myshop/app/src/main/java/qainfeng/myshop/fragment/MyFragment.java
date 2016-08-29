package qainfeng.myshop.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import qainfeng.myshop.R;
import qainfeng.myshop.adapter.MineRecViewAdapter;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class MyFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private MineRecViewAdapter mAdapter;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.rv_mine_content);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new MineRecViewAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.addDatas(generateData());
        setHeader(mRecyclerView);
        mAdapter.setOnItemClickListener(new MineRecViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String data) {
                Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private ArrayList<String> generateData() {
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("xin"+i);
        }
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
