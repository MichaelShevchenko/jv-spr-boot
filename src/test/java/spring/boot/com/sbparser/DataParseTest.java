package spring.boot.com.sbparser;

import org.apache.commons.csv.CSVRecord;
import org.junit.Test;
import org.junit.Assert;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class DataParseTest {
    private static final String APPROPRIATE_DATA_FILE = "src/test/resources/test1.csv";
    private static final String WRONG_FORMAT_DATA_FILE = "src/test/resources/test2.csv";
    private static final String TEST_QUANTITY_DATA_FILE = "src/test/resources/test.csv";
    private static final int REVIEWS_QUANTITY = 34;
    private static final Review expectedReview = new Review();

    static {
        expectedReview.setReviewId(11);
        expectedReview.setProductId("B0001PB9FE");
        expectedReview.setUserId("A3HDKO7OW0QNK4");
        expectedReview.setProfileName("Canadian Fan");
        expectedReview.setHelpfulnessNumerator(1);
        expectedReview.setHelpfulnessDenominator(1);
        expectedReview.setScore(5);
        expectedReview.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(1107820800), ZoneId.systemDefault()));
        expectedReview.setSummary("The Best Hot Sauce in the World");
        expectedReview.setText("I don't know if it's the cactus or the tequila or just the unique combination "
                + "of ingredients, but the flavour of this hot sauce makes it one of a kind!  We picked up a bottle "
                + "once on a trip we were on and brought it back home with us and were totally blown away!  When we "
                + "realized that we simply couldn't find it anywhere in our city we were bummed.<br /><br />Now, "
                + "because of the magic of the internet, we have a case of the sauce and are ecstatic because of it."
                + "<br /><br />If you love hot sauce..I mean really love hot sauce, but don't want a sauce that "
                + "tastelessly burns your throat, grab a bottle of Tequila Picante Gourmet de Inclan.  Just "
                + "realize that once you taste it, you will never want to use any other sauce.<br /><br />"
                + "Thank you for the personal, incredible service!");
    }

    @Test
    public void parseProperDataFile() throws IOException {
        FileReader fileToRead = new FileReader(new File(APPROPRIATE_DATA_FILE));
        CsvFileReader reader = new LocalFileReader(fileToRead);
        List<CSVRecord> dataFromFile = reader.readReviewsFile();
        DataParser parser = new DataParser();
        List<Review> result = parser.parseDataToReviews(dataFromFile);
        Assert.assertEquals(expectedReview, result.get(0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void parseWrongFormatDataFile() throws IOException {
        FileReader fileToRead = new FileReader(new File(WRONG_FORMAT_DATA_FILE));
        CsvFileReader reader = new LocalFileReader(fileToRead);
        List<CSVRecord> dataFromFile = reader.readReviewsFile();
        DataParser parser = new DataParser();
        parser.parseDataToReviews(dataFromFile);
    }

    @Test
    public void parseCorrectReviewsAmount() throws IOException {
        FileReader fileToRead = new FileReader(new File(TEST_QUANTITY_DATA_FILE));
        CsvFileReader reader = new LocalFileReader(fileToRead);
        List<CSVRecord> dataFromFile = reader.readReviewsFile();
        DataParser parser = new DataParser();
        List<Review> result = parser.parseDataToReviews(dataFromFile);
        Assert.assertEquals(REVIEWS_QUANTITY, result.size());
    }
}
