package de.sadrab.Mp11PiratesoftheCodeBean.logic;

import de.sadrab.Mp11PiratesoftheCodeBean.persistence.PieceOfEightRepository;
import de.sadrab.Mp11PiratesoftheCodeBean.persistence.Pirate;
import de.sadrab.Mp11PiratesoftheCodeBean.persistence.PirateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PirateService {

    private PirateRepository pirateRepository;

    private PieceOfEightRepository pieceOfEightRepository;

    private CsvParser csvParser;

    public PirateService(PirateRepository pirateRepository, PieceOfEightRepository pieceOfEightRepository, CsvParser csvParser) {
        this.pirateRepository = pirateRepository;
        this.pieceOfEightRepository = pieceOfEightRepository;
        this.csvParser = csvParser;
    }

    public void populatePirates() {

        // delete all the pirates and pieces of eight from the database
        deleteAll();
        // use the csvParser to get a list of all the pirates, the path should be "classpath:pirates.csv"
        PirateModule pirateModule = new PirateModule("classpath:pirates.csv");
        List<Pirate> pirates = csvParser.asList(pirateModule);
        pirates.stream()
                .forEach(pirate -> {
                    // for each pirate, save first manually the piece of eight,
                    pieceOfEightRepository.save(pirate.getPieceOfEight());
                    // connect it to the corresponding pirate and then save the pirate
                    pirateRepository.save(pirate);
                });
    }

    public List<Pirate> findAll() {
        // return all the pirates from the database
        return pirateRepository.findAll();
    }

    public void deleteAll() {

        // delete all pirates
        // delete all pieces of eight
        pirateRepository.deleteAll();
        pieceOfEightRepository.deleteAll();

    }
}
