import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Book1 {

    private int bookNumber;
    private String name;
    private Double price;
    private String author;
    private boolean reserveStatus=false;
    public static int bookNumberGenerator;

    public Book1(String name, double price, String author){
        this.bookNumber=bookNumberGenerator++;
        this.name=name;
        this.price=price;
        this.author=author;
    }

    public void displayBook(OutputStream output)throws IOException{
        output.write(("Book Number :"+bookNumber).toString().getBytes());
        output.write(("Book name:"+name).getBytes());
        output.write(("price :"+price.toString()).getBytes());
        output.write(("author :"+author).getBytes());
    }

    public boolean getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(boolean reserveStatus) {
        this.reserveStatus = reserveStatus;
    }
}

