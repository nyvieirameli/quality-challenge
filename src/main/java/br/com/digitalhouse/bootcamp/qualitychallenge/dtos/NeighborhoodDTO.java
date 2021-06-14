package br.com.digitalhouse.bootcamp.qualitychallenge.dtos;

public class NeighborhoodDTO {

    private String name;

    private Double areaPrice;

    public NeighborhoodDTO() {
    }

    public NeighborhoodDTO(String name, Double areaPrice) {
        this.name = name;
        this.areaPrice = areaPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAreaPrice() {
        return areaPrice;
    }

    public void setAreaPrice(Double areaPrice) {
        this.areaPrice = areaPrice;
    }

    @Override
    public String toString() {
        return "NeighborhoodDTO{" +
                "name='" + name + '\'' +
                ", areaPrice=" + areaPrice +
                '}';
    }
}
