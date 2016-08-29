package qainfeng.myshop.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class HomeFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView tv = new TextView(mActivity);
        tv.setText(getClass().getSimpleName());
        tv.setTextSize(50);
        return tv;
    }

    @Override
    public void initData() {

    }
}
