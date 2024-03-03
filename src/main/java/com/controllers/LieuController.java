package com.controllers;

import com.dtos.LieuDto;
import com.services.impl.LieuServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lieux")
public class LieuController {

    private final LieuServiceImpl lieuService;

    public LieuController(LieuServiceImpl lieuService) {
        this.lieuService = lieuService;
    }

    /**
     * <p>Get all lieux in the system</p>
     * @return List<LieuDto>
     */
    @Operation(summary = "Liste tous les lieux")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Une liste des lieux")
    })
    @CrossOrigin
    @GetMapping
    public List<LieuDto> getLieux() {
        return lieuService.getAlllieux();
    }

    /**
     * Method to get the lieu based on the ID
     */
    @Operation(summary = "Récupère un lieu par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Un lieu détaillé")
    })
    @CrossOrigin
    @GetMapping("/{lieuId}")
    public LieuDto getLieu(@PathVariable @NonNull Long lieuId){
        return lieuService.getLieuById(lieuId);
    }

    /**
     * Create a new Lieu in the system
     */
    @Operation(summary = "Crée un nouveau lieu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Nouveau lieu créé")
    })
    @CrossOrigin
    @PostMapping
    public LieuDto saveLieu(final @RequestBody @NonNull LieuDto lieuDto){
        return lieuService.saveLieu(lieuDto);
    }

    /**
     * Method to update the lieu based on the lieu
     */
    @Operation(summary = "Met à jour un lieu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lieu mis à jour")
    })
    @CrossOrigin
    @PutMapping("/{lieuId}")
    public LieuDto updateLieu(@PathVariable @NonNull Long lieuId, final @RequestBody @NonNull LieuDto lieuDto){
        return lieuService.updateLieu(lieuId, lieuDto);
    }

    /**
     * Delete a lieu by it's id
     */
    @Operation(summary = "Supprime un lieu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Lieu supprimé")
    })
    @CrossOrigin
    @DeleteMapping("/{lieuId}")
    public Boolean deleteLieu(@PathVariable @NonNull Long lieuId){
        return lieuService.deleteLieu(lieuId);
    }

}
