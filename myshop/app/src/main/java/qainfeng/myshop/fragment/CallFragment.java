package qainfeng.myshop.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class CallFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView tv = new TextView(mActivity);
        tv.setText("购物车");
        tv.setTextSize(50);
        return tv;
    }

    @Override
    public void initData() {

    }
}
