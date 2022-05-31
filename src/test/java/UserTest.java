import com.example.cinema.dao.UserDAO;
import com.example.cinema.services.UserSevice;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testDangNhap(){
        UserSevice userSevice = UserSevice.khoiTaoUserService();
    }
}
