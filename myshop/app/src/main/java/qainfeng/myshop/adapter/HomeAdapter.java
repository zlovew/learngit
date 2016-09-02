package qainfeng.myshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.activity.LoginActivity;
import qainfeng.myshop.activity.WebViewActivity;
import qainfeng.myshop.bean.HomeViewPagerBean;

/**
 * Created by Administrator on 16-8-31.
 */
public class HomeAdapter extends StaticPagerAdapter {
    private Context mContext;
    private List<HomeViewPagerBean> mData;

    public HomeAdapter(Context context, List<HomeViewPagerBean> data){
        mContext = context;
        mData = data;
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(container.getContext());
        Picasso.with(mContext).load(mData.get(position).getPicture()).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        if (position==0 || position==2){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("url", mData.get(position).getLink().substring(4));
                    //Toast.makeText(mContext, "viewPager数据是"+mData.get(position).getLink().substring(3), Toast.LENGTH_LONG).show();
                    mContext.startActivity(intent);
                }
            });
        }
        if (position == 1){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, LoginActivity.class);
                    //intent.putExtra("url", mData.get(position).getLink().substring(4));
                    //Toast.makeText(mContext, "viewPager数据是"+mData.get(position).getLink().substring(3), Toast.LENGTH_LONG).show();
                    mContext.startActivity(intent);
                }
            });
        }
        return imageView;
    }

    @Override
    public int getCount() {
        return mData==null?0:mData.size();
    }
}
