import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Book {

    private int bookNumber;
    private String name;
    private Double price;
    private String author;
    private boolean reserveStatus=false;
    public static int bookNumberGenerator;

    public Book(String name, double price, String author){
        this.bookNumber=bookNumberGenerator++;
        this.name=name;
        this.price=price;
        this.author=author;
    }

    public void displayBook(OutputStream output)throws IOException{
        output.write(("\n\nBook Number :"+bookNumber).toString().getBytes());
        output.write(("\nBook name:"+name).getBytes());
        output.write(("\nprice :"+price.toString()).getBytes());
        output.write(("\nauthor :"+author).getBytes());
    }

    public boolean getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(boolean reserveStatus) {
        this.reserveStatus = reserveStatus;
    }
}

