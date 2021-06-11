package br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper;

import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.BadRequestException;

import java.util.List;

public class Helper {

    public static Double calculateArea(Double width, Double height) {
        if (width > 0 && height > 0) {

            return width * height;
        }

        throw new BadRequestException("Width and Height must be positive values");
    }

    public static Double calculatePrice(Double area) {
        if (area > 0) {

            return 0.0;
        }

        throw new BadRequestException("Price can`t be calculate");
    }

    public static <T> void validateList(List<T> list) {
        if (list == null || list.size() == 0) {
            throw new BadRequestException("List can`t be empty");
        }
    }
}
