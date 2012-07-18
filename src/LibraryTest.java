import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class LibraryTest {
    @Test
    public void shouldCreateLibraryObject(){
        Assert.assertNotNull(new Library());
    }

    @Test
    public void shouldDisplayWelcomeMessage()throws IOException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Library unit=new Library();
        unit.displayWelcomeMessage(output);
        String string=new String(output.toByteArray());
        Assert.assertEquals("Wecome message","Welcome !",string);
    }

    @Test
    public void shouldDisplayMenuList() throws IOException {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Library unit=new Library();
        unit.displayMenuList(output);
        String string=new String(output.toByteArray());
        Assert.assertEquals("menu list","\n1.Display Books" +"   2.Reserve a Book" +"  3.Check Library number"+"   4.Exit",string);
    }

    @Test
    public void shouldBeAbleToSelectMenuOption1(){


        Assert.assertEquals(1,new Library().selectMenuOption());
    }

    @Test
    public void shouldBeAbleToSelectMenuOption2(){
        Assert.assertEquals(2, new Library().selectMenuOption());
    }

    @Test
    public void shouldBeAbleToViewBooks() throws IOException{
        Library unit= new Library();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        unit.booksList.add(new Book1("hell",30,"mor"));
        unit.booksList.add(new Book1("book2",34,"vinay"));

        unit.viewBooks(output);
        String string = new String(output.toByteArray());
        Assert.assertEquals("Book Number :0"+"Book name:hell"+"price :30.0"+"author :mor,"+"Book Number :1"+"Book name:book2"+"price :34.0"+"author :vinay,",string);
    }

    @Test
    public void shouldBeAbleToSelectBook(){

    }

    @Test
    public void shouldBeAbleToReserveBook(){
        Library unit = new Library();
        unit.booksList.add(new Book1("hell",30,"mor"));
        unit.booksList.add(new Book1("book2",34,"vinay"));

        unit.userList.add(new User());
        unit.userList.add(new User());

        Assert.assertTrue("book reserved",unit.reserveBookToUser(0,0));
    }


}