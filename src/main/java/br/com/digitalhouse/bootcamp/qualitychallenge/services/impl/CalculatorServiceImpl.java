package br.com.digitalhouse.bootcamp.qualitychallenge.services.impl;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.exceptions.BadRequestException;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public ResponseDTO<ClientResponseDTO> calculateClientRequest(ClientRequestDTO request) {
        validateRequest(request);

        var totalArea = calculateTotalArea(request.getRooms());

        var clientResponse = new ClientResponseDTO(
                request.getName(),
                request.getNeighborhood(),
                totalArea,
                calculatePrice(totalArea),
                calculateRoomsArea(request.getRooms()));

        return new ResponseDTO(clientResponse);
    }

    public void validateRequest(ClientRequestDTO request) {
        if (request == null) {
            throw new BadRequestException("Body can't be null");
        }

        if (request.getName().isBlank() || request.getNeighborhood().isBlank()) {
            throw new BadRequestException("Review name and/or neighborhood fields");
        }

        if (request.getRooms() == null || request.getRooms().size() == 0) {
            throw new BadRequestException("Rooms list can`t be empty");
        }
    }

    public Double calculateTotalArea(List<RoomRequestDTO> rooms) {
        return rooms.stream()
                .mapToDouble(r -> calculateArea(r.getWidth(), r.getHeight()))
                .reduce(0, Double::sum);
    }

    public List<RoomResponseDTO> calculateRoomsArea(List<RoomRequestDTO> rooms) {
        var roomsResponse = new ArrayList<RoomResponseDTO>();

        for (var room : rooms) {
            var area = calculateArea(room.getWidth(), room.getHeight());

            roomsResponse.add(new RoomResponseDTO(
                    room.getName(),
                    area,
                    calculatePrice(area))
            );
        }

        return roomsResponse;
    }

    public Double calculateArea(Double width, Double height) {
        if (width > 0 && height > 0) {

            return width * height;
        }

        throw new BadRequestException("Width and Height must be positive values");
    }

    public Double calculatePrice(Double area) {
        if (area > 0) {

            return 0.0;
        }

        throw new BadRequestException("Price can`t be calculate");
    }
}
