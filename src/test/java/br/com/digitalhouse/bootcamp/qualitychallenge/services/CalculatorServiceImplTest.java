package br.com.digitalhouse.bootcamp.qualitychallenge.services;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.repositories.interfaces.NeighborhoodRepository;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplTest {

    @Mock
    private static NeighborhoodRepository repository;
    private static CalculatorServiceImpl service;

    @BeforeAll
    public static void init() {
        service = new CalculatorServiceImpl(repository);
    }

    @Test
    public void shouldCalculateClientRequestCorrectly() {
        var roomsExpeted = new ArrayList<>(
                Arrays.asList(
                        new RoomResponseDTO("Quintal1", 100.0, 3000000.0),
                        new RoomResponseDTO("Quintal2", 100.0, 3000000.0)
                )
        );
        var responseExpected = new ClientResponseDTO("Nycolas Vieira", "Veloso", 200.0, 6000000.0, roomsExpeted);

        var rooms = new ArrayList<>(
                Arrays.asList(
                        new RoomRequestDTO("Quintal1", 10.0, 10.0),
                        new RoomRequestDTO("Quintal2", 10.0, 10.0)
                )
        );
        var request = new ClientRequestDTO("Nycolas Vieira", "Veloso", rooms);
        var response = service.calculateClientRequest(request);

        assertSame(responseExpected, response);
    }

}
