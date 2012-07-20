
import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MovieTest {

    @Test
    public void shouldBeAbleToCreateMovieObjectWithDefaultRating(){
       Assert.assertNotNull("movie object created",Movie.createMovie("superman", "unknow"));
    }
    @Test
    public void shouldBeAbleToCreateMovieObjectWithRating(){
        Assert.assertNotNull("movie object created",Movie.createMovie("superman", "unknow","N/A"));
    }

    @Test
    public void shouldBeAbleToDisplayMovie() throws IOException {
        Movie movie=Movie.createMovie("superman","unknown");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        movie.displayMovie(output);
        String string= new String(output.toByteArray());
        Assert.assertEquals("\nMovie name Director Rating"+" superman   unknown    5",string);
    }

}
