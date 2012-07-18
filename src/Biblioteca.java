import java.io.IOException;

public class Biblioteca {

    public static void main(String args[]) throws IOException,IndexOutOfBoundsException{
        Library library= new Library();
        User user=new User();
        int optionSelected;
        int bookNumber;



        library.booksList.add(new Book1("hell",30,"mor"));
        library.booksList.add(new Book1("book2",34,"vinay"));
        library.userList.add(user);

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
                        if(library.reserveBookToUser(bookNumber,user.getUserNumber())){
                            System.out.println( "Thank You! Enjoy the book.");
                        }
                        else
                            System.out.println("Sorry we don't have that book yet.");
                    else
                        System.out.println("Invalid Book Number");
                    break;
                case 3:
                    System.out.println("User Number :"+user.getUserNumber()+"   \nPlease talk to Librarian. Thank you.");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Select a valid option!!");

            }
        }while (optionSelected!=4);

    }
}
