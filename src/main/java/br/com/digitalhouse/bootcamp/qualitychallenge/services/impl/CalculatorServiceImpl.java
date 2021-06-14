package br.com.digitalhouse.bootcamp.qualitychallenge.services.impl;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.mapper.RoomResponseMapper;
import br.com.digitalhouse.bootcamp.qualitychallenge.repositories.interfaces.NeighborhoodRepository;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.BadRequestException;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper.Helper;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    NeighborhoodRepository repository;

    public CalculatorServiceImpl(NeighborhoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientResponseDTO calculateClientRequest(ClientRequestDTO request) {
        if (!Character.isUpperCase(request.getName().charAt(0))) {
            throw new BadRequestException("The property name must start with uppercase char");
        }

        var totalArea = calculateTotalArea(request.getRooms());

        return new ClientResponseDTO(
                request.getName(),
                request.getNeighborhood(),
                totalArea,
                calculateTotalPrice(request.getRooms(), request.getNeighborhood()),
                calculateRoomsResponse(request.getRooms(), request.getNeighborhood()));
    }

    @Override
    public Double calculateTotalArea(List<RoomRequestDTO> rooms) {
        validateRooms(rooms);

        return rooms.stream()
                .mapToDouble(r -> Helper.calculateArea(r.getWidth(), r.getHeight()))
                .reduce(0, Double::sum);
    }

    @Override
    public Double calculateTotalPrice(List<RoomRequestDTO> rooms, String neighborhood) {
        validateRooms(rooms);

        var areaPrice = repository.getAreaPriceByName(neighborhood);

        return rooms.stream()
                .mapToDouble(r ->
                    Helper.calculatePrice(Helper.calculateArea(r.getWidth(), r.getHeight()), areaPrice)
                )
                .reduce(0, Double::sum);
    }

    @Override
    public List<RoomResponseDTO> calculateRoomsResponse(List<RoomRequestDTO> rooms, String neighborhood) {
        validateRooms(rooms);

        var areaPrice = repository.getAreaPriceByName(neighborhood);

        var responseList = RoomResponseMapper.fromRoomRequestList(rooms, areaPrice);

        Collections.sort(responseList);

        return responseList;
    }

    @Override
    public RoomResponseDTO getTheBiggestRoom(List<RoomRequestDTO> rooms, String neighborhood) {
        validateRooms(rooms);

        var areaPrice = repository.getAreaPriceByName(neighborhood);

        var responseList = RoomResponseMapper.fromRoomRequestList(rooms, areaPrice);

        return Collections.max(responseList);
    }

    private void validateRooms(List<RoomRequestDTO> rooms) {
        Helper.validateList(rooms);

        if (rooms.stream().anyMatch(r -> r.getName().isBlank())) {
            throw new BadRequestException("All rooms must have name");
        }

        if (rooms.stream().anyMatch(r -> !Character.isUpperCase(r.getName().charAt(0)))) {
            throw new BadRequestException("All rooms name must start with uppercase char");
        }

        if (rooms.stream().anyMatch(r -> r.getWidth() > 25 || r.getHeight() > 33)) {
            throw new BadRequestException("The biggest size for a room is 25m of width and 33 of height");
        }
    }
}
