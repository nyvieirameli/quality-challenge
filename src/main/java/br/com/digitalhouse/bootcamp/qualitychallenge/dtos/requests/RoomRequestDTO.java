package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class RoomRequestDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @Positive
    private Double width;

    @NotNull
    @Positive
    private Double height;

    public RoomRequestDTO() {
    }

    public RoomRequestDTO(String name, Double width, Double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
