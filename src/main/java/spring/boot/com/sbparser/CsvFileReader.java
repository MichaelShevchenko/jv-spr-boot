package spring.boot.com.sbparser;

import java.util.List;
import org.apache.commons.csv.CSVRecord;

public interface CsvFileReader {
    List<CSVRecord> readReviewsFile();
}
