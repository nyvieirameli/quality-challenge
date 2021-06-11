package br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;

import java.util.List;

public interface CalculatorService {

    ClientResponseDTO calculateClientRequest(ClientRequestDTO request);
    Double calculateTotalArea(List<RoomRequestDTO> rooms);
    Double calculateTotalPrice(List<RoomRequestDTO> rooms, String neighborhood);
    List<RoomResponseDTO> calculateRoomsResponse(List<RoomRequestDTO> rooms, String neighborhood);
    RoomResponseDTO getTheBiggestRoom(List<RoomRequestDTO> rooms, String neighborhood);
}
