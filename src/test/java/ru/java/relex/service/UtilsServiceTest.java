package ru.java.relex.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.java.relex.entity.Request;
import ru.java.relex.repository.RelexRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class UtilsServiceTest {

    @MockBean
    private RelexRepository relexRepository;
    @Autowired
    private UtilsService utilsService;


    @Test
    void getMax() {
        List<Long> list = List.of(1L, 3L, 4L, 2L, 34L, 23L, 4L, 234L, 23L, 4L, 324L, 23L, 4234L, 234L, 24L);
        when(relexRepository
                .getContent("F:\\company\\internship_relex\\10m.txt"))
                .thenReturn(list);
        Long result = utilsService.getMax(new Request("F:\\company\\internship_relex\\10m.txt", "get_max_value"));
        assertEquals(result, 4234L);
    }

    @Test
    void getMin() {
        List<Long> list = List.of(1L, 3L, 4L, 2L, 34L, 23L, 4L, 234L, 23L, 4L, 324L, 23L, 4234L, 234L, 24L);
        when(relexRepository
                .getContent("F:\\company\\internship_relex\\10m.txt"))
                .thenReturn(list);
        Long result = utilsService.getMin(new Request("F:\\company\\internship_relex\\10m.txt", "get_max_value"));
        assertEquals(result, 1L);
    }

    @Test
    void getMedian() {
        List<Long> list = List.of(1L, 3L, 4L, 2L, 34L, 23L, 4L, 234L, 23L, 4L, 324L, 23L, 4234L, 234L, 24L);
        when(relexRepository
                .getContent("F:\\company\\internship_relex\\10m.txt"))
                .thenReturn(list);
        Long result = utilsService.getMedian(new Request("F:\\company\\internship_relex\\10m.txt", "get_max_value"));
        assertEquals(result, 23);
    }

    @Test
    void getAvg() {
        List<Long> list = List.of(1L, 3L, 4L, 2L, 34L, 23L, 4L, 234L, 23L, 4L, 324L, 23L, 4234L, 234L, 24L);
        when(relexRepository
                .getContent("F:\\company\\internship_relex\\10m.txt"))
                .thenReturn(list);
        Double result = utilsService.getAvg(new Request("F:\\company\\internship_relex\\10m.txt", "get_max_value"));
        assertEquals(result, 344.73333333333335);
    }

    @Test
    void getAsc() {

    }

    @Test
    void getDesc() {
    }
}