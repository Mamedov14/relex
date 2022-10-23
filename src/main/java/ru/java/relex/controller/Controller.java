package ru.java.relex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.java.relex.entity.Request;
import ru.java.relex.entity.Response;
import ru.java.relex.servise.UtilsService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/relex")
public class Controller {
    private final UtilsService utilsService;

    @GetMapping(value = {"default", "/{operation}"}, produces = {"application/json", "application/xml"})
    public Response getOperation(@RequestBody Request request, @PathVariable(required = false) String operation) {
        if (operation != null) {
            switch (operation) {
                case "get_max_value" -> {
                    return new Response(operation, utilsService.getMax(request.getFilepath()).toString());
                }
                case "get_min_value" -> {
                    return new Response(operation, utilsService.getMin(request.getFilepath()).toString());
                }
                case "get_median_value" -> {
                    return new Response(operation, utilsService.getMedian(request.getFilepath()).toString());
                }
                case "get_avg_value" -> {
                    return new Response(operation, utilsService.getAvg(request.getFilepath()).toString());
                }
                case "get_asc_sequence" -> {
                    return new Response(operation, utilsService.getAsc(request.getFilepath()).toString());
                }
                case "get_desc_sequence" -> {
                    return new Response(operation, utilsService.getDesc(request.getFilepath()).toString());
                }
                default -> new Response("no such operation", null);
            }
        } else {
            switch (request.getOperation()) {
                case "get_max_value" -> {
                    return new Response(request.getOperation(), utilsService.getMax(request.getFilepath()).toString());
                }
                case "get_min_value" -> {
                    return new Response(request.getOperation(), utilsService.getMin(request.getFilepath()).toString());
                }
                case "get_median_value" -> {
                    return new Response(request.getOperation(), utilsService.getMedian(request.getFilepath()).toString());
                }
                case "get_avg_value" -> {
                    return new Response(request.getOperation(), utilsService.getAvg(request.getFilepath()).toString());
                }
                case "get_asc_sequence" -> {
                    return new Response(request.getOperation(), utilsService.getAsc(request.getFilepath()).toString());
                }
                case "get_desc_sequence" -> {
                    return new Response(request.getOperation(), utilsService.getDesc(request.getFilepath()).toString());
                }
                default -> new Response("no such operation", null);
            }
        }
        return new Response("no such operation", null);
    }

/*
    @GetMapping(value = {"/get_min_value"}, produces = {"application/json", "application/xml"})
    public Response getMin(@RequestBody Request request*//*, @PathVariable String operation*//*) {
        return new Response(mainService.getMin(request.getFilepath()).toString());
    }

    @GetMapping(value = {"/get_median_value"}, produces = {"application/json", "application/xml"})
    public Response getMedian(@RequestBody Request request*//*, @PathVariable String operation*//*) {
        return new Response(mainService.getMedian(request.getFilepath()).toString());
    }

    @GetMapping(value = {"/get_avg_value"}, produces = {"application/json", "application/xml"})
    public Response getAvg(@RequestBody Request request*//*, @PathVariable String operation*//*) {
        return new Response(mainService.getAvg(request.getFilepath()).toString());
    }*/

}