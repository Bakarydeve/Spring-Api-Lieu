package com.services.impl;

import com.dtos.LieuDto;
import com.entities.Lieu;
import com.repositories.LieuRepository;
import com.services.LieuService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("lieuService")
public class LieuServiceImpl implements LieuService {


    private final LieuRepository lieuRepository;

    public LieuServiceImpl(LieuRepository lieuRepository) {
        this.lieuRepository = lieuRepository;
    }

    /**
     * Sauve a lieu
     *
     * @param lieuDto
     */
    @Override
    public LieuDto saveLieu(LieuDto lieuDto) {
        // Converts the dto to the lieu entity
        Lieu lieu = lieuDtoToEntity(lieuDto);
        // Save the lieu entity
        lieu = lieuRepository.save(lieu);
        // Return the new dto
        return lieuEntityToDto(lieu);
    }

    /**
     * Update a lieu
     *
     * @param lieuId
     * @param lieuDto
     */
    @Override
    public LieuDto updateLieu(Long lieuId, LieuDto lieuDto) {
        if(lieuDto == null)  {
            throw new IllegalArgumentException("Le paramètre fourni est null");
        }
        Lieu lieu = lieuRepository.findById(lieuId).orElseThrow(() -> new EntityNotFoundException("Lieu not found"));

        if(lieuDto.getName() != null)  {
            lieu.setName(lieuDto.getName());
        }

        if(lieuDto.getAddress() != null)  {
            lieu.setAddress(lieuDto.getAddress());
        }


        lieu = lieuRepository.save(lieu);
        return lieuEntityToDto(lieu);
    }

    /**
     * Get a lieu by it's id
     *
     * @param LieuId
     */
    @Override
    public LieuDto getLieuById(Long LieuId) {
        Lieu lieu = lieuRepository.findById(LieuId).orElseThrow(() -> new EntityNotFoundException("Lieu not found"));
        return lieuEntityToDto(lieu);
    }

    /**
     * Delete a lieu by it's id
     *
     * @param lieuId
     */
    @Override
    public boolean deleteLieu(Long lieuId) {
        lieuRepository.deleteById(lieuId);
        return true;
    }

    /**
     * Get all the lieux
     */
    @Override
    public List<LieuDto> getAlllieux() {
        List<LieuDto> lieuDtos = new ArrayList<>();
        List<Lieu> lieux = lieuRepository.findAll();
        lieux.forEach(lieu -> {
            lieuDtos.add(lieuEntityToDto(lieu));
        });
        return lieuDtos;
    }


    /**
     * Map Lieu dto to Lieu entity
     */
    private LieuDto lieuEntityToDto(Lieu lieu){
        LieuDto lieuDto = new LieuDto();
        lieuDto.setId(lieu.getId());
        lieuDto.setName(lieu.getName());
        lieuDto.setAddress(lieu.getAddress());

        return lieuDto;
    }

    /**
     * Map lieu entity to lieu dto
     */
    private Lieu lieuDtoToEntity(LieuDto lieuDto){
        Lieu lieu = new Lieu();
        lieu.setId(lieuDto.getId());
        lieu.setName(lieuDto.getName());
        lieu.setAddress(lieuDto.getAddress());

        return lieu;
    }

}
