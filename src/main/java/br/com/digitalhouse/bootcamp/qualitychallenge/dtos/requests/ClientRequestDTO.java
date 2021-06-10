package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ClientRequestDTO {

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @Size(min = 1, max = 255)
    private String neighborhood;

    @Valid
    private List<RoomRequestDTO> rooms;

    public ClientRequestDTO() {
    }

    public ClientRequestDTO(String name, String neighborhood, List<RoomRequestDTO> rooms) {
        this.name = name;
        this.neighborhood = neighborhood;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<RoomRequestDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomRequestDTO> rooms) {
        this.rooms = rooms;
    }
}
