package qainfeng.myshop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.bean.NetLastAllBean;

/**
 * on 2016/8/30.
 * 类的描述:
 */
public class LastMainAdapter extends BaseAdapter {
    private List<NetLastAllBean.ListBean> mList;
    private Context mContext;

    public LastMainAdapter(List<NetLastAllBean.ListBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size()
                ;
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
            convertView = View.inflate(mContext, R.layout.item_last, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //得到这个bean
        NetLastAllBean.ListBean listBean = mList.get(position);
        holder.mTextViewTitel.setText(listBean.getGoods_name());
        holder.mTextViewuser.setText(listBean.getUser_name());
        holder.mTextViewCuont.setText(listBean.getPeriod_no());
        holder.mTextViewuser.setText(listBean.getUser_buy_time());
        holder.mTextViewTime.setText(listBean.getUser_addr());
        return convertView;
    }
    static class ViewHolder{
        ImageView mImageView;
        TextView mTextViewTitel,mTextViewPer,mTextViewuser,mTextViewCuont,mTextViewTime;

        public ViewHolder(View convertView) {
            mImageView = (ImageView) convertView.findViewById(R.id.iv_item_last);
            mTextViewTitel = (TextView) convertView.findViewById(R.id.tv_item_title);
            mTextViewPer = (TextView) convertView.findViewById(R.id.tv_item_perid);
            mTextViewuser = (TextView) convertView.findViewById(R.id.tv_item_user);
            mTextViewCuont = (TextView) convertView.findViewById(R.id.tv_item_cuont);
            mTextViewTime = (TextView) convertView.findViewById(R.id.tv_item_time);
        }
    }
}
