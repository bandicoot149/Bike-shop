package main.model.stream;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class MyFileWriter {

    ObjectMapper objectMapper = new ObjectMapper();

    public <T> void writeGoods(List<T> goods, String path) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)))) {
            oos.writeObject(objectMapper.writeValueAsString(goods));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
