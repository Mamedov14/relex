package ru.java.relex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.java.relex.entity.Request;
import ru.java.relex.service.UtilsService;

import java.util.Map;

@RestController
@Tag(name = "Relex")
@RequiredArgsConstructor
@RequestMapping(value = "/relex")
public class RelexController {
    private final UtilsService utilsService;

    @Operation(summary = "Get max value", responses = {
            @ApiResponse(description = "Get max success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Map.class))),
            @ApiResponse(description = "Not Found Max", responseCode = "409")
    })
    @GetMapping(value = {"/get_max_value"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Long>> getMax(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("max_value", utilsService.getMax(request)));
    }

    @GetMapping(value = "/get_min_value", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Long>> getMin(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("min_value", utilsService.getMin(request)));
    }


    @GetMapping(value = "/get_median_value", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Long>> getMedian(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("median_value", utilsService.getMedian(request)));
    }

    @GetMapping(value = "/get_avg_value", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Double>> getAvg(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("avg_value", utilsService.getAvg(request)));
    }

    @GetMapping(value = "/get_asc_sequence", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Object>> getAsc(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("asc_sequence", utilsService.getAsc(request)));

    }

    @GetMapping(value = "/get_desc_sequence", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Object>> getDesc(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("desc_sequence", utilsService.getDesc(request)));
    }

    @GetMapping(value = "/", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Object>> getOperationResult(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of(request.getOperation().substring(4), utilsService.getResult(request)));
    }
}