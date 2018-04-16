package de.sadrab.Mp11PiratesoftheCodeBean.logic;

import de.sadrab.Mp11PiratesoftheCodeBean.persistence.Pirate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PirateServiceTest {

    private PirateService pirateService;

    @BeforeEach
    void before() {
        pirateService.deleteAll();
    }

    @Test
    void populatePirates() {
        List<Pirate> pirates = pirateService.findAll();
        assertTrue(pirates.isEmpty());

        pirateService.populatePirates();

        pirates = pirateService.findAll();
        assertFalse(pirates.isEmpty());
        assertEquals(9, pirates.size());
    }

    @Test
    void findAll() {
        List<Pirate> pirates = pirateService.findAll();
        assertTrue(pirates.isEmpty());
    }
}