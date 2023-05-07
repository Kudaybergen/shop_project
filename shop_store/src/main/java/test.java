
import com.example.shop_store.repos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class test {
    @Autowired
    private static GoodsRepo goodsRepo;
    public static void main(String[] args) {
        System.out.println(goodsRepo);
    }
}
