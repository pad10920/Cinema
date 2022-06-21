import com.example.cinema.services.PhongChieuService;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;

public class PhongchieuDTest {
    PhongChieuService phongChieuService = PhongChieuService.khoitao();
    @Test
    public void test(){
        System.out.println(phongChieuService.layListPhongchieuSanDung("2022-06-17", "00:00:00", "00:00:00", 3));
    }
}
