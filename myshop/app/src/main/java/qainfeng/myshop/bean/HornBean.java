package qainfeng.myshop.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-1.
 */
public class HornBean {

    /**
     * list : [{"buy_device":{"ico":"android","name":"Android客户端","url":"http://help.huogou.com/app.html"},"buy_id":"250078","buy_ip":"221.217.18.69","buy_ip_addr":"北京市","buy_num":"46","buy_time":"2016-09-01 10:30:19.402","user_name":"人民督察","user_id":"854290","user_home_id":"108854290","user_avatar":"20160828931244877.jpg"},{"buy_device":{"ico":"android","name":"Android客户端","url":"http://help.huogou.com/app.html"},"buy_id":"250077","buy_ip":"223.104.25.87","buy_ip_addr":"重庆市","buy_num":"55","buy_time":"2016-09-01 10:23:57.401","user_name":"有种别给我中撒","user_id":"930346","user_home_id":"100930346","user_avatar":"20160806352343996.jpg"},{"buy_device":{"ico":"android","name":"Android客户端","url":"http://help.huogou.com/app.html"},"buy_id":"250076","buy_ip":"117.136.31.213","buy_ip_addr":"中国广东","buy_num":"108","buy_time":"2016-09-01 10:23:16.026","user_name":"蹦插插","user_id":"930650","user_home_id":"102930650","user_avatar":"20160901439076946.jpg"},{"buy_device":{"ico":"android","name":"Android客户端","url":"http://help.huogou.com/app.html"},"buy_id":"250071","buy_ip":"120.197.197.30","buy_ip_addr":"中国广东","buy_num":"31","buy_time":"2016-09-01 10:02:29.297","user_name":"我只想玩玩","user_id":"1176817","user_home_id":"1081176817","user_avatar":"20160828915651555.jpg"}]
     * totalCount : 4
     * totalPage : 1
     * page : 1
     */

    private String totalCount;
    private int totalPage;
    private String page;
    /**
     * buy_device : {"ico":"android","name":"Android客户端","url":"http://help.huogou.com/app.html"}
     * buy_id : 250078
     * buy_ip : 221.217.18.69
     * buy_ip_addr : 北京市
     * buy_num : 46
     * buy_time : 2016-09-01 10:30:19.402
     * user_name : 人民督察
     * user_id : 854290
     * user_home_id : 108854290
     * user_avatar : 20160828931244877.jpg
     */

    private List<ListBean> list;

    public static HornBean objectFromData(String str) {

        return new Gson().fromJson(str, HornBean.class);
    }

    public static HornBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), HornBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<HornBean> arrayHornBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<HornBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<HornBean> arrayHornBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<HornBean>>() {
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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * ico : android
         * name : Android客户端
         * url : http://help.huogou.com/app.html
         */

        private BuyDeviceBean buy_device;
        private String buy_id;
        private String buy_ip;
        private String buy_ip_addr;
        private String buy_num;
        private String buy_time;
        private String user_name;
        private String user_id;
        private String user_home_id;
        private String user_avatar;

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

        public BuyDeviceBean getBuy_device() {
            return buy_device;
        }

        public void setBuy_device(BuyDeviceBean buy_device) {
            this.buy_device = buy_device;
        }

        public String getBuy_id() {
            return buy_id;
        }

        public void setBuy_id(String buy_id) {
            this.buy_id = buy_id;
        }

        public String getBuy_ip() {
            return buy_ip;
        }

        public void setBuy_ip(String buy_ip) {
            this.buy_ip = buy_ip;
        }

        public String getBuy_ip_addr() {
            return buy_ip_addr;
        }

        public void setBuy_ip_addr(String buy_ip_addr) {
            this.buy_ip_addr = buy_ip_addr;
        }

        public String getBuy_num() {
            return buy_num;
        }

        public void setBuy_num(String buy_num) {
            this.buy_num = buy_num;
        }

        public String getBuy_time() {
            return buy_time;
        }

        public void setBuy_time(String buy_time) {
            this.buy_time = buy_time;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_home_id() {
            return user_home_id;
        }

        public void setUser_home_id(String user_home_id) {
            this.user_home_id = user_home_id;
        }

        public String getUser_avatar() {
            return user_avatar;
        }

        public void setUser_avatar(String user_avatar) {
            this.user_avatar = user_avatar;
        }

        public static class BuyDeviceBean {
            private String ico;
            private String name;
            private String url;

            public static BuyDeviceBean objectFromData(String str) {

                return new Gson().fromJson(str, BuyDeviceBean.class);
            }

            public static BuyDeviceBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), BuyDeviceBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<BuyDeviceBean> arrayBuyDeviceBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<BuyDeviceBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<BuyDeviceBean> arrayBuyDeviceBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<BuyDeviceBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getIco() {
                return ico;
            }

            public void setIco(String ico) {
                this.ico = ico;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
