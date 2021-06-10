package br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ResponseDTO;

public interface CalculatorService {

    public ResponseDTO<ClientResponseDTO> calculateClientRequest(ClientRequestDTO request);

}
