package qainfeng.myshop.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-2.
 */
public class ListShopBean {

    /**
     * list : [{"product_id":"42","price":"9239","name":"佳能（Canon）EOS 70D 单反套机 EF-S 18-200mm","picture":"20151119454540037.jpg","period_number":"3","left_num":"7660","sales_num":"1579","period_id":"105131","limit_num":"0","buy_unit":"1"},{"product_id":"67","price":"9586","name":"苹果（Apple）iMac 21.5 英寸 1.6GHz 处理器 1TB 存储容量 ","picture":"20160322826723266.jpg","period_number":"3","left_num":"7814","sales_num":"1772","period_id":"110433","limit_num":"0","buy_unit":"1"},{"product_id":"75","price":"1440","name":"中国农业银行传世之宝\"银元宝\" Ag99.9 100g","picture":"20151120357378672.jpg","period_number":"3","left_num":"1230","sales_num":"210","period_id":"120563","limit_num":"0","buy_unit":"1"},{"product_id":"179","price":"292","name":"佰草集新七白面膜泥补水保湿亮白修护白皙肌肤","picture":"20160311483388635.jpg","period_number":"3","left_num":"218","sales_num":"74","period_id":"124486","limit_num":"0","buy_unit":"1"},{"product_id":"199","price":"1560","name":"小米（MIUI） 4c 高配版 全网通 白色 移动联通电信4G手机 双卡双待","picture":"20160405514638201.jpg","period_number":"3","left_num":"899","sales_num":"661","period_id":"118523","limit_num":"0","buy_unit":"1"},{"product_id":"201","price":"1356","name":"索尼（Sony）DSC-WX350 数码相机/20倍变焦长焦照相机/WiFi远程操控","picture":"20160405580368029.jpg","period_number":"3","left_num":"1097","sales_num":"259","period_id":"155840","limit_num":"0","buy_unit":"1"},{"product_id":"64","price":"12226","name":"苹果（Apple）MacBook Pro 2.7 GHz Retina 显示屏 256GB 13英寸笔记本电脑","picture":"20151120727686506.jpg","period_number":"2","left_num":"10572","sales_num":"1654","period_id":"107170","limit_num":"0","buy_unit":"1"},{"product_id":"65","price":"11148","name":"苹果（Apple）MacBook 256GB 12英寸笔记本电脑","picture":"20151120196071672.jpg","period_number":"2","left_num":"5475","sales_num":"5673","period_id":"69304","limit_num":"0","buy_unit":"1"},{"product_id":"68","price":"6598","name":"卡西欧（Casio） EX-TR550 自拍神器 数码相机 美颜相机","picture":"20151120184337237.jpg","period_number":"2","left_num":"5708","sales_num":"890","period_id":"86916","limit_num":"0","buy_unit":"1"},{"product_id":"76","price":"3420","name":"中国农业银行传世之宝\u201c金钱\u201d Au9999 10g","picture":"20151120531010023.jpg","period_number":"2","left_num":"2251","sales_num":"1169","period_id":"49374","limit_num":"0","buy_unit":"1"},{"product_id":"174","price":"3420","name":"中国农业银行传世之宝\u201c金钱\u201d Au9999 10g","picture":"20160311387885215.jpg","period_number":"2","left_num":"2700","sales_num":"720","period_id":"95838","limit_num":"0","buy_unit":"10"},{"product_id":"190","price":"5990","name":"苹果（Apple）iPhone 6 128G 4G手机","picture":"20160328895732546.jpg","period_number":"2","left_num":"4230","sales_num":"1760","period_id":"121156","limit_num":"0","buy_unit":"10"},{"product_id":"202","price":"1726","name":"宝丽来（Polaroid）Z2300 拍立得相机 即拍即得 ","picture":"20160405574546417.jpg","period_number":"2","left_num":"1099","sales_num":"627","period_id":"103004","limit_num":"0","buy_unit":"1"},{"product_id":"209","price":"6399","name":"三星 Galaxy S7 edge（G9350）32G版 铂光金移动联通电信4G手机 双卡双待 骁龙820手机（颜色随机）","picture":"20160422764880649.jpg","period_number":"2","left_num":"4646","sales_num":"1753","period_id":"135417","limit_num":"0","buy_unit":"1"},{"product_id":"21","price":"27498","name":"戴尔（Dell）Alienware 17 ALW17E-2728 17.3英寸i7外星人笔记本4核 ","picture":"20151119488839915.jpg","period_number":"1","left_num":"16070","sales_num":"11428","period_id":"21","limit_num":"0","buy_unit":"1"},{"product_id":"44","price":"10998","name":"佳能（Canon）EOS 7D Mark II 准专业单反数码相机 ","picture":"20151119442173716.jpg","period_number":"1","left_num":"6364","sales_num":"4634","period_id":"42","limit_num":"0","buy_unit":"1"}]
     * page : 5
     * totalCount : 83
     * totalPage : 6
     * cname : null
     */

    private String page;
    private String totalCount;
    private int totalPage;
    private Object cname;
    /**
     * product_id : 42
     * price : 9239
     * name : 佳能（Canon）EOS 70D 单反套机 EF-S 18-200mm
     * picture : 20151119454540037.jpg
     * period_number : 3
     * left_num : 7660
     * sales_num : 1579
     * period_id : 105131
     * limit_num : 0
     * buy_unit : 1
     */

    private List<ListBean> list;

    public static ListShopBean objectFromData(String str) {

        return new Gson().fromJson(str, ListShopBean.class);
    }

    public static ListShopBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ListShopBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<ListShopBean> arrayListShopBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ListShopBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<ListShopBean> arrayListShopBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ListShopBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
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

    public Object getCname() {
        return cname;
    }

    public void setCname(Object cname) {
        this.cname = cname;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String product_id;
        private String price;
        private String name;
        private String picture;
        private String period_number;
        private String left_num;
        private String sales_num;
        private String period_id;
        private String limit_num;
        private String buy_unit;

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

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getPeriod_number() {
            return period_number;
        }

        public void setPeriod_number(String period_number) {
            this.period_number = period_number;
        }

        public String getLeft_num() {
            return left_num;
        }

        public void setLeft_num(String left_num) {
            this.left_num = left_num;
        }

        public String getSales_num() {
            return sales_num;
        }

        public void setSales_num(String sales_num) {
            this.sales_num = sales_num;
        }

        public String getPeriod_id() {
            return period_id;
        }

        public void setPeriod_id(String period_id) {
            this.period_id = period_id;
        }

        public String getLimit_num() {
            return limit_num;
        }

        public void setLimit_num(String limit_num) {
            this.limit_num = limit_num;
        }

        public String getBuy_unit() {
            return buy_unit;
        }

        public void setBuy_unit(String buy_unit) {
            this.buy_unit = buy_unit;
        }
    }
}
