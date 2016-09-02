package qainfeng.myshop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import qainfeng.myshop.R;

/**
 * Created by Administrator on 2016/9/1.
 */
public class HelpExpandAdapter extends BaseExpandableListAdapter implements View.OnClickListener{
    private Context mContext;
    private List<String> groupTitle;
    private List<List<String>> childContent;

    public HelpExpandAdapter(Context context, List<String> groupTitle, List<List<String>> childContent) {
        this.mContext = context;
        this.groupTitle = groupTitle;
        this.childContent = childContent;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public int getGroupCount() {
        return groupTitle==null?0:groupTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childContent==null?0:childContent.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childContent.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder=null;
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.group_help_elv,null);
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 100);
            convertView.setLayoutParams(lp);
            groupHolder=new GroupHolder();
            groupHolder.iv= (ImageView) convertView.findViewById(R.id.iv_group_help_elv);
            groupHolder.tv= (TextView) convertView.findViewById(R.id.tv_group_help_elv);
            convertView.setTag(groupHolder);
        }else{
            groupHolder= (GroupHolder) convertView.getTag();
        }
        groupHolder.tv.setText(groupTitle.get(groupPosition));
        if(isExpanded){
            groupHolder.iv.setImageResource(R.mipmap.screening_arrow_pre);

        }else{
            groupHolder.iv.setImageResource(R.mipmap.screening_arrow);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder=null;
        if(convertView==null){
            convertView=View.inflate(mContext, R.layout.child_help_elv,null);
            childHolder=new ChildHolder();
            childHolder.tv= (TextView) convertView.findViewById(R.id.tv_child_help_elv);
            convertView.setTag(childHolder);
        }else{
            childHolder= (ChildHolder) convertView.getTag();
        }
        childHolder.tv.setText(childContent.get(groupPosition).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    private class GroupHolder{
        private TextView tv;
        private ImageView iv;
    }
    private class ChildHolder{
        private TextView tv;
    }
}
