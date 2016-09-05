package qainfeng.myshop.NetConstant;

/**
 * on 2016/8/30.
 * 类的描述:
 */
public interface NetConstant {
    String LAST_ALL = "http://api.huogou.com/period/list?cid=0&isRevealed=1&app=huogou&perpage=20&channel=360market&page=1&zgid=99000646343428&os=android&version=2.0.4";
    String FIND_URL = "http://api.huogou.com/active/index?v=16&source=4&app=huogou&channel=360market&zgid=99000646343428&os=android&version=2.0.4 \n";
    String HOME_VIEWPAGER_PATH = "http://api.huogou.com/banner/banner-list?num=5&source=2&app=huogou&channel=360market&zgid=99000646343428&os=android&version=2.0.4";
    String LABA_PATH = "http://api.huogou.com/period/buylist?id=219015&os=android&app=huogou&channel=360market&perpage=20&page=1&zgid=864394010224212&version=2.0.4\n";
    String HOME_LIST_PATH = "http://api.huogou.com/product/list?orderFlag=20&cid=0&bid=0&app=huogou&perpage=16&channel=360market&page=%d&zgid=99000646343428&os=android&limit=all&version=2.0.4";
}
