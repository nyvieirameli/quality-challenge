package br.com.digitalhouse.bootcamp.qualitychallenge.repositories.impl;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.NeighborhoodDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.repositories.interfaces.NeighborhoodRepository;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.NotFoundException;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper.Helper;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper.JsonHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeighborhoodRepositoryImpl implements NeighborhoodRepository {

    static TypeReference<List<NeighborhoodDTO>> typeRef = new TypeReference<List<NeighborhoodDTO>>() {};
    JsonHelper<NeighborhoodDTO> jsonHelper;

    public NeighborhoodRepositoryImpl() {
        this.jsonHelper = new JsonHelper<>("neighborhood", typeRef);
    }

    @Override
    public List<NeighborhoodDTO> getAllList() {
        return jsonHelper.getJsonObject();
    }

    @Override
    public NeighborhoodDTO getByName(String name) {
        var list = getAllList();

        var optional = list.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst();

        if (optional.isEmpty()) {
            throw new NotFoundException("Neighborhood not found");
        }

        return optional.get();
    }

    @Override
    public Double getAreaPriceByName(String name) {
        var neighborhood = getByName(name);

        return neighborhood.getAreaPrice();
    }
}
