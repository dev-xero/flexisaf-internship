package io.github.dev.xero.springrestapi.character;

import io.github.dev.xero.springrestapi.common.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
@Tag(name = "Characters Endpoints")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    @Operation(summary = "Fetch All Characters", description = "Fetches all created characters")
    public ResponseEntity<ApiResult<List<CharacterEntity>>> all() {
        List<CharacterEntity> characters = characterService.findAll();
        return ResponseEntity.ok(ApiResult.success("Fetched all characters", characters));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Fetch Character By Id", description = "Fetches a single character by id")
    public ResponseEntity<ApiResult<CharacterEntity>> one(@PathVariable Long id) {
        CharacterEntity character = characterService.findById(id);
        return ResponseEntity.ok(ApiResult.success("Fetched character", character));
    }

    @GetMapping("/player/{playerId}")
    @Operation(summary = "Fetch Characters By Player Id", description = "Fetches all characters belonging to a specific player")
    public ResponseEntity<ApiResult<List<CharacterEntity>>> byPlayer(@PathVariable Long playerId) {
        List<CharacterEntity> characters = characterService.findByPlayerId(playerId);
        return ResponseEntity.ok(ApiResult.success("Fetched player characters", characters));
    }

    @PostMapping
    @Operation(summary = "Create a Character", description = "Creates a new character for a player")
    public ResponseEntity<ApiResult<CharacterEntity>> create(@RequestBody CharacterDto dto) {
        CharacterEntity character = characterService.create(dto);
        return ResponseEntity.ok(ApiResult.success("Character created successfully", character));
    }
}
