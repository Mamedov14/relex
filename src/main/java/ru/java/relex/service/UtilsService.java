package ru.java.relex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.java.relex.entity.Request;
import ru.java.relex.repository.RelexRepository;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UtilsService {

    private final RelexRepository relexRepository;
    private List<Long> longs = new ArrayList<>();

    public Object getResult(Request request) {
        longs = relexRepository.getContent(request.getFilepath());
        switch (request.getOperation()) {
            case "get_max_value" -> {
                return getMax();
            }
            case "get_min_value" -> {
                return getMin();
            }
            case "get_median_value" -> {
                return getMedian();
            }
            case "get_avg_value" -> {
                return getAvg();
            }
            case "get_asc_sequence" -> {
                return getAsc();
            }
            case "get_desc_sequence" -> {
                return getDesc();
            }
            default -> {
                return "not found operation";
            }
        }
    }

    public Long getMax() {
        return longs.stream().max(Long::compareTo).get();
    }

    public Long getMin() {
        return longs.stream().min(Long::compareTo).get();
    }

    public Long getMedian() {
        return longs.stream().sorted().toList().get(longs.size() / 2);
    }

    public Double getAvg() {
        return longs.stream().mapToDouble(e -> e).average().orElse(0);
    }

    public List<List<Long>> getAsc() {
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

        long l = listArrayList.stream().mapToLong(List::size).max().getAsLong();

        return listArrayList.stream().filter(x -> x.size() == l).toList();
    }


    public List<List<Long>> getDesc() {
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

        long l = listArrayList.stream().mapToLong(List::size).max().getAsLong();

        return listArrayList.stream().filter(x -> x.size() == l).toList();
    }
}