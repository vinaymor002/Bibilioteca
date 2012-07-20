import junit.framework.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void shouldBeAbleToCreateUser(){
        Assert.assertNotNull("create user",new User());
    }


}
