package com.example.gestionstage.controller;

import com.example.gestionstage.Exception.StageNotFoundException;
import com.example.gestionstage.dto.AddRapportDTO;
import com.example.gestionstage.dto.RapportDTO;
import com.example.gestionstage.services.rapportService.RapportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class RapportController {
    private RapportService rapportService;

    @GetMapping("/rapports")
    public List<RapportDTO> getAllRapport() {
        return rapportService.getRapports();
    }

    @GetMapping("/rapports/{rapportId}")
    public RapportDTO getRapportById(@PathVariable Long rapportId) {
        return rapportService.getRapportById(rapportId);
    }

    @PostMapping("/rapports")
    public RapportDTO saveRapport(@RequestBody AddRapportDTO addRapportDTO) throws StageNotFoundException {
        return rapportService.createRapport(addRapportDTO);

    }

    @DeleteMapping("/rapports/{rapportId}")
    public void deleteRapportById(@PathVariable Long rapportId) throws StageNotFoundException {
        rapportService.deleteRapport(rapportId);
    }
}
