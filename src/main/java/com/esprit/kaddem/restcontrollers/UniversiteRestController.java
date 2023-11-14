package com.esprit.kaddem.restcontrollers;

import com.esprit.kaddem.repositories.UniversiteRepository;
import com.esprit.kaddem.restcontrollers.dtos.UniversiteDTO;
import com.esprit.kaddem.services.UniversiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esprit.kaddem.entities.Universite;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteRestController {

    @Autowired
    private UniversiteServiceImpl universiteService;
    private final UniversiteRepository universiteRepository;

    @Autowired
    public UniversiteRestController(UniversiteServiceImpl universiteService, UniversiteRepository universiteRepository) {
        this.universiteService = universiteService;
        this.universiteRepository = universiteRepository;
    }

    // http://localhost:8089/Kaddem/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")
    @ResponseBody
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    // http://localhost:8089/Kaddem/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{universite-id}")
    @ResponseBody
    public Universite retrieveUniversite(@PathVariable("universite-id") Integer universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    // http://localhost:8089/Kaddem/universite/add-universite
    @PostMapping("/add-universite")
    @ResponseBody
    public ResponseEntity<UniversiteDTO> addUniversite(@RequestBody UniversiteDTO universiteDTO) {
        Universite universite = new Universite();
        universite.setNomUniv(universiteDTO.getNomUniv());

        // Utilize the service to add the Universite entity
        universite = universiteRepository.save(universite);

        UniversiteDTO responseDTO = new UniversiteDTO();
        responseDTO.setNomUniv(universite.getNomUniv());

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // http://localhost:8089/Kaddem/universite/update-universite
    @PutMapping("/update-universite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody UniversiteDTO universiteDTO) {
        Universite universite = new Universite();
        universite.setNomUniv(universiteDTO.getNomUniv());

        return universiteService.updateUniversite(universite);
    }

    @DeleteMapping("/delete-universite/{universite-id}")
    public ResponseEntity<Void> deleteUniversite(@PathVariable("universite-id") Integer universiteId) {
        try {
            universiteService.deleteUniversite(universiteId);
            return ResponseEntity.ok().build(); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
        }
    }
}
