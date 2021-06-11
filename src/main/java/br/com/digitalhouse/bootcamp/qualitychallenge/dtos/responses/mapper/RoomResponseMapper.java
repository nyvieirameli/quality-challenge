package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.mapper;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper.Helper;

import java.util.List;
import java.util.stream.Collectors;

public interface RoomResponseMapper {

    static List<RoomResponseDTO> fromRoomRequestList(List<RoomRequestDTO> roomRequestDTOS, Double areaPrice) {
        return roomRequestDTOS.stream().map(r -> fromRoomRequestDTO(r, areaPrice)).collect(Collectors.toList());
    }

    static RoomResponseDTO fromRoomRequestDTO(RoomRequestDTO room, Double areaPrice) {
        var area = Helper.calculateArea(room.getWidth(), room.getHeight());

        return new RoomResponseDTO(room.getName(), area, Helper.calculatePrice(area, areaPrice));
    }
}
