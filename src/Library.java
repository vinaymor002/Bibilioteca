
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final String welcomeMessage;
    private final String menuList;
    private User logedInUser=null;
    protected List<Book> booksList= new ArrayList<Book>();
    protected List<User> userList=new ArrayList<User>();
    protected List<Movie> movieList=new ArrayList<Movie>(15);

    public Library()	{
        welcomeMessage="Welcome !";
        menuList="\n1.Display Books" +"   2.Reserve a Book" +"  3.Check Library number"+"    4.Display Movies"+"    5.Login/Logout"+"   6.Exit";
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
        for (Book aBooksList : booksList) {
            aBooksList.displayBook(output);
            output.write(',');
        }

    }

    public boolean reserveBookToUser(int bookNumber, String userNumber)throws IndexOutOfBoundsException{
        if(!booksList.get(bookNumber).getReserveStatus()){
            booksList.get(bookNumber).setReserveStatus(true);
            userList.get(getIndexOfUser(userNumber)).addBookTOCollection(booksList.get(bookNumber));
            return true;
        }
        else
            return false;
    }

    private int getIndexOfUser(String userNumber) {
        int counter=-1;
        for(User aUserList : userList){
            counter++;
            if(userNumber.equals(aUserList.getUserNumber())){
                return counter;
            }
        }
        return -1;
    }

    public void addMovieToLibrary(Movie movie){
        movieList.add(movie);
    }


    public void displayMovies(OutputStream output) throws IOException {
        for(Movie aMoviesList : movieList){
            aMoviesList.displayMovie(output);
        }
    }

    public User validateUserLogin(String userNumber, String userPassword) {
        for(int i=0;i<userList.size()-1;i++){
            if(userNumber.equals(userList.get(i).getUserNumber())){
                if(userList.get(i).validateUserPassword(userPassword)){
                    logedInUser=userList.get(i);
                    return logedInUser;
                }
                break;
            }
        }
        return null;
    }

    public User logoutUser(){
        logedInUser=null;
        return logedInUser;
    }

}