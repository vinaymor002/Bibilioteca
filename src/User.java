import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class User {
    public static final Integer STARTING_USER_NUMBER=0;

    private int userNumber;
    private List<Book1> bookCollectionList=new ArrayList<Book1>();
    public static int userNumberGenerator=STARTING_USER_NUMBER;

    public User(){
        this.userNumber=userNumberGenerator++;
    }

    public void addBookTOCollection(Book1 book){
        bookCollectionList.add(book);
    }

    public int getUserNumber() {
        return userNumber;
    }
}
