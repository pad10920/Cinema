import com.example.cinema.dao.GheDAOD;
import org.junit.jupiter.api.Test;

public class commom {
    private GheDAOD gheDAOD = GheDAOD.khoitao();
    @Test
    void test(){
        gheDAOD.themGheChoShow(20, 5);
    }
}
