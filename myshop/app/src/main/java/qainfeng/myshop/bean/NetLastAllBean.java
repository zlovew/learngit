package qainfeng.myshop.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class NetLastAllBean {
    /**
     * list : [{"buy_unit":"1","end_time":"1472462864.105","goods_id":"219","goods_name":"【实时到账】淘宝网50元购物卡","goods_picture":"20160824681998192.jpg","left_time":0,"limit_num":"0","lucky_code":"10000002","period_id":"217258","period_no":"6082900312","period_number":"17666","price":"60.00","publish_time":"2016-08-29 17:27:44.105","raff_time":"2016-08-29 17:34:00","share_id":0,"status":2,"user_addr":"重庆市","user_avatar":"20160130305987144.jpg","user_buy_num":"20","user_buy_time":"2016-08-29 17:27:10.112","user_home_id":"10221647","user_id":"21647","user_ip":"125.85.93.241","user_name":"中奖要七分运气三分经验"},{"buy_unit":"1","end_time":"1472462657.178","goods_id":"218","goods_name":"【实时到账】淘宝网20元购物卡","goods_picture":"20160824715759967.jpg","left_time":0,"limit_num":"0","lucky_code":"10000013","period_id":"217260","period_no":"6082900314","period_number":"19709","price":"25.00","publish_time":"2016-08-29 17:24:17.178","raff_time":"2016-08-29 17:34:00","share_id":0,"status":2,"user_addr":"中国广东","user_avatar":"20160609911317563.jpg","user_buy_num":"9","user_buy_time":"2016-08-29 17:24:17.178","user_home_id":"105948388","user_id":"948388","user_ip":"117.136.40.142","user_name":"人生没有重来"},{"buy_unit":"1","end_time":"1472462630.038","goods_id":"220","goods_name":"【实时到账】淘宝网100元购物卡","goods_picture":"20160824725750434.jpg","left_time":0,"limit_num":"0","lucky_code":"10000029","period_id":"217261","period_no":"6082900315","period_number":"14864","price":"120.00","publish_time":"2016-08-29 17:23:50.038","raff_time":"2016-08-29 17:34:00","share_id":0,"status":2,"user_addr":"中国广东","user_avatar":"20160609911317563.jpg","user_buy_num":"41","user_buy_time":"2016-08-29 17:23:50.038","user_home_id":"105948388","user_id":"948388","user_ip":"117.136.40.142","user_name":"人生没有重来"},{"buy_unit":"1","end_time":"1472462626.619","goods_id":"222","goods_name":"【实时到账】淘宝网500元购物卡","goods_picture":"20160824543995240.jpg","left_time":0,"limit_num":"0","lucky_code":"10000258","period_id":"217257","period_no":"6082900311","period_number":"11340","price":"600.00","publish_time":"2016-08-29 17:23:46.619","raff_time":"2016-08-29 17:34:00","share_id":0,"status":2,"user_addr":"中国广东","user_avatar":"20160825918120531.jpg","user_buy_num":"226","user_buy_time":"2016-08-29 17:15:51.773","user_home_id":"104853765","user_id":"853765","user_ip":"117.136.40.34","user_name":"LZ狼行千里CLM999999999"},{"buy_unit":"1","end_time":"1472462247.940","goods_id":"220","goods_name":"【实时到账】淘宝网100元购物卡","goods_picture":"20160824725750434.jpg","left_time":0,"limit_num":"0","lucky_code":"10000022","period_id":"217255","period_no":"6082900309","period_number":"14863","price":"120.00","publish_time":"2016-08-29 17:17:27.940","raff_time":"2016-08-29 17:24:00","share_id":0,"status":2,"user_addr":"山东省泰安市","user_avatar":"20160712602203509.jpg","user_buy_num":"51","user_buy_time":"2016-08-29 17:16:01.967","user_home_id":"109521958","user_id":"521958","user_ip":"111.37.8.210","user_name":"万分之一的几率我能中"},{"buy_unit":"1","end_time":"1472462098.601","goods_id":"218","goods_name":"【实时到账】淘宝网20元购物卡","goods_picture":"20160824715759967.jpg","left_time":0,"limit_num":"0","lucky_code":"10000010","period_id":"217259","period_no":"6082900313","period_number":"19708","price":"25.00","publish_time":"2016-08-29 17:14:58.601","raff_time":"2016-08-29 17:24:00","share_id":0,"status":2,"user_addr":"中国江西","user_avatar":"20160828487471099.jpg","user_buy_num":"15","user_buy_time":"2016-08-29 17:14:58.601","user_home_id":"1021146932","user_id":"1146932","user_ip":"223.104.31.205","user_name":"真的是我呀"},{"buy_unit":"1","end_time":"1472461694.701","goods_id":"218","goods_name":"【实时到账】淘宝网20元购物卡","goods_picture":"20160824715759967.jpg","left_time":0,"limit_num":"0","lucky_code":"10000011","period_id":"217253","period_no":"6082900307","period_number":"19707","price":"25.00","publish_time":"2016-08-29 17:08:14.701","raff_time":"2016-08-29 17:14:00","share_id":0,"status":2,"user_addr":"内蒙古省通辽市","user_avatar":"000000000000.jpg","user_buy_num":"9","user_buy_time":"2016-08-29 17:07:30.929","user_home_id":"1061170077","user_id":"1170077","user_ip":"110.17.170.147","user_name":"雪哥是你们baba啊"},{"buy_unit":"1","end_time":"1472461639.487","goods_id":"219","goods_name":"【实时到账】淘宝网50元购物卡","goods_picture":"20160824681998192.jpg","left_time":0,"limit_num":"0","lucky_code":"10000032","period_id":"217256","period_no":"6082900310","period_number":"17665","price":"60.00","publish_time":"2016-08-29 17:07:19.487","raff_time":"2016-08-29 17:14:00","share_id":0,"status":2,"user_addr":"山东省泰安市","user_avatar":"20160712602203509.jpg","user_buy_num":"32","user_buy_time":"2016-08-29 17:06:53.090","user_home_id":"109521958","user_id":"521958","user_ip":"111.37.8.210","user_name":"万分之一的几率我能中"},{"buy_unit":"1","end_time":"1472461512.806","goods_id":"222","goods_name":"【实时到账】淘宝网500元购物卡","goods_picture":"20160824543995240.jpg","left_time":0,"limit_num":"0","lucky_code":"10000548","period_id":"217246","period_no":"6082900300","period_number":"11339","price":"600.00","publish_time":"2016-08-29 17:05:12.806","raff_time":"2016-08-29 17:14:00","share_id":0,"status":2,"user_addr":"重庆市","user_avatar":"20160806352343996.jpg","user_buy_num":"78","user_buy_time":"2016-08-29 17:01:19.652","user_home_id":"100930346","user_id":"930346","user_ip":"223.104.25.71","user_name":"看来又中不到了哎"},{"buy_unit":"1","end_time":"1472461490.555","goods_id":"219","goods_name":"【实时到账】淘宝网50元购物卡","goods_picture":"20160824681998192.jpg","left_time":0,"limit_num":"0","lucky_code":"10000028","period_id":"217247","period_no":"6082900301","period_number":"17664","price":"60.00","publish_time":"2016-08-29 17:04:50.555","raff_time":"2016-08-29 17:14:00","share_id":0,"status":2,"user_addr":"中国广东","user_avatar":"20160827915044054.jpg","user_buy_num":"5","user_buy_time":"2016-08-29 17:00:35.598","user_home_id":"1031146356","user_id":"1146356","user_ip":"117.136.32.29","user_name":"这世间没爱了"},{"buy_unit":"1","end_time":"1472461432.952","goods_id":"220","goods_name":"【实时到账】淘宝网100元购物卡","goods_picture":"20160824725750434.jpg","left_time":0,"limit_num":"0","lucky_code":"10000039","period_id":"217250","period_no":"6082900304","period_number":"14862","price":"120.00","publish_time":"2016-08-29 17:03:52.952","raff_time":"2016-08-29 17:14:00","share_id":0,"status":2,"user_addr":"中国江苏","user_avatar":"20160829360512944.jpg","user_buy_num":"39","user_buy_time":"2016-08-29 17:02:58.307","user_home_id":"1071193341","user_id":"1193341","user_ip":"117.136.66.227","user_name":"镜中人123"},{"buy_unit":"1","end_time":"1472461384.788","goods_id":"221","goods_name":"【实时到账】淘宝网200元购物卡","goods_picture":"20160824244554142.jpg","left_time":0,"limit_num":"0","lucky_code":"10000042","period_id":"217251","period_no":"6082900305","period_number":"13739","price":"240.00","publish_time":"2016-08-29 17:03:04.788","raff_time":"2016-08-29 17:14:00","share_id":0,"status":2,"user_addr":"中国广东","user_avatar":"20160609911317563.jpg","user_buy_num":"65","user_buy_time":"2016-08-29 17:03:04.788","user_home_id":"105948388","user_id":"948388","user_ip":"117.136.40.142","user_name":"人生没有重来"},{"buy_unit":"1","end_time":"1472461171.937","goods_id":"218","goods_name":"【实时到账】淘宝网20元购物卡","goods_picture":"20160824715759967.jpg","left_time":0,"limit_num":"0","lucky_code":"10000008","period_id":"217252","period_no":"6082900306","period_number":"19706","price":"25.00","publish_time":"2016-08-29 16:59:31.937","raff_time":"2016-08-29 17:04:00","share_id":0,"status":2,"user_addr":"中国江西","user_avatar":"20160828487471099.jpg","user_buy_num":"11","user_buy_time":"2016-08-29 16:58:26.864","user_home_id":"1021146932","user_id":"1146932","user_ip":"223.104.31.134","user_name":"真的是我呀"},{"buy_unit":"1","end_time":"1472460897.484","goods_id":"218","goods_name":"【实时到账】淘宝网20元购物卡","goods_picture":"20160824715759967.jpg","left_time":0,"limit_num":"0","lucky_code":"10000022","period_id":"217248","period_no":"6082900302","period_number":"19705","price":"25.00","publish_time":"2016-08-29 16:54:57.484","raff_time":"2016-08-29 17:04:00","share_id":0,"status":2,"user_addr":"中国","user_avatar":"20160824917562634.jpg","user_buy_num":"5","user_buy_time":"2016-08-29 16:46:10.935","user_home_id":"106187096","user_id":"187096","user_ip":"36.149.6.212","user_name":"小柒来朵宝贝啦"},{"buy_unit":"1","end_time":"1472460879.730","goods_id":"221","goods_name":"【实时到账】淘宝网200元购物卡","goods_picture":"20160824244554142.jpg","left_time":0,"limit_num":"0","lucky_code":"10000088","period_id":"217226","period_no":"6082900280","period_number":"13738","price":"240.00","publish_time":"2016-08-29 16:54:39.730","raff_time":"2016-08-29 17:04:00","share_id":0,"status":2,"user_addr":"江苏省无锡市","user_avatar":"20160810436509370.jpg","user_buy_num":"92","user_buy_time":"2016-08-29 16:54:39.730","user_home_id":"1001119827","user_id":"1119827","user_ip":"114.225.78.106","user_name":"射穿你"},{"buy_unit":"1","end_time":"1472460468.064","goods_id":"220","goods_name":"【实时到账】淘宝网100元购物卡","goods_picture":"20160824725750434.jpg","left_time":0,"limit_num":"0","lucky_code":"10000034","period_id":"217249","period_no":"6082900303","period_number":"14861","price":"120.00","publish_time":"2016-08-29 16:47:48.064","raff_time":"2016-08-29 16:54:00","share_id":0,"status":2,"user_addr":"广东省广州市","user_avatar":"20160817418468460.jpg","user_buy_num":"50","user_buy_time":"2016-08-29 16:45:40.486","user_home_id":"100246925","user_id":"246925","user_ip":"121.33.59.147","user_name":"老虎的屁股摸不得"},{"buy_unit":"1","end_time":"1472460210.482","goods_id":"220","goods_name":"【实时到账】淘宝网100元购物卡","goods_picture":"20160824725750434.jpg","left_time":0,"limit_num":"0","lucky_code":"10000062","period_id":"217241","period_no":"6082900295","period_number":"14860","price":"120.00","publish_time":"2016-08-29 16:43:30.482","raff_time":"2016-08-29 16:54:00","share_id":0,"status":2,"user_addr":"广东省广州市","user_avatar":"20160829394978653.jpg","user_buy_num":"41","user_buy_time":"2016-08-29 16:26:31.453","user_home_id":"1021143618","user_id":"1143618","user_ip":"59.41.182.205","user_name":"小柒别不和我玩啊"},{"buy_unit":"1","end_time":"1472460181.341","goods_id":"218","goods_name":"【实时到账】淘宝网20元购物卡","goods_picture":"20160824715759967.jpg","left_time":0,"limit_num":"0","lucky_code":"10000005","period_id":"217245","period_no":"6082900299","period_number":"19704","price":"25.00","publish_time":"2016-08-29 16:43:01.341","raff_time":"2016-08-29 16:54:00","share_id":0,"status":2,"user_addr":"中国江西","user_avatar":"20160829340353215.jpg","user_buy_num":"10","user_buy_time":"2016-08-29 16:37:14.289","user_home_id":"1091146411","user_id":"1146411","user_ip":"223.104.31.134","user_name":"最后一次永不见"},{"buy_unit":"1","end_time":"1472460157.240","goods_id":"219","goods_name":"【实时到账】淘宝网50元购物卡","goods_picture":"20160824681998192.jpg","left_time":0,"limit_num":"0","lucky_code":"10000008","period_id":"217243","period_no":"6082900297","period_number":"17663","price":"60.00","publish_time":"2016-08-29 16:42:37.240","raff_time":"2016-08-29 16:54:00","share_id":0,"status":2,"user_addr":"重庆市","user_avatar":"20160130305987144.jpg","user_buy_num":"20","user_buy_time":"2016-08-29 16:37:55.401","user_home_id":"10221647","user_id":"21647","user_ip":"125.85.93.241","user_name":"中奖要七分运气三分经验"},{"buy_unit":"1","end_time":"1472460040.274","goods_id":"222","goods_name":"【实时到账】淘宝网500元购物卡","goods_picture":"20160824543995240.jpg","left_time":0,"limit_num":"0","lucky_code":"10000243","period_id":"217236","period_no":"6082900290","period_number":"11338","price":"600.00","publish_time":"2016-08-29 16:40:40.274","raff_time":"2016-08-29 16:54:00","share_id":0,"status":2,"user_addr":"中国广东","user_avatar":"20160825918120531.jpg","user_buy_num":"247","user_buy_time":"2016-08-29 16:40:40.274","user_home_id":"104853765","user_id":"853765","user_ip":"117.136.40.34","user_name":"LZ狼行千里CLM999999999"}]
     * totalCount : 217119
     * totalPage : 10856
     */

    private String totalCount;
    private int totalPage;
    /**
     * buy_unit : 1
     * end_time : 1472462864.105
     * goods_id : 219
     * goods_name : 【实时到账】淘宝网50元购物卡
     * goods_picture : 20160824681998192.jpg
     * left_time : 0
     * limit_num : 0
     * lucky_code : 10000002
     * period_id : 217258
     * period_no : 6082900312
     * period_number : 17666
     * price : 60.00
     * publish_time : 2016-08-29 17:27:44.105
     * raff_time : 2016-08-29 17:34:00
     * share_id : 0
     * status : 2
     * user_addr : 重庆市
     * user_avatar : 20160130305987144.jpg
     * user_buy_num : 20
     * user_buy_time : 2016-08-29 17:27:10.112
     * user_home_id : 10221647
     * user_id : 21647
     * user_ip : 125.85.93.241
     * user_name : 中奖要七分运气三分经验
     */

    private List<ListBean> list;

    public static NetLastAllBean objectFromData(String str) {

        return new Gson().fromJson(str, NetLastAllBean.class);
    }

    public static NetLastAllBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NetLastAllBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NetLastAllBean> arrayNetLastAllBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<NetLastAllBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NetLastAllBean> arrayNetLastAllBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NetLastAllBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String buy_unit;
        private String end_time;
        private String goods_id;
        private String goods_name;
        private String goods_picture;
        private int left_time;
        private String limit_num;
        private String lucky_code;
        private String period_id;
        private String period_no;
        private String period_number;
        private String price;
        private String publish_time;
        private String raff_time;
        private int share_id;
        private int status;
        private String user_addr;
        private String user_avatar;
        private String user_buy_num;
        private String user_buy_time;
        private String user_home_id;
        private String user_id;
        private String user_ip;
        private String user_name;

        public static ListBean objectFromData(String str) {

            return new Gson().fromJson(str, ListBean.class);
        }

        public static ListBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ListBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ListBean> arrayListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ListBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ListBean> arrayListBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ListBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getBuy_unit() {
            return buy_unit;
        }

        public void setBuy_unit(String buy_unit) {
            this.buy_unit = buy_unit;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_picture() {
            return goods_picture;
        }

        public void setGoods_picture(String goods_picture) {
            this.goods_picture = goods_picture;
        }

        public int getLeft_time() {
            return left_time;
        }

        public void setLeft_time(int left_time) {
            this.left_time = left_time;
        }

        public String getLimit_num() {
            return limit_num;
        }

        public void setLimit_num(String limit_num) {
            this.limit_num = limit_num;
        }

        public String getLucky_code() {
            return lucky_code;
        }

        public void setLucky_code(String lucky_code) {
            this.lucky_code = lucky_code;
        }

        public String getPeriod_id() {
            return period_id;
        }

        public void setPeriod_id(String period_id) {
            this.period_id = period_id;
        }

        public String getPeriod_no() {
            return period_no;
        }

        public void setPeriod_no(String period_no) {
            this.period_no = period_no;
        }

        public String getPeriod_number() {
            return period_number;
        }

        public void setPeriod_number(String period_number) {
            this.period_number = period_number;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getRaff_time() {
            return raff_time;
        }

        public void setRaff_time(String raff_time) {
            this.raff_time = raff_time;
        }

        public int getShare_id() {
            return share_id;
        }

        public void setShare_id(int share_id) {
            this.share_id = share_id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUser_addr() {
            return user_addr;
        }

        public void setUser_addr(String user_addr) {
            this.user_addr = user_addr;
        }

        public String getUser_avatar() {
            return user_avatar;
        }

        public void setUser_avatar(String user_avatar) {
            this.user_avatar = user_avatar;
        }

        public String getUser_buy_num() {
            return user_buy_num;
        }

        public void setUser_buy_num(String user_buy_num) {
            this.user_buy_num = user_buy_num;
        }

        public String getUser_buy_time() {
            return user_buy_time;
        }

        public void setUser_buy_time(String user_buy_time) {
            this.user_buy_time = user_buy_time;
        }

        public String getUser_home_id() {
            return user_home_id;
        }

        public void setUser_home_id(String user_home_id) {
            this.user_home_id = user_home_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_ip() {
            return user_ip;
        }

        public void setUser_ip(String user_ip) {
            this.user_ip = user_ip;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
    }
}
