package ru.java.relex.servise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Service
public class UtilsService {
    private final List<Long> file = new ArrayList<>();

    public List<Long> getReadFile(String path) {
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

    public Long getMax(String path) {
        List<Long> file = getReadFile(path);
        return file.stream().max(Long::compareTo).get();
    }

    public Long getMin(String path) {
        List<Long> file = getReadFile(path);
        return file.stream().min(Long::compareTo).get();
    }

    public Long getMedian(String path) {
        List<Long> file = getReadFile(path);
        file = file.stream().sorted().collect(Collectors.toList());
        return file.get(file.size() / 2);
    }

    public Double getAvg(String path) {
        List<Long> file = getReadFile(path);
        return file.stream().mapToDouble(e -> e).average().orElse(0);
    }


    public List<List<Long>> getAsc(String path) {
        return null;
    }

    public List<List<Long>> getDesc(String path) {
        return null;
    }
}
