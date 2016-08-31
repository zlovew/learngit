package qainfeng.myshop.fragment;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import qainfeng.myshop.R;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class HomeFragment extends BaseFragment {
    private ListView mListView;
    private LinearLayout mFloatingLayout;
    private List<String> mData;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        mFloatingLayout = (LinearLayout) view.findViewById(R.id.ll_floating);
        mListView = (ListView) view.findViewById(R.id.lv);
        mListView.addHeaderView(View.inflate(getActivity(), R.layout.home_header, null));//头部内容
        mListView.addHeaderView(View.inflate(getActivity(), R.layout.fragment_listview_floating, null));//ListView条目中的悬浮部分 添加到头部
        return view;
    }

    @Override
    public void initData() {
        String[] listDatas = new String[50];
        for(int i=0;i<listDatas.length;i++){
            listDatas[i] = "邓肯和波波--" + i;
        }
        mListView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, listDatas));
        //listview 滑动监听
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 1) {
                    mFloatingLayout.setVisibility(View.VISIBLE);
                } else {
                    mFloatingLayout.setVisibility(View.GONE);
                }
            }
        });
    }
}
