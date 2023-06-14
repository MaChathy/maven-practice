import com.fisher.practice.mvc.entry.user.User;
import org.junit.Test;

/**
 *
 * @author fisher
 * @version 1.0.1 2023/6/14 - 10:35
 */
public class StreamTest {

    @Test
    public void testStream() throws InstantiationException, IllegalAccessException {
        Class user;
        user = User.class;
        Object o = user.newInstance();
    }
}
