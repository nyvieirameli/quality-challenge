package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses;

public class RoomResponseDTO implements Comparable<RoomResponseDTO> {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(RoomResponseDTO room) {
        return this.area.compareTo(room.getArea());
    }

    @Override
    public String toString() {
        return "RoomResponseDTO{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", price=" + price +
                '}';
    }
}
