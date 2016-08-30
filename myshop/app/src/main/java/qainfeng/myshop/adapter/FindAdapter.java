package qainfeng.myshop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.bean.NetFindBean;

/**
 * on 2016/8/30.
 * 类的描述:
 */
public class FindAdapter extends BaseAdapter {
    private List<NetFindBean.FindListBean> mFindList ;
    private Context mContext;

    public FindAdapter(List<NetFindBean.FindListBean> findList, Context context) {
        mFindList = findList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mFindList.size();
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
            convertView = View.inflate(mContext, R.layout.item_find, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == 0) {
            holder.viewTop.setVisibility(View.VISIBLE);
            holder.viewBot.setVisibility(View.VISIBLE);
        }else {
            holder.viewTop.setVisibility(View.GONE);
            holder.viewBot.setVisibility(View.GONE);
        }
        NetFindBean.FindListBean findListBean = mFindList.get(position);
        Picasso.with(mContext).load(findListBean.getIcon()).placeholder(R.mipmap.logo).into(holder.mImageView);
        holder.mTextViewTitel.setText(findListBean.getTitle());
        holder.mTextView.setText(findListBean.getSub_title());
        return convertView;
    }

    static class ViewHolder {
        ImageView mImageView;
        TextView mTextViewTitel;
        TextView mTextView;
        View viewTop ;
        View viewBot ;
        public ViewHolder(View convertView) {
            mImageView = (ImageView) convertView.findViewById(R.id.iv_item_find);
            mTextViewTitel = (TextView) convertView.findViewById(R.id.tv_item_find_title);
            mTextView = (TextView) convertView.findViewById(R.id.tv_item_find);
            viewTop = convertView.findViewById(R.id.view_find_top);
            viewBot = convertView.findViewById(R.id.view_find_bot);
        }
    }
}
