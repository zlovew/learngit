package qainfeng.myshop.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HomeViewPagerBean{

    /**
     * id : 98
     * name : 京东E卡正确使用方式
     * starttime : 0
     * endtime : 1970-01-01 08:00:00
     * picture : http://img.huogou.com/banner/big/20160729581516981.jpg
     * link : url:http://weixin.huogou.com/spread/jdekSpecial/index.html
     * type : 0
     * width : 1080
     * height : 444
     * list_order : 10
     * created_at : 1466500695
     * updated_at : 1469782607
     * source : 2
     * from : 1
     * src : url:http://weixin.huogou.com/spread/jdekSpecial/index.html
     */

    private String id;
    private String name;
    private String starttime;
    private String endtime;
    private String picture;
    private String link;
    private String type;
    private String width;
    private String height;
    private String list_order;
    private String created_at;
    private String updated_at;
    private String source;
    private String from;
    private String src;

    public static HomeViewPagerBean objectFromData(String str) {

        return new Gson().fromJson(str, HomeViewPagerBean.class);
    }

    public static HomeViewPagerBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), HomeViewPagerBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<HomeViewPagerBean> arrayHomeViewPagerBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<HomeViewPagerBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<HomeViewPagerBean> arrayHomeViewPagerBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<HomeViewPagerBean>>() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getList_order() {
        return list_order;
    }

    public void setList_order(String list_order) {
        this.list_order = list_order;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}