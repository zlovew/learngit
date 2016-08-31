package qainfeng.myshop.bean;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class SelectItemBean {
    private String shoppingItem;
    private boolean selected;

    public SelectItemBean(String shoppingItem, boolean selected) {
        this.shoppingItem = shoppingItem;
        this.selected = selected;
    }

    public SelectItemBean() {
    }

    public String getShoppingItem() {
        return shoppingItem;
    }

    public void setShoppingItem(String shoppingItem) {
        this.shoppingItem = shoppingItem;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
