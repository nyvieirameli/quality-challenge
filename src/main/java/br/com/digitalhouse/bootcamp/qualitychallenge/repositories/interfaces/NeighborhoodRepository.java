package br.com.digitalhouse.bootcamp.qualitychallenge.repositories.interfaces;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.NeighborhoodDTO;

import java.util.List;

public interface NeighborhoodRepository {

    List<NeighborhoodDTO> getAllList();
    NeighborhoodDTO getByName(String name);
    Double getAreaPriceByName(String name);

}
