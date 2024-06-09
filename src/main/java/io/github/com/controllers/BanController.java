package io.github.com.controllers;


import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.management.BanDTO;
import io.github.com.dto.management.BannedDTO;
import io.github.com.dto.management.UnbanDTO;
import io.github.com.services.interfaces.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management")
public class BanController {
	private final BanService banService;

	@Autowired
	public BanController(BanService banService) {
		this.banService = banService;
	}

	@GetMapping
	public ResponseEntity<List<BannedDTO>> getBannedPlayers() {
		return ResponseEntity.ok(banService.findAll());
	}

	@GetMapping("/is-banned")
	public ResponseEntity<BannedDTO> isPlayerBanned(@RequestBody BannedDTO uuid) {
		return ResponseEntity.ok(banService.isPlayerBanned(uuid));
	}

	@PostMapping("/ban")
	public ResponseEntity<ApiResponseDTO> banPlayer(@RequestBody BanDTO dto) {
		return ResponseEntity.ok(banService.banPlayer(dto));
	}

	@PostMapping("/unban")
	public ResponseEntity<ApiResponseDTO> unbanPlayer(@RequestBody UnbanDTO dto) {
		return ResponseEntity.ok(banService.unbanPlayer(dto));
	}
}
