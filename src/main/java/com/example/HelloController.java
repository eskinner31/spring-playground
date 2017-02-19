
package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @PatchMapping("/")
    public String patchRoute() { return "PUT to index route"; }

    @DeleteMapping("/")
    public String deleteRoute() { return "DELETE to index route"; }

    @GetMapping("/games")
    public String getIndividualParams(@RequestParam(value = "genre", defaultValue = "fantasy") String genre) {
        return String.format("Genre is : %s", genre);
    }

    @GetMapping("/cars")
    public String getCarsWithMappedParams(@RequestParam Map query) {
        return query.toString();
    }

    @GetMapping("/records")
    public String getRecordsWithDetails(RecordInfo recordInfo) {
        return recordInfo.getBpm();
    }

}
