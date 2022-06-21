import com.example.cinema.model.Phim;
import com.example.cinema.services.PhimService;
import org.junit.jupiter.api.Test;

public class PhimTest {
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
