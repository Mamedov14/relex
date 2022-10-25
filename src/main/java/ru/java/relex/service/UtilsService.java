package ru.java.relex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.java.relex.entity.Request;
import ru.java.relex.repository.RelexRepository;

import javax.xml.bind.DatatypeConverter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class UtilsService {

    private final RelexRepository relexRepository;

    private Map<String, Object> cache = new HashMap<>();

    public Object getResult(Request request) {
        switch (request.getOperation()) {
            case "get_max_value" -> {
                return getMax(request);
            }
            case "get_min_value" -> {
                return getMin(request);
            }
            case "get_median_value" -> {
                return getMedian(request);
            }
            case "get_avg_value" -> {
                return getAvg(request);
            }
            case "get_asc_sequence" -> {
                return getAsc(request);
            }
            case "get_desc_sequence" -> {
                return getDesc(request);
            }
            default -> {
                return "not found operation";
            }
        }
    }

    public Long getMax(Request request) {
        String key = getKeyByRequest(request);
        if (cache.containsKey(key)) {
            return (Long) cache.get(key);
        }
        List<Long> longs = relexRepository.getContent(request.getFilepath());
        Long max = longs.stream().max(Long::compareTo).orElseThrow();
        cache.put(key, max);
        return max;
    }

    public Long getMin(Request request) {
        String key = getKeyByRequest(request);
        if (cache.containsKey(key)) {
            return (Long) cache.get(key);
        }
        List<Long> longs = relexRepository.getContent(request.getFilepath());
        Long min = longs.stream().min(Long::compareTo).orElseThrow();
        cache.put(key, min);
        return min;
    }

    public Long getMedian(Request request) {
        String key = getKeyByRequest(request);
        if (cache.containsKey(key)) {
            return (Long) cache.get(key);
        }
        List<Long> longs = relexRepository.getContent(request.getFilepath());
        Long median = longs.stream().sorted().toList().get(longs.size() / 2);
        cache.put(key, median);
        return median;
    }

    public Double getAvg(Request request) {
        String key = getKeyByRequest(request);
        if (cache.containsKey(key)) {
            return (Double) cache.get(key);
        }
        List<Long> longs = relexRepository.getContent(request.getFilepath());
        double avg = longs.stream().mapToDouble(e -> e).average().orElse(0);
        cache.put(key, avg);
        return avg;
    }

    @SuppressWarnings("unchecked")
    public List<List<Long>> getAsc(Request request) {
        String key = getKeyByRequest(request);
        if (cache.containsKey(key)) {
            return (List<List<Long>>) cache.get(key);
        }

        List<Long> longs = relexRepository.getContent(request.getFilepath());
        List<List<Long>> listArrayList = new ArrayList<>();
        List<Long> longList = new ArrayList<>();

        int cnt = 0;
        for (int i = cnt; i < longs.size() - 1; i++) {
            if (longs.get(i + 1) > longs.get(i)) {
                longList = new ArrayList<>(longList);
                if (!longList.contains(longs.get(i))) {
                    longList.add((long) Math.toIntExact(longs.get(i)));
                }
                longList.add((long) Math.toIntExact(longs.get(i + 1)));
            } else {
                longList = new ArrayList<>();
                cnt++;
            }
            if (!longList.isEmpty()) {
                listArrayList.add(longList);
            }
        }

        long l = listArrayList.stream().mapToLong(List::size).max().orElseThrow();
        List<List<Long>> lists = listArrayList.stream().filter(x -> x.size() == l).toList();
        cache.put(key, lists);
        return lists;
    }


    @SuppressWarnings("unchecked")
    public List<List<Long>> getDesc(Request request) {
        String key = getKeyByRequest(request);
        if (cache.containsKey(key)) {
            return (List<List<Long>>) cache.get(key);
        }
        List<Long> longs = relexRepository.getContent(request.getFilepath());
        List<List<Long>> listArrayList = new ArrayList<>();
        List<Long> longList = new ArrayList<>();

        int cnt = 0;
        for (int i = cnt; i < longs.size() - 1; i++) {
            if (longs.get(i + 1) < longs.get(i)) {
                longList = new ArrayList<>(longList);
                if (!longList.contains(longs.get(i))) {
                    longList.add(longs.get(i));
                }
                longList.add(longs.get(i + 1));
            } else {
                longList = new ArrayList<>();
                cnt++;
            }
            if (!longList.isEmpty()) {
                listArrayList.add(longList);
            }
        }

        long l = listArrayList.stream().mapToLong(List::size).max().orElseThrow();
        List<List<Long>> lists = listArrayList.stream().filter(x -> x.size() == l).toList();
        cache.put(key, lists);
        return lists;
    }

    private String getKeyByRequest(Request request) {
        String hash = getFileHash(request.getFilepath());
        return hash + "@" + request.getOperation();
    }

    private String getFileHash(String path) {
        try {
            byte[] b = Files.readAllBytes(Paths.get(path));
            byte[] hash = MessageDigest.getInstance("MD5").digest(b);
            return DatatypeConverter.printHexBinary(hash);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}