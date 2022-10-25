package ru.java.relex.repository;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class RelexRepository {
    public List<Long> getContent(String path) {
        List<Long> file = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Long item = Long.parseLong(line);
                file.add(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}
