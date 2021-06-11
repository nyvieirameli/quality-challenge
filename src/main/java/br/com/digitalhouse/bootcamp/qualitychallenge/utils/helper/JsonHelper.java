package br.com.digitalhouse.bootcamp.qualitychallenge.utils.helper;

import br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions.RepositoryNotAvaliableException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper<T> {
    private File file;
    private String resourcesPath;
    private ObjectMapper mapper;
    private TypeReference<List<T>> typeRef;

    public JsonHelper(String resourcesPath, TypeReference<List<T>> type) {
        this.mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        this.typeRef = type;

        openOrCreateAndOpenFile(resourcesPath);
        this.resourcesPath = resourcesPath;
    }

    private void openOrCreateAndOpenFile(String resourcesPath) {
        var fullResourcePath = "file:src/main/resources/"+resourcesPath+".json";
        try{
            this.file = ResourceUtils.getFile(fullResourcePath);
            if (!this.file.exists())createFile();
        } catch (FileNotFoundException e) {
            try{
                this.file = new File(ResourceUtils.getURL(fullResourcePath).getPath());
            }catch (IOException ioException){
                throw  new RepositoryNotAvaliableException(ioException.getMessage());
            }
            createFile();
        }

    }

    private void createFile() {
        try{
            this.file.createNewFile();
            update(new ArrayList<T>());
        }catch (IOException e){
            throw  new RepositoryNotAvaliableException(e.getMessage());
        }

    }


    public List<T> retrieve() {
        try {
            return mapper.<List<T>>readValue(file,typeRef);
        } catch (IOException e) {
            try {
                return mapper.readValue(file,typeRef);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                throw new RepositoryNotAvaliableException("database unavailable");
            }
        }
    }

    public boolean update(List<T> data) {
        try {
            FileWriter f2 = new FileWriter(file, false);
            var jsonOrder = mapper.writeValueAsString(data);
            System.out.println(jsonOrder);
            f2.write(jsonOrder);
            f2.flush();
            f2.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            throw new RepositoryNotAvaliableException(e.getMessage());
        }
    }
}
