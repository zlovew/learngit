package qainfeng.myshop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import custom.OnChangedListener;
import custom.SlipButton;
import qainfeng.myshop.R;

/**
 * Created by Administrator on 2016/9/1.
 */
public class SetRecViewAdapter extends RecyclerView.Adapter<SetRecViewAdapter.SetViewHolder> {
    private Context mContext;
    private List<String> mData;
    private List<String> mSub;
    private OnItemClickListener mListener;

    public SetRecViewAdapter(Context context, List<String> list, List<String> sub) {
        mContext = context;
        mData = list;
        mSub = sub;
    }

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, String data);
    }

    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = View.inflate(mContext, R.layout.item_setting_rv, null);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_rv, parent, false);
        SetViewHolder setViewHolder = new SetViewHolder(view);
        return setViewHolder;
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, final int position) {
        if (position == 1 || position == 4) {
            holder.lineShort.setVisibility(View.GONE);
        } else {
            holder.lineThick.setVisibility(View.GONE);
        }
        if (position == 2) {
            holder.ivMore.setVisibility(View.GONE);
        } else if (position == 3) {
            holder.sbOc.setVisibility(View.GONE);
        } else {
            holder.tvSub.setVisibility(View.GONE);
            holder.sbOc.setVisibility(View.GONE);
        }
        holder.tvShow.setText(mData.get(position));
        holder.tvSub.setText(mSub.get(position));
        if (mListener == null) return;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(position, mData.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class SetViewHolder extends RecyclerView.ViewHolder {
        private TextView tvShow, tvSub;
        private ImageView ivMore;
        private SlipButton sbOc;
        private View lineShort, lineThick;

        public SetViewHolder(View itemView) {
            super(itemView);
            tvShow = (TextView) itemView.findViewById(R.id.tv_item_setting);
            tvSub = (TextView) itemView.findViewById(R.id.tv_item_setting_sub);
            ivMore = (ImageView) itemView.findViewById(R.id.iv_setting_item_more);
            sbOc = (SlipButton) itemView.findViewById(R.id.sb_setting_item);

            sbOc.SetOnChangedListener(new OnChangedListener() {
                @Override
                public void OnChanged(boolean CheckState) {
                    if (CheckState) {

                    } else {

                    }
                }
            });

            lineShort = itemView.findViewById(R.id.line_setting_short);
            lineThick = itemView.findViewById(R.id.line_setting_thick);
        }
    }
}
