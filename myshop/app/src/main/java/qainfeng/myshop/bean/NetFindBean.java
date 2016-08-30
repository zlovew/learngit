package qainfeng.myshop.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * on 2016/8/30.
 * 类的描述:
 */
public class NetFindBean {
    /**
     * id : 8
     * title : 第三季土豪大PK
     * sub_title : 红包返现 iphone6s 丰富奖品等着你！
     * flag : 2
     * icon : http://img.huogou.com/active/org/20160824549327206.jpg
     * url : http://www.huogou.com/app/ranking-list-season.html?r=20160708
     * status : 1
     * type : 1
     * list_order : 5
     * desc :
     * from : 1
     */

    private List<FindListBean> findList;

    public static NetFindBean objectFromData(String str) {

        return new Gson().fromJson(str, NetFindBean.class);
    }

    public static NetFindBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NetFindBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NetFindBean> arrayNetFindBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<NetFindBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NetFindBean> arrayNetFindBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NetFindBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public List<FindListBean> getFindList() {
        return findList;
    }

    public void setFindList(List<FindListBean> findList) {
        this.findList = findList;
    }

    public static class FindListBean {
        private String id;
        private String title;
        private String sub_title;
        private String flag;
        private String icon;
        private String url;
        private String status;
        private String type;
        private String list_order;
        private String desc;
        private String from;

        public static FindListBean objectFromData(String str) {

            return new Gson().fromJson(str, FindListBean.class);
        }

        public static FindListBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), FindListBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<FindListBean> arrayFindListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<FindListBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<FindListBean> arrayFindListBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<FindListBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getList_order() {
            return list_order;
        }

        public void setList_order(String list_order) {
            this.list_order = list_order;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }
}
