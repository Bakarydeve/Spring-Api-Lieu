package com.services;

import com.dtos.LieuDto;

import java.util.List;

public interface LieuService {

    /**
     * Sauve a lieu
     */
    LieuDto saveLieu(LieuDto lieuDto);

    /**
     * Update a lieu
     */
    LieuDto updateLieu(Long lieuId, LieuDto lieuDto);

    /**
     * Get a lieu by it's id
     */
    LieuDto getLieuById(Long LieuId);

    /**
     * Delete a lieu by it's id
     */
    boolean deleteLieu(Long lieuId);

    /**
     * Get all the lieux
     */
    List<LieuDto> getAlllieux();

}
