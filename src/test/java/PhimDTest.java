import com.example.cinema.services.PhimService;
import org.junit.jupiter.api.Test;

public class PhimDTest {
    @Test
    public void test(){
        PhimService phimService = PhimService.khoiTao();
        System.out.println(phimService.layListPhim());
    }

    @Test
    public void listPhimByKey(){
        PhimService phimService = PhimService.khoiTao();
        System.out.println(phimService.layListPhimByTen("cháy"));
    }
}
