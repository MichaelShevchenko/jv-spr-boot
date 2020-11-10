package spring.boot.com.sbparser;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalFileReader implements CsvFileReader {
    private static final String[] FILE_HEADER = {"Id", "ProductId", "UserId", "ProfileName",
            "HelpfulnessNumerator", "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"};
    private final CSVReader reader;

    public LocalFileReader(CSVReader reader) {
        this.reader = reader;
    }

    @Override
    public List<String[]> readReviewsFile() {
        List<String[]> fileData = new ArrayList<>();
        try (reader) {
            String[] nextRecord;
            while ((nextRecord = reader.readNext()) != null) {
                if (Arrays.equals(nextRecord, FILE_HEADER)) {
                    continue;
                }
                fileData.add(nextRecord);
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read a CSV file", e);
        }
        return fileData;
    }
}
