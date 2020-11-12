package spring.boot.com.sbparser;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class LocalFileReaderTest {
    private static final String NON_EXISTENT_FILE_NAME = "src/test/resources/tet.csv";
    private static final String APPROPRIATE_DATA_FILE = "src/test/resources/test1.csv";
    private static final List<String[]> PROPER_DATA_RESULT =
            List.of(new String[]{"11", "B0001PB9FE", "A3HDKO7OW0QNK4", "Canadian Fan",
                            "1", "1", "5", "1107820800", "The Best Hot Sauce in the World",
                            "I don't know if it's the cactus or the tequila or just the "
                                    + "unique combination of ingredients, but the flavour "
                                    + "of this hot sauce makes it one of a kind!  We picked "
                                    + "up a bottle once on a trip we were on and brought it "
                                    + "back home with us and were totally blown away!  When we"
                                    + " realized that we simply couldn't find it anywhere in "
                                    + "our city we were bummed.<br /><br />Now, because of "
                                    + "the magic of the internet, we have a case of the sauce "
                                    + "and are ecstatic because of it.<br /><br />If you love "
                                    + "hot sauce..I mean really love hot sauce, but don't want "
                                    + "a sauce that tastelessly burns your throat, grab a bottle "
                                    + "of Tequila Picante Gourmet de Inclan.  Just realize that "
                                    + "once you taste it, you will never want to use any other "
                                    + "sauce.<br /><br />Thank you for the personal, incredible service!"},
                    new String[]{"Id", "ProductId", "UserId", "ProfileName",
                            "HelpfulnessNumerator", "HelpfulnessDenominator", "Score",
                            "Time", "Summary", "Text"});

    @Test
    public void getExceptionWhenFileNotExist() {
        assertThrows(FileNotFoundException.class, () ->
                new LocalFileReader(new CSVReader
                        (new FileReader(new File(NON_EXISTENT_FILE_NAME)))));
    }

    @Test
    public void readProperDataFile() throws FileNotFoundException {
        FileReader fileToRead = new FileReader(new File(APPROPRIATE_DATA_FILE));
        CsvFileReader reader = new LocalFileReader(new CSVReader(fileToRead));
        List<String[]> result = reader.readReviewsFile();
        for (int i = 0; i < result.size(); i++) {
            assertArrayEquals(PROPER_DATA_RESULT.get(i), result.get(i));
        }
    }
}
