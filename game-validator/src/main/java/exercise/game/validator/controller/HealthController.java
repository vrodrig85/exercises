package exercise.game.validator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @RequestMapping(value = "/game/validator/healthcheck",
            method = RequestMethod.GET)
    public ResponseEntity healthCheck(){
        return ResponseEntity.ok().build();
    }
}
