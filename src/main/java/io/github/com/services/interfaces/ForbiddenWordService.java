package io.github.com.services.interfaces;

import io.github.com.dto.chat.ForbiddenWordDTO;
import io.github.com.dto.common.ApiResponseDTO;

import java.util.List;

public interface ForbiddenWordService {
	List<ForbiddenWordDTO> findAll();
	ApiResponseDTO addForbiddenWord(ForbiddenWordDTO dto);
	void deleteForbiddenWordById(Integer id);

	void deleteForbiddenWordByWord(String word);
}
