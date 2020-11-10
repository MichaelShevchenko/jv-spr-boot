package spring.boot.com.sbparser;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbParserApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(SbParserApplication.class, args);

        FileReader fileToRead = new FileReader(new File("src/test/resources/test.csv"));
        CsvFileReader newCsvReader = new LocalFileReader(new CSVReader(fileToRead));
        List<String[]> result = newCsvReader.readReviewsFile();
        for (String[] review : result) {
            System.out.println(Arrays.toString(review));
        }
    }

}
