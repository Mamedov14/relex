package ru.java.relex.repository;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RelexRepository {

    public List<Long> getContent(String path) {
        List<Long> longs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Long item = Long.parseLong(line);
                longs.add(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return longs;

    }
}
