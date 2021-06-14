package br.com.digitalhouse.bootcamp.qualitychallenge.unit;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.repositories.interfaces.NeighborhoodRepository;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.impl.CalculatorServiceImpl;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.BadRequestException;
import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CalculatorServiceImplTest {

    @Mock
    private NeighborhoodRepository repository;
    private CalculatorServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new CalculatorServiceImpl(repository);
    }

    @Test
    public void shouldCalculateClientRequestCorrectly() {
        var responseExpected = createExpectedClientResponse();

        when(repository.getAreaPriceByName("Veloso")).thenReturn(3000.00);

        var roomsRequest = createRoomsRequest("Quintal1", "Quintal2", 10.0, 10.0);
        var request = createClienteRequest("Nycolas Vieira", "Veloso", roomsRequest);
        var response = service.calculateClientRequest(request);

        verify(repository, atLeast(2)).getAreaPriceByName("Veloso");

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
    }

    @Test
    public void shouldCalculateClientRequestWithNullBody() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            service.calculateClientRequest(null);
        });
    }

    @Test
    public void shouldCalculateClientRequestWithNullValues() {
        var roomsRequest = createRoomsRequest(null, null, null, null);
        var request = createClienteRequest(null, null, roomsRequest);

        Assertions.assertThrows(NullPointerException.class, () -> {
            service.calculateClientRequest(request);
        });
    }

    @Test
    public void shouldCalculateClientRequestWithEmptyList() {
        var request = createClienteRequest("Nycolas Vieira", "Veloso", new ArrayList<>());

        Assertions.assertThrows(BadRequestException.class, () -> {
            service.calculateClientRequest(request);
        });
    }

    @Test
    public void shouldCalculateClientRequestWithZeroValues() {
        var roomsRequest = createRoomsRequest("Quintal1", "Quintal2", 0.0, 0.0);
        var request = createClienteRequest("Nycolas Vieira", "Veloso", roomsRequest);

        Assertions.assertThrows(BadRequestException.class, () -> {
            service.calculateClientRequest(request);
        });
    }

    private ClientRequestDTO createClienteRequest(String name, String neighborhood, List<RoomRequestDTO> rooms) {
        return new ClientRequestDTO("Nycolas Vieira", "Veloso", rooms);
    }

    private ArrayList<RoomRequestDTO> createRoomsRequest(String name1, String name2, Double width, Double height) {
        var rooms = new ArrayList<>(
                Arrays.asList(
                        new RoomRequestDTO(name1, width, height),
                        new RoomRequestDTO(name2, width, height)
                )
        );
        return rooms;
    }

    private ClientResponseDTO createExpectedClientResponse() {
        var roomsExpected = createExpectedRoomsResponse();

        return new ClientResponseDTO("Nycolas Vieira", "Veloso", 200.0, 600000.0, roomsExpected);
    }

    private ArrayList<RoomResponseDTO> createExpectedRoomsResponse() {
        var roomsExpected = new ArrayList<>(
                Arrays.asList(
                        new RoomResponseDTO("Quintal1", 100.0, 300000.0),
                        new RoomResponseDTO("Quintal2", 100.0, 300000.0)
                )
        );
        return roomsExpected;
    }

}
