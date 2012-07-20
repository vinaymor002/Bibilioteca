import java.util.ArrayList;
import java.util.List;



public class User {
    public static final String STARTING_USER_NUMBER="111-1111";

    private String userNumber;
    private String userPassword;
    private List<Book> bookCollectionList=new ArrayList<Book>();
    public static String userNumberGenerator=STARTING_USER_NUMBER;


    public User(){
        this.userNumber=userNumberGenerator;
        this.userPassword="password";
        updateUserNumberGenerator();
    }
    private void updateUserNumberGenerator(){

        String firstPart = userNumberGenerator.substring(0,3);
        String secondPart= userNumberGenerator.substring(4,userNumberGenerator.length());
        int number=Integer.parseInt(secondPart);
        number++;
        secondPart=String.valueOf(number);
        userNumberGenerator=firstPart+"-"+secondPart;

    }
    public void addBookTOCollection(Book book){
        bookCollectionList.add(book);
    }

    public String getUserNumber() {
        return userNumber;
    }

    public boolean validateUserPassword(String userPassword) {
        if(userPassword.equals(this.userPassword))
            return true;
        return false;
    }
}
