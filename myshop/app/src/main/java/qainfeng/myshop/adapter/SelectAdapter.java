package qainfeng.myshop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.bean.SelectItemBean;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class SelectAdapter extends BaseAdapter {
    private  List<SelectItemBean> mSelectItemBeen;
    private Context mContext;

    public SelectAdapter(List<SelectItemBean> selectItemBeen, Context context) {
        mSelectItemBeen = selectItemBeen;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mSelectItemBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_select, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //如果ture的话 让他显示
        if (mSelectItemBeen.get(position).getSelected()) {
            holder.mImageView.setVisibility(View.VISIBLE);
        } else {
            holder.mImageView.setVisibility(View.GONE);
        }
        holder.mTextView.setText(mSelectItemBeen.get(position).getShoppingItem()
        );
        return convertView;
    }
    static class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
        public ViewHolder(View view){
            mImageView = (ImageView) view.findViewById(R.id.iv_item_select);
            mTextView = (TextView) view.findViewById(R.id.tv_select_item);
        }
    }
}
