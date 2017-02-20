
package com.example;

import org.springframework.http.MediaType;
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

    /**
     * Query Param practice
     */

    @GetMapping("/games")
    public String getIndividualParams(@RequestParam(value = "genre", defaultValue = "fantasy") String genre) {
        return String.format("Genre is : %s", genre);
    }

    @GetMapping("/cars")
    public String getCarsWithMappedParams(@RequestParam Map query) {
        StringBuilder sb = new StringBuilder("Results : ");
        query.forEach((k,v) -> sb.append(v + " "));

        return sb.toString().trim();
    }

    @GetMapping("/records")
    public String getRecordsWithDetails(RecordInfo recordInfo) {

        return String.format("Genre is %s. BPM is %s. Artist is %s",
                recordInfo.getGenre(),
                recordInfo.getBpm(),
                recordInfo.getArtist());
    }

    /**
     * PATH VARIABLE PRACTICE
     */

    @GetMapping("/hacker/{id}")
    public String getHackerById(@PathVariable String id) {
        return String.format("Hacker %s is Leroy Jenkins", id);
    }

    @GetMapping("/mission/{title}/comments/{commentId}")
    public String getCommentForMission(@PathVariable Map pathVariables) {
        StringBuilder sb = new StringBuilder("Results : ");
        pathVariables.forEach((k,v) -> sb.append(v + " "));

        return sb.toString().trim();
    }

    @GetMapping("/movie/{title}/comments/{commentId}")
    public String getCommentForMovie(Movie movie) {
        return String.format("The troll, Leeroy Jenkins, has posted comment %s on %s",
                movie.getCommentId(),
                movie.getTitle());
    }

    /**
     * Form Data Route
     */

    @PostMapping("/feedback")
    public String postFeedback(@RequestBody String body) {
        return body;
    }

    @PostMapping(value = "/detailedfeedback", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postDetailedFeedback(@RequestParam Map<String, String> body) {
        return body.toString();
    }

    @PostMapping(value = "/objectfeedback", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postDetailedFeedback(Feedback feedback) {

        return String.format("%s %s %s",
                feedback.getMessage(),
                feedback.getName(),
                feedback.getEmail());
    }
}
