package spring.boot.com.sbparser;

import java.io.FileNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbParserApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(SbParserApplication.class, args);
    }

}
