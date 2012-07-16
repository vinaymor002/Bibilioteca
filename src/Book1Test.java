import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Book1Test {
    @Test
    public void shouldDisplayBook() throws IOException {
        Book1 book=new Book1("hell",30,"mor");
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        book.displayBook(output);

        String string= new String(output.toByteArray());
        Assert.assertEquals("Book Number :0"+"Book name:hell"+"price :30.0"+"author :mor",string);
    }

    @Test
    public void shouldgetBookReserveStatus(){
        Book1 book=new Book1("hell",30,"mor");
        Assert.assertEquals("Book reserve status",false,book.getReserveStatus());
    }

}
