package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class ClientRequestDTO {

    @NotBlank(message = "Review field name")
    @Size(min = 3, max = 255, message = "The name must be between 3 and 255 chars")
    private String name;

    @NotBlank(message = "Review field neighborhood")
    @Size(min = 3, max = 255, message = "The neighborhood must be between 1 and 255 chars")
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
