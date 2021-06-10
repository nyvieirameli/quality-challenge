package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses;

public class RoomResponseDTO {

    private String name;
    private Double area;
    private Double price;

    public RoomResponseDTO(String name, Double area, Double price) {
        this.name = name;
        this.area = area;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
