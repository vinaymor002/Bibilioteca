import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Movie {
    private String movieName;
    private String director;
    private String rating;


    public static Movie createMovie(String movieName, String director) {
        Movie movie =new Movie();
        movie.movieName=movieName;
        movie.director=director;
        movie.rating="5";
        return movie;
    }
    public static Movie createMovie(String movieName, String director, String rating) {
        Movie movie =new Movie();
        movie.movieName=movieName;
        movie.director=director;
        movie.rating=rating;
        return movie;
    }
    public void displayMovie(OutputStream output) throws IOException {
        output.write("\nMovie name Director Rating".getBytes());
        output.write((" "+movieName+"   "+director+"    "+rating).getBytes());
    }


}
