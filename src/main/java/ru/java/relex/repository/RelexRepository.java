package ru.java.relex.repository;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class RelexRepository {

    public List<Long> getContent(String path) {
        List<Long> file = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLong()) {
                long item = scanner.nextLong();
                file.add(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}
