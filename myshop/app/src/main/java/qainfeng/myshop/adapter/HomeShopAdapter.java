package qainfeng.myshop.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.bean.HomeViewPagerBean;
import qainfeng.myshop.bean.ListShopBean;

/**
 * Created by Administrator on 16-9-2.
 */
public class HomeShopAdapter extends BaseAdapter {
    private List<ListShopBean.ListBean> mData;
    private Context mContext;
    public HomeShopAdapter(Context context,List<ListShopBean.ListBean> data){
        mContext = context;
        mData = data;
    }
    @Override
    public int getCount() {
        return mData==null?0:mData.size()/2;
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
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_home, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTextView1.setText(mData.get(position).getName());
        int shopNumber1 = Integer.parseInt(mData.get(position).getSales_num());
        int shopNumberTotal = Integer.parseInt(mData.get(position).getLeft_num())+shopNumber1;
        Log.i("TAG","分子是:"+shopNumber1+"分母是:"+shopNumberTotal+"结果是:"+(shopNumber1*100l)/shopNumberTotal);
        holder.mTextViewProgress1.setText((int)((shopNumber1*100f/(Integer.parseInt(mData.get(position).getLeft_num())+shopNumber1)))+"%");
        holder.mProgressBar1.setProgress((int)(shopNumber1*100f/(Integer.parseInt(mData.get(position).getLeft_num())+shopNumber1)));
        String url1 = "http://s1.huogou.com/goodspic/"+mData.get(position).getPicture().substring(0,4)+"/"+mData.get(position).getPicture().substring(4,6)+"/400/400/"+mData.get(position).getPicture();
        Picasso.with(mContext).load(url1).into(holder.mImage1);

        holder.mTextView2.setText(mData.get(position*2+1).getName());
        int shopNumber2 = Integer.parseInt(mData.get(position*2+1).getSales_num());
        holder.mTextViewProgress2.setText((int)((shopNumber2*100f/(Integer.parseInt(mData.get(position*2+1).getLeft_num())+shopNumber2)))+"%");
        holder.mProgressBar2.setProgress((int)(shopNumber2*100f/(Integer.parseInt(mData.get(position*2+1).getLeft_num())+shopNumber2)));
        String url2 = "http://s1.huogou.com/goodspic/"+mData.get(position*2+1).getPicture().substring(0,4)+"/"+mData.get(position*2+1).getPicture().substring(4,6)+"/400/400/"+mData.get(position*2+1).getPicture();
        Picasso.with(mContext).load(url2).into(holder.mImage2);
        return convertView;
    }
    public static class ViewHolder{
        private ImageView mImage1,mImage2;
        private TextView mTextView1,mTextView2,mTextViewProgress1,mTextViewProgress2;
        private ProgressBar mProgressBar1,mProgressBar2;
        public ViewHolder(View view){
            mTextView1 = (TextView) view.findViewById(R.id.tv_shoping_info1);
            mTextView2 = (TextView) view.findViewById(R.id.tv_shoping_info2);
            mTextViewProgress1 = (TextView) view.findViewById(R.id.tv_progress1);
            mTextViewProgress2 = (TextView) view.findViewById(R.id.tv_progress2);

            mImage1 = (ImageView) view.findViewById(R.id.iv_shoping_photo1);
            mImage2 = (ImageView) view.findViewById(R.id.iv_shoping_photo2);

            mProgressBar1 = (ProgressBar) view.findViewById(R.id.my_progress1);
            mProgressBar2 = (ProgressBar) view.findViewById(R.id.my_progress2);
        }

    }
}
