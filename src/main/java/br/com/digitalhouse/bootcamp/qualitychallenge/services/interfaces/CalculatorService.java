package br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;

import java.util.List;

public interface CalculatorService {

    ClientResponseDTO calculateClientRequest(ClientRequestDTO request);
    Double calculateTotalArea(List<RoomRequestDTO> rooms);
    List<RoomResponseDTO> calculateRoomsArea(List<RoomRequestDTO> rooms);
    Double calculateTotalPrice(List<RoomRequestDTO> rooms);
    List<RoomResponseDTO> calculateRoomsPrice(List<RoomRequestDTO> rooms);
    RoomResponseDTO getTheBiggestRoom(List<RoomRequestDTO> rooms);
}
