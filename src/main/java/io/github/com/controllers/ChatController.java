package io.github.com.controllers;

import io.github.com.dto.chat.ForbiddenWordDTO;
import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.services.interfaces.ForbiddenWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
	private final ForbiddenWordService forbiddenWordService;

	@Autowired
	public ChatController(ForbiddenWordService forbiddenWordService) {
		this.forbiddenWordService = forbiddenWordService;
	}

	@GetMapping
	public ResponseEntity<List<ForbiddenWordDTO>> findAllForbiddenWords() {
		return ResponseEntity.ok(forbiddenWordService.findAll());
	}

	@PostMapping
	public ResponseEntity<ApiResponseDTO> addForbiddenWord(@RequestBody ForbiddenWordDTO dto) {
		return ResponseEntity.ok(forbiddenWordService.addForbiddenWord(dto));
	}
	@DeleteMapping("/{id}")
	public void deleteForbiddenWordById(@PathVariable Integer id) {
		forbiddenWordService.deleteForbiddenWordById(id);
	}
	@DeleteMapping("/{word}/name")
	public void deleteForbiddenWordByName(@PathVariable String word) {
		forbiddenWordService.deleteForbiddenWordByWord(word);
	}
}
