package qainfeng.myshop.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import qainfeng.myshop.R;
import qainfeng.myshop.adapter.HelpExpandAdapter;

public class HelpActivity extends AppCompatActivity {
    private ExpandableListView mExpandableListView;
    private List<String> groupData;
    private List<List<String>> childData;
    private HelpExpandAdapter mHelpExpandAdapter;
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        initView();
        initData();
    }

    private void initData() {
        groupData=new ArrayList<>();
        groupData.add("什么是伙购网？");
        groupData.add("伙购网的规则是什么？");
        groupData.add("伙购网的流程是怎样的？");
        groupData.add("常见问题");
        childData=new ArrayList<>();
        List<String> list1=new ArrayList<>();
        list1.add("伙购网是一种新型的网购模式，只需1元就有可能买到一件商品。伙购网把一件商品平分成若干\"等份\"出售，每份1元，当一件商品所有\"等份\"售出后抽出一名幸运者，该幸运者即可获得此商品。");
        List<String> list2=new ArrayList<>();
        list2.add("商品的最后一个号码分配完毕后，将公示截至该时间点本站全部商品的最后50个参与时间\n\n将这50个时间的数值进行求和(得出数值A)(每个时间按时、分、秒、毫秒的顺序组合，如20:15:25.362则为201525362)");
        List<String> list3=new ArrayList<>();
        list3.add("1、挑选商品\n分类浏览或直接搜索商品，点击\"立即伙购\"。\n\n2、支付1元\n通过在线支付平台，支付1元即购买1人次，获得1个\"伙购码\"。同一件商品可购买多次或一次购买多份，购买的\"伙购码\"越多，获得商品的几率越大");
        List<String> list4=new ArrayList<>();
        list4.add("Q:怎样查看我参与的商品有木有获得？\nA:每件商品揭晓结果公布之后，登录伙购网，进入\"我的伙购\"，在\"伙购记录\"中即可查询揭晓情况");
        childData.add(list1);
        childData.add(list2);
        childData.add(list3);
        childData.add(list4);
        mHelpExpandAdapter = new HelpExpandAdapter(this,groupData,childData);
        mExpandableListView.setAdapter(mHelpExpandAdapter);
        mExpandableListView.expandGroup(0);
    }

    private void initView() {
        ivBack= (ImageView) findViewById(R.id.iv_help_back);
        mExpandableListView= (ExpandableListView) findViewById(R.id.elv_help_content);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
