import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UserTest {
    @Test
    public void shouldBeAbleToCreateUser(){
        Assert.assertNotNull("create user",new User());
    }

    @Test
    public void shouldBeAbleToCheckUserNumber() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        User user =new User();
        user.displayUserNumber(output);
        String string=new String(output.toByteArray());

        Assert.assertEquals("User Number :0"+" Please talk to Librarian. Thank you",string);
    }
}
