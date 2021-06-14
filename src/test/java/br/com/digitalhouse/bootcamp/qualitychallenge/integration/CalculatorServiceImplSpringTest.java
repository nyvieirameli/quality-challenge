package br.com.digitalhouse.bootcamp.qualitychallenge.integration;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.ClientRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests.RoomRequestDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ClientResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.RoomResponseDTO;
import br.com.digitalhouse.bootcamp.qualitychallenge.services.interfaces.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorServiceImplSpringTest {

    @Autowired
    public CalculatorService service;

    @Test
    public void shouldCalculateClientRequestCorrectly() {
        var responseExpected = createExpectedClientResponse();

        var roomsRequest = createRoomsRequest("Quintal1", "Quintal2", 10.0, 10.0);
        var request = createClienteRequest("Nycolas Vieira", "Veloso", roomsRequest);
        var response = service.calculateClientRequest(request);

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
    }

    @Test
    public void shouldCalculateTotalAreaCorrectly() {
        var responseExpected = 200.0;

        var roomsRequest = createRoomsRequest("Quintal1", "Quintal2", 10.0, 10.0);
        var response = service.calculateTotalArea(roomsRequest);

        assertThat(response).isEqualTo(responseExpected);
    }

    @Test
    public void shouldCalculateTotalPriceCorrectly() {
        var responseExpected = 600000.0;

        var roomsRequest = createRoomsRequest("Quintal1", "Quintal2", 10.0, 10.0);
        var response = service.calculateTotalPrice(roomsRequest, "Veloso");

        assertThat(response).isEqualTo(responseExpected);
    }

    @Test
    public void shouldCalculateRoomsRequestCorrectly() {
        var responseExpected = createExpectedRoomsResponse();

        var roomsRequest = createRoomsRequest("Quintal1", "Quintal2", 10.0, 10.0);
        var response = service.calculateRoomsResponse(roomsRequest, "Veloso");

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
    }

    @Test
    public void shouldCalculateBiggestRoomCorrectly() {
        var responseExpected = new RoomResponseDTO("Quintal2", 100.0, 300000.0);

        var roomsRequest = new ArrayList<>(
                Arrays.asList(
                        new RoomRequestDTO("Quintal1", 5.0, 5.0),
                        new RoomRequestDTO("Quintal2", 10.0, 10.0),
                        new RoomRequestDTO("Quintal3", 7.0, 7.0)
                )
        );
        var response = service.getTheBiggestRoom(roomsRequest, "Veloso");

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
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
