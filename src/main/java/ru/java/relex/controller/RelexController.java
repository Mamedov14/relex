package ru.java.relex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.java.relex.entity.Request;
import ru.java.relex.service.UtilsService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/relex")
public class RelexController {
    private final UtilsService utilsService;

    @GetMapping("/{operation}")
    public ResponseEntity<Map<String, Object>> getOperation(@RequestBody Request request, @PathVariable String operation) {
        request.setOperation(operation);
        Map<String, Object> map = new HashMap<>();
        map.put(request.getOperation().substring(4), utilsService.getResult(request));
        return ResponseEntity.ok(map);
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getO(@RequestBody Request request) {
        Map<String, Object> map = new HashMap<>();
        map.put(request.getOperation().substring(4), utilsService.getResult(request));
        return ResponseEntity.ok(map);
    }
}