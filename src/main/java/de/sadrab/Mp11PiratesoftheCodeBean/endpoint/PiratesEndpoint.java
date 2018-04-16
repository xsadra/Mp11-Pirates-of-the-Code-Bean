package de.sadrab.Mp11PiratesoftheCodeBean.endpoint;

import de.sadrab.Mp11PiratesoftheCodeBean.logic.PirateService;
import de.sadrab.Mp11PiratesoftheCodeBean.persistence.Pirate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pirates")
public class PiratesEndpoint {

    private PirateService pirateService;

    public PiratesEndpoint(PirateService pirateService) {
        this.pirateService = pirateService;
    }

    @GetMapping
    List<Pirate> findAll() {
        pirateService.populatePirates();
        return pirateService.findAll();
    }
}
