import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UserTest {
    @Test
    public void shouldBeAbleToCreateUser(){
        Assert.assertNotNull("create user",new User());
    }


}
