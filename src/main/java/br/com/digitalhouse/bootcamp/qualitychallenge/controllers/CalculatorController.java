package br.com.digitalhouse.bootcamp.qualitychallenge.controllers;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

        return new ResponseEntity(response, HttpStatus.OK);
    }

}
