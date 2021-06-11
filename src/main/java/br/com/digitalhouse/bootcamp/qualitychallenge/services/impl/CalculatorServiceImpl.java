package br.com.digitalhouse.bootcamp.qualitychallenge.services.impl;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.mapper.RoomResponseMapper;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.BadRequestException;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper.Helper;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public ClientResponseDTO calculateClientRequest(ClientRequestDTO request) {
        var totalArea = calculateTotalArea(request.getRooms());

        return new ClientResponseDTO(
                request.getName(),
                request.getNeighborhood(),
                totalArea,
                Helper.calculatePrice(totalArea),
                calculateRoomsArea(request.getRooms()));
    }

    @Override
    public Double calculateTotalArea(List<RoomRequestDTO> rooms) {
        Helper.validateList(rooms);

        return rooms.stream()
                .mapToDouble(r -> Helper.calculateArea(r.getWidth(), r.getHeight()))
                .reduce(0, Double::sum);
    }

    @Override
    public List<RoomResponseDTO> calculateRoomsArea(List<RoomRequestDTO> rooms) {
        validateRoomd(rooms);

        var responseList = RoomResponseMapper.fromRoomRequestList(rooms);

        Collections.sort(responseList);

        return responseList;
    }

    @Override
    public Double calculateTotalPrice(List<RoomRequestDTO> rooms) {
        validateRoomd(rooms);

        return null;
    }

    @Override
    public List<RoomResponseDTO> calculateRoomsPrice(List<RoomRequestDTO> rooms) {
        validateRoomd(rooms);

        return null;
    }

    @Override
    public RoomResponseDTO getTheBiggestRoom(List<RoomRequestDTO> rooms) {
        validateRoomd(rooms);

        var responseList = RoomResponseMapper.fromRoomRequestList(rooms);

        return Collections.max(responseList);
    }

    private void validateRoomd(List<RoomRequestDTO> rooms) {
        Helper.validateList(rooms);

        var roomWIthoutName = rooms.stream().filter(r -> r.getName().isBlank()).findFirst().isPresent();
        if (roomWIthoutName) {
            throw new BadRequestException("All rooms must have name");
        }
    }
}
