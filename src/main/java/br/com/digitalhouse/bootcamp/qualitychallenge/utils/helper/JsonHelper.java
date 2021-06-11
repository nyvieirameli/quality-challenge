package br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper;

import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.RepositoryNotAvaliableException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonHelper<T> {

    File file;
    ObjectMapper objectMapper;
    TypeReference<List<T>> typeRef;

    public JsonHelper(String fileName, TypeReference typeRef) {
        instanceJsonFile(fileName);
        this.objectMapper = new ObjectMapper();
        this.typeRef = typeRef;
    }

    private void instanceJsonFile(String fileName) {
        try {
            this.file = ResourceUtils.getFile("classpath:" + fileName + ".json");
        }
        catch (IOException e) {
            throw new RepositoryNotAvaliableException(e.getMessage());
        }
    }

    public List<T> getJsonObject() {
        try {
            return objectMapper.readValue(file,typeRef);
        }
        catch (IOException e) {
            try {
                return objectMapper.readValue(file,typeRef);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                throw new RepositoryNotAvaliableException(e.getMessage());
            }
        }
    }
}
