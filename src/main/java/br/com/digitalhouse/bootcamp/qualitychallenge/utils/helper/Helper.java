package br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper;

import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.BadRequestException;

import java.text.DecimalFormat;
import java.util.List;

public class Helper {

    public static Double calculateArea(Double width, Double height) {
        if (width > 0 && height > 0) {

            var numberFomated = new DecimalFormat("0.00").format((width * height));
            return Double.parseDouble(numberFomated);
        }

        throw new BadRequestException("Width and Height must be positive values");
    }

    public static Double calculatePrice(Double area, Double areaPrice) {
        if (area > 0 && areaPrice > 0) {

            var numberFomated = new DecimalFormat("0.00").format((area * areaPrice));
            return Double.parseDouble(numberFomated);
        }

        throw new BadRequestException("Price can`t be calculate");
    }

    public static <T> void validateList(List<T> list) {
        if (list == null || list.size() == 0) {
            throw new BadRequestException("List can`t be empty");
        }
    }
}
