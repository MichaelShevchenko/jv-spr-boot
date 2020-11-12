package spring.boot.com.sbparser;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DataParseTest {
    private static final String APPROPRIATE_DATA_FILE = "src/test/resources/test1.csv";

    @Test
    public void parseProperDataFile() throws IOException {
        Review reviewToCompare = new Review();
        reviewToCompare.setReviewId(11);
        reviewToCompare.setProductId("B0001PB9FE");
        reviewToCompare.setUserId("A3HDKO7OW0QNK4");
        reviewToCompare.setProfileName("Canadian Fan");
        reviewToCompare.setHelpfulnessNumerator(1);
        reviewToCompare.setHelpfulnessDenominator(1);
        reviewToCompare.setScore(5);
        reviewToCompare.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(1107820800), ZoneId.systemDefault()));
        reviewToCompare.setSummary("The Best Hot Sauce in the World");
        reviewToCompare.setText("I don't know if it's the cactus or the tequila or just the unique combination "
                + "of ingredients, but the flavour of this hot sauce makes it one of a kind!  We picked up a bottle "
                + "once on a trip we were on and brought it back home with us and were totally blown away!  When we "
                + "realized that we simply couldn't find it anywhere in our city we were bummed.<br /><br />Now, "
                + "because of the magic of the internet, we have a case of the sauce and are ecstatic because of it."
                + "<br /><br />If you love hot sauce..I mean really love hot sauce, but don't want a sauce that "
                + "tastelessly burns your throat, grab a bottle of Tequila Picante Gourmet de Inclan.  Just "
                + "realize that once you taste it, you will never want to use any other sauce.<br /><br />"
                + "Thank you for the personal, incredible service!");
        FileReader fileToRead = new FileReader(new File(APPROPRIATE_DATA_FILE));
        CsvFileReader reader = new LocalFileReader(fileToRead);
        List<CSVRecord> dataFromFile = reader.readReviewsFile();
        DataParser parser = new DataParser();
        List<Review> result = parser.parseDataToReviews(dataFromFile);
        assertEquals(reviewToCompare, result.get(0));
    }
}
