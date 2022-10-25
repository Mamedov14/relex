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
import ru.java.relex.entity.Result;
import ru.java.relex.service.UtilsService;

import java.util.Map;

@RestController
@Tag(name = "Relex")
@RequiredArgsConstructor
@RequestMapping(value = "/relex")
public class RelexController {
    private final UtilsService utilsService;

    @Operation(summary = "Get max value", responses = {
            @ApiResponse(description = "Max success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Result.class))),
            @ApiResponse(description = "Not found max", responseCode = "409")
    })
    @GetMapping(value = {"/get_max_value"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Long>> getMax(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("max_value", utilsService.getMax(request)));
    }

    @Operation(summary = "Get min value", responses = {
            @ApiResponse(description = "Min success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Result.class))),
            @ApiResponse(description = "Not found min", responseCode = "409")
    })
    @GetMapping(value = "/get_min_value", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Long>> getMin(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("min_value", utilsService.getMin(request)));
    }

    @Operation(summary = "Get median value", responses = {
            @ApiResponse(description = "Median success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Result.class))),
            @ApiResponse(description = "Not found median", responseCode = "409")
    })
    @GetMapping(value = "/get_median_value", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Long>> getMedian(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("median_value", utilsService.getMedian(request)));
    }

    @Operation(summary = "Get avg value", responses = {
            @ApiResponse(description = "Avg success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Result.class))),
            @ApiResponse(description = "Not found avg", responseCode = "409")
    })
    @GetMapping(value = "/get_avg_value", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Double>> getAvg(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("avg_value", utilsService.getAvg(request)));
    }

    @Operation(summary = "Get asc value", responses = {
            @ApiResponse(description = "Asc success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Result.class))),
            @ApiResponse(description = "Not found asc", responseCode = "409")
    })
    @GetMapping(value = "/get_asc_sequence", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Object>> getAsc(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("asc_sequence", utilsService.getAsc(request)));

    }

    @Operation(summary = "Get desc value", responses = {
            @ApiResponse(description = "Desc success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Result.class))),
            @ApiResponse(description = "Not found desc", responseCode = "409")
    })
    @GetMapping(value = "/get_desc_sequence", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Object>> getDesc(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of("desc_sequence", utilsService.getDesc(request)));
    }

    @Operation(summary = "Get operation value", responses = {
            @ApiResponse(description = "Operation success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Result.class))),
            @ApiResponse(description = "Not found operation", responseCode = "409")
    })
    @GetMapping(value = "/", produces = {"application/json", "application/xml"})
    public ResponseEntity<Map<String, Object>> getOperationResult(@RequestBody Request request) {
        return ResponseEntity.ok(Map.of(request.getOperation().substring(4), utilsService.getResult(request)));
    }
}