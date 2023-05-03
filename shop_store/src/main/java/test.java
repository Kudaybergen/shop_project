import com.example.shop_store.domain.Goods;

public class test {
    public static void main(String[] args) {
        Goods goods = new Goods();
        goods.setGoodName("shirt");
        goods.setGoodsDesc("white very goods");
        goods.setPrice(10000);
        System.out.println(goods);
    }
}
