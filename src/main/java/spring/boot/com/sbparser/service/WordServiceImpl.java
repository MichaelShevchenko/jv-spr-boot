package spring.boot.com.sbparser.service;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.boot.com.sbparser.repository.WordRepository;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<String> findMostUsed(int quantity) {
        return wordRepository.findMostUsed(PageRequest.of(0, quantity));
    }
}
