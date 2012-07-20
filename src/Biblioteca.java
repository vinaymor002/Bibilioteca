import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Biblioteca {

    public static void main(String args[]) throws IOException,IndexOutOfBoundsException{
        Library library= new Library();
        User defaultUser=new User();
        User loggedInUser=null;

        int optionSelected;
        int bookNumber;
        String userNumber;
        String userPassword;

        addMoviesToLibrary(library);
        library.userList.add(defaultUser);
        addUsersToLibrary(library);
        library.booksList.add(new Book("hell",30,"mor"));
        library.booksList.add(new Book("book2",34,"vinay"));

        library.displayWelcomeMessage(System.out);
        do{
            library.displayMenuList(System.out);
            optionSelected=library.selectMenuOption();

            switch(optionSelected){
                case 1:
                    library.viewBooks(System.out);
                    break;
                case 2:
                    System.out.println("Enter Book Number :");
                    bookNumber=library.selectBookNumber();
                    if(bookNumber>-1)
                        if(library.reserveBookToUser(bookNumber, defaultUser.getUserNumber())){
                            System.out.println( "Thank You! Enjoy the book.");
                        }
                        else
                            System.out.println("Sorry we don't have that book yet.");
                    else
                        System.out.println("Invalid Book Number");
                    break;
                case 3:
                    if(loggedInUser==null)
                        System.out.println("\nPlease talk to Librarian. Thank you.");
                    else
                        System.out.println("User Number :" + loggedInUser.getUserNumber());
                    break;
                case 4:
                    library.displayMovies(System.out);
                    break;
                case 5:
                    if(loggedInUser==null){
                        System.out.print("User Number : ");
                        userNumber=readInput();
                        System.out.print("Password : ");
                        userPassword=readInput();

                        loggedInUser =library.validateUserLogin(userNumber,userPassword);
                        if(loggedInUser==null)
                        {
                            System.out.println("Invalid Login !!!");
                        }
                        else
                            System.out.println("Logged In Successfully !!!");
                    }
                    else{
                        loggedInUser=library.logoutUser();
                        System.out.println("User Logged Out");
                    }


                    break;
                case 6:
                    break;
                default:
                    System.out.println("Select a valid option!!");

            }
        }while (optionSelected!=6);

    }

    private static void addUsersToLibrary(Library library) {
        library.userList.add(new User());
        library.userList.add(new User());
        library.userList.add(new User());
        library.userList.add(new User());
        library.userList.add(new User());
    }

    private static String readInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input=null;
        try{
            input = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Error!");
            System.exit(1);
        }
        return input;
    }

    private static void addMoviesToLibrary(Library library) {
        library.addMovieToLibrary(Movie.createMovie("movie1","director1"));
        library.addMovieToLibrary(Movie.createMovie("movie2","director2"));
        library.addMovieToLibrary(Movie.createMovie("movie3","director3"));
        library.addMovieToLibrary(Movie.createMovie("movie4","director4"));
        library.addMovieToLibrary(Movie.createMovie("movie5","director5"));
        library.addMovieToLibrary(Movie.createMovie("movie6","director6"));
        library.addMovieToLibrary(Movie.createMovie("movie7","director7"));
        library.addMovieToLibrary(Movie.createMovie("movie8","director8"));
        library.addMovieToLibrary(Movie.createMovie("movie9","director9","N/A"));
        library.addMovieToLibrary(Movie.createMovie("movie10","director10","N/A"));
        library.addMovieToLibrary(Movie.createMovie("movie11","director11","N/A"));
        library.addMovieToLibrary(Movie.createMovie("movie12","director12","N/A"));
        library.addMovieToLibrary(Movie.createMovie("movie13","director13"));
        library.addMovieToLibrary(Movie.createMovie("movie14","director14"));
        library.addMovieToLibrary(Movie.createMovie("movie15","director15","N/A"));
    }
}
