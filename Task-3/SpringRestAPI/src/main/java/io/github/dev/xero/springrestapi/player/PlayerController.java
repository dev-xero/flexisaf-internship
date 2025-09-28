package io.github.dev.xero.springrestapi.player;

import io.github.dev.xero.springrestapi.common.ApiResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("players")
@Tag(name = "Players Endpoints")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    ResponseEntity<ApiResult<List<PlayerEntity>>> all() {
        List<PlayerEntity> players = playerService.findAll();
        return ResponseEntity.ok(ApiResult.success("Fetched all players", players));
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResult<PlayerEntity>> one(@PathVariable Long id) {
        PlayerEntity player = playerService.findById(id);
        return ResponseEntity.ok(ApiResult.success("Fetched player", player));
    }

    @PostMapping
    ResponseEntity<ApiResult<PlayerEntity>> register(@RequestBody PlayerDto dto) {
        PlayerEntity player = playerService.register(dto);
        return ResponseEntity.ok(ApiResult.success("Player registered", player));
    }
}
