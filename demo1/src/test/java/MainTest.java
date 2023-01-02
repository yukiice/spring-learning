import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void  test(){
        User user = new User();
        user.setUsername("yukiice");
        user.setPassword("123456");
        System.out.println(user);
        System.out.println(JSON.toJSON(user));
    }
}
