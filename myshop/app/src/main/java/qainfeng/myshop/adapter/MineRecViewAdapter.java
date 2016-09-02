package qainfeng.myshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import qainfeng.myshop.R;
import qainfeng.myshop.activity.SettingActivity;

/**
 * Created by Administrator on 2016/8/29.
 */
public class MineRecViewAdapter extends RecyclerView.Adapter<MineRecViewAdapter.MyViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;

    private ArrayList<String> mDatas = new ArrayList<>();

    private View mHeaderView;

    private OnItemClickListener mListener;
    private Context mContext;
    private int[] mArr;
    public MineRecViewAdapter(Context context,int[] arr){
        mContext=context;
        mArr=arr;
    }
    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void addDatas(ArrayList<String> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null) return TYPE_NORMAL;
        if (position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) return new MyViewHolder(mHeaderView);
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_rv, parent, false);
        return new MyViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(holder);
        final String data = mDatas.get(pos);
        if (holder instanceof MyViewHolder) {
//            ((MyViewHolder) holder).text.setText(data);
            if(pos==2||pos==mDatas.size()-1){
                holder.lineThick.setVisibility(View.VISIBLE);
                holder.lineShort.setVisibility(View.GONE);
                holder.lineMid.setVisibility(View.GONE);
            }else if(pos==3){
                holder.lineMid.setVisibility(View.VISIBLE);
                holder.lineShort.setVisibility(View.GONE);
                holder.lineThick.setVisibility(View.GONE);
            }else{
                holder.lineMid.setVisibility(View.GONE);
                holder.lineShort.setVisibility(View.VISIBLE);
                holder.lineThick.setVisibility(View.GONE);
            }
            holder.ivItemShow.setImageResource(mArr[pos]);
            holder.tvItemShow.setText(mDatas.get(pos));
            if (mListener == null) return;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(pos, data);
                }
            });
        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? mDatas.size() : mDatas.size() + 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHeadBell, ivHeadSetting, ivHeadTask, ivHeadInvite, ivHeadSign;
        private Button btHeadLogin;
        private RelativeLayout rlHeadTask, rlHeadInvite, rlHeadSign;
        private TextView tvHeadTask, tvHeadInvite, tvHeadSign;

        private ImageView ivItemShow;
        private TextView tvItemShow;
        private View lineShort, lineMid, lineThick;

        private View.OnClickListener mOnClickListener;

        public MyViewHolder(View itemView) {
            super(itemView);
            mOnClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.iv_head_mine_bell:
                            tvHeadInvite.setText("hehe");
                            break;
                        case R.id.iv_head_mine_setting:
                            mContext.startActivity(new Intent(mContext, SettingActivity.class));
                            break;
                        case R.id.bt_head_mine_login:
                            tvHeadSign.setText("kk");
                            break;
                        case R.id.rl_head_mine_task:
                            tvHeadSign.setText("qq");
                            break;
                        case R.id.rl_head_mine_invite:
                            tvHeadSign.setText("77");
                            break;
                        case R.id.rl_head_mine_sign:
                            tvHeadTask.setText("jiji");
                            break;
                        default:
                            break;
                    }
                }
            };
            if (itemView == mHeaderView) {
                ivHeadBell = (ImageView) itemView.findViewById(R.id.iv_head_mine_bell);
                ivHeadSetting = (ImageView) itemView.findViewById(R.id.iv_head_mine_setting);
                btHeadLogin = (Button) itemView.findViewById(R.id.bt_head_mine_login);
                rlHeadTask = (RelativeLayout) itemView.findViewById(R.id.rl_head_mine_task);
                rlHeadInvite = (RelativeLayout) itemView.findViewById(R.id.rl_head_mine_invite);
                rlHeadSign = (RelativeLayout) itemView.findViewById(R.id.rl_head_mine_sign);
                ivHeadTask = (ImageView) itemView.findViewById(R.id.iv_head_mine_task);
                ivHeadInvite = (ImageView) itemView.findViewById(R.id.iv_head_mine_invite);
                ivHeadSign = (ImageView) itemView.findViewById(R.id.iv_head_mine_sign);
                tvHeadTask = (TextView) itemView.findViewById(R.id.tv_head_mine_task);
                tvHeadInvite = (TextView) itemView.findViewById(R.id.tv_head_mine_invite);
                tvHeadSign = (TextView) itemView.findViewById(R.id.tv_head_mine_sign);
                setListener(ivHeadBell);
                setListener(ivHeadSetting);
                setListener(btHeadLogin);
                setListener(rlHeadTask);
                setListener(rlHeadInvite);
                setListener(rlHeadSign);
                return;
            }
            ivItemShow = (ImageView) itemView.findViewById(R.id.iv_mine_rv_item);
            tvItemShow = (TextView) itemView.findViewById(R.id.tv_mine_rv_item);
            lineShort = itemView.findViewById(R.id.line_mine_short);
            lineMid = itemView.findViewById(R.id.line_mine_middle);
            lineThick = itemView.findViewById(R.id.line_mine_thick);
        }

        private void setListener(View view) {
            view.setOnClickListener(mOnClickListener);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, String data);
    }
}
