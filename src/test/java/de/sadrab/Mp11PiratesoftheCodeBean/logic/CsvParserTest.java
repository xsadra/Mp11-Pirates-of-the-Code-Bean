package de.sadrab.Mp11PiratesoftheCodeBean.logic;

import de.sadrab.Mp11PiratesoftheCodeBean.persistence.Pirate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CsvParserTest {


    @Autowired
    private CsvParser csvParser;

    @Test
    public void testPiratesLoad() {
        PirateModule pirateModule = new PirateModule("classpath:pirates.csv");

        List<Pirate> pirates = csvParser.asList(pirateModule);

        assertEquals(9, pirates.size());
    }
}