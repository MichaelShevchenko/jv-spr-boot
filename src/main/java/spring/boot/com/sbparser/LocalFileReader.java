package spring.boot.com.sbparser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LocalFileReader implements CsvFileReader {
    private static final String[] FILE_HEADER = {"Id", "ProductId", "UserId", "ProfileName",
            "HelpfulnessNumerator", "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"};
    private final Reader reader;

    public LocalFileReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public List<CSVRecord> readReviewsFile() {
        List<CSVRecord> fileData = new ArrayList<>();
        try (reader) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader(FILE_HEADER)
                    .withFirstRecordAsHeader()
                    .parse(reader);
            records.forEach(fileData::add);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read a CSV file", e);
        }
        return fileData;
    }
}
