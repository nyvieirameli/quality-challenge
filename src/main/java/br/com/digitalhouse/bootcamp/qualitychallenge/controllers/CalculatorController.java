package br.com.digitalhouse.bootcamp.qualitychallenge.controllers;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces.CalculatorService;
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
    public ResponseEntity calculateArea(@Valid @RequestBody ClientRequestDTO clientRequest) {
        var response = service.calculateClientRequest(clientRequest);

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/total-area")
    public ResponseEntity calculateTotalArea(@Valid @RequestBody List<RoomRequestDTO> roomRequestList) {
        var response = service.calculateTotalArea(roomRequestList);

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/rooms-area")
    public ResponseEntity calculateRoomsArea(@Valid @RequestBody List<RoomRequestDTO> roomRequestList) {
        var response = service.calculateRoomsArea(roomRequestList);

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/total-price")
    public ResponseEntity calculateTotalPrice(@Valid @RequestBody List<RoomRequestDTO> roomRequestList) {
        var response = service.calculateTotalPrice(roomRequestList);

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/rooms-price")
    public ResponseEntity calculateRoomsPrice(@Valid @RequestBody List<RoomRequestDTO> roomRequestList) {
        var response = service.calculateRoomsPrice(roomRequestList);

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity calculateBiggestRoom(@Valid @RequestBody List<RoomRequestDTO> roomRequestList) {
        var response = service.getTheBiggestRoom(roomRequestList);

        return new ResponseEntity(new ResponseDTO(response), HttpStatus.OK);
    }
}
