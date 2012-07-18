
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final String welcomeMessage;
    private final String menuList;
    protected List<Book1> booksList= new ArrayList<Book1>();
    protected List<User> userList=new ArrayList<User>();

    public Library()	{
        welcomeMessage="Welcome !";
        menuList="\n1.Display Books" +"   2.Reserve a Book" +"  3.Check Library number"+"   4.Exit";
    }

    public void displayWelcomeMessage(OutputStream output)throws IOException{
        output.write(welcomeMessage.getBytes());
    }

    public void displayMenuList(OutputStream output)throws IOException{
        output.write(menuList.getBytes());
    }

    public int selectMenuOption() {
        return getIntegerInputFromConsole();
    }

    private int getIntegerInputFromConsole() {
        int input = 0;
        try{
            input=new Scanner(System.in).nextInt();
        }
        catch(InputMismatchException e){
            System.err.println("invalid integer input !! Enter a valid integer");
            input=getIntegerInputFromConsole();
        }
        return input;
    }

    public int selectBookNumber(){
        int input=getIntegerInputFromConsole();
        if(input<booksList.size() && input>-1 ){
            return input;
        }
        return -1;
    }
    public void viewBooks(OutputStream output)throws IOException{
        for (Book1 aBooksList : booksList) {
            aBooksList.displayBook(output);
            output.write(',');
        }

    }

    public boolean reserveBookToUser(int bookNumber, int userNumber)throws IndexOutOfBoundsException{
        if(!booksList.get(bookNumber).getReserveStatus()){
            booksList.get(bookNumber).setReserveStatus(true);
            userList.get(userNumber).addBookTOCollection(booksList.get(bookNumber));
            return true;
        }
        else
            return false;
    }


}