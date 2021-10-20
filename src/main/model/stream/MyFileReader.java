package main.model.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.model.Promotion;
import main.model.good.Good;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    ObjectMapper objectMapper = new ObjectMapper();

    public <T extends Good> List readGoods(String path, Class goodClass) {
        List<T> goods = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))) {
            goods = objectMapper.readValue(ois.readObject().toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, goodClass));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return goods;
    }

    public List<Promotion> readPromotions(String path) {
        List<Promotion> promotions = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))) {
            promotions = objectMapper.readValue(ois.readObject().toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, Promotion.class));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return promotions;
    }
}
