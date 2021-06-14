package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class RoomRequestDTO {

    @NotBlank(message = "Review rooms names")
    @Size(min = 3, max = 30, message = "The room name must be between 3 and 30 characters")
    private String name;

    @NotNull(message = "Width can`t be null")
    @Positive(message = "Width can`t be negative")
    private Double width;

    @NotNull(message = "Height can`t be null")
    @Positive(message = "Height can't be negative")
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
