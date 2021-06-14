package br.com.digitalhouse.bootcamp.qualitychallenge.controllers;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces.CalculatorService;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("calculate")
public class CalculatorController {

    CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @PostMapping("/area")
    public ResponseEntity<ResponseDTO<ClientResponseDTO>> calculateArea(@Valid @RequestBody ClientRequestDTO clientRequest) {
        var response = service.calculateClientRequest(clientRequest);

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/total-area")
    public ResponseEntity<ResponseDTO<Double>> calculateTotalArea(@Valid @RequestBody ClientRequestDTO clientRequest) {
        if (!Character.isUpperCase(clientRequest.getName().charAt(0))) {
            throw new BadRequestException("The property name must start with uppercase char");
        }

        var response = service.calculateTotalArea(clientRequest.getRooms());

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/total-price")
    public ResponseEntity<ResponseDTO<Double>> calculateTotalPrice(@Valid @RequestBody ClientRequestDTO clientRequest) {
        if (!Character.isUpperCase(clientRequest.getName().charAt(0))) {
            throw new BadRequestException("The property name must start with uppercase char");
        }

        var response = service.calculateTotalPrice(clientRequest.getRooms(), clientRequest.getNeighborhood());

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/rooms")
    public ResponseEntity<ResponseDTO<List<RoomResponseDTO>>> calculateRooms(@Valid @RequestBody ClientRequestDTO clientRequest) {
        if (!Character.isUpperCase(clientRequest.getName().charAt(0))) {
            throw new BadRequestException("The property name must start with uppercase char");
        }

        var response = service.calculateRoomsResponse(clientRequest.getRooms(), clientRequest.getNeighborhood());

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity<ResponseDTO<RoomResponseDTO>> calculateBiggestRoom(@Valid @RequestBody ClientRequestDTO clientRequest) {
        if (!Character.isUpperCase(clientRequest.getName().charAt(0))) {
            throw new BadRequestException("The property name must start with uppercase char");
        }

        var response = service.getTheBiggestRoom(clientRequest.getRooms(), clientRequest.getNeighborhood());

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }
}
