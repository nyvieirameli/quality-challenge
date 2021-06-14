package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses;

import java.util.List;

public class ClientResponseDTO {

    private String name;

    private String neighborhood;

    private Double totalArea;

    private Double totalPrice;

    private Integer roomsQuantity;

    private List<RoomResponseDTO> rooms;

    public ClientResponseDTO() {
    }

    public ClientResponseDTO(String name, String neighborhood, Double totalArea, Double totalPrice, List<RoomResponseDTO> rooms) {
        this.name = name;
        this.neighborhood = neighborhood;
        this.totalArea = totalArea;
        this.totalPrice = totalPrice;
        this.roomsQuantity = rooms.size();
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

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(Integer roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }

    public List<RoomResponseDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomResponseDTO> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "ClientResponseDTO{" +
                "name='" + name + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", totalArea=" + totalArea +
                ", totalPrice=" + totalPrice +
                ", roomsQuantity=" + roomsQuantity +
                ", rooms=" + rooms +
                '}';
    }
}
