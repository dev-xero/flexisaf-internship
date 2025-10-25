package github.dev.xero.pokemonrest.controllers;

import github.dev.xero.pokemonrest.dto.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokemonRestController {

    @GetMapping("/")
    public ResponseEntity<HttpResponse<String>> get() {
        return ResponseEntity.ok(
                HttpResponse.Ok("Pokemon API v1", "/", null)
        );
    }

}
