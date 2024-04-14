package io.github.com.services;

import io.github.com.dto.chat.ForbiddenWordDTO;
import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.entities.chat.ForbiddenWord;
import io.github.com.exceptions.EntityAlreadyExistsException;
import io.github.com.mappers.chat.ForbiddenWordDTOToForbiddenWordMapper;
import io.github.com.mappers.chat.ListOfForbiddenWordsToListOfForbiddenWordsDTOMapper;
import io.github.com.repositories.chat.ForbiddenWordRepository;
import io.github.com.services.interfaces.ForbiddenWordService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForbiddenWordServiceImpl implements ForbiddenWordService {
	private final ForbiddenWordRepository forbiddenWordRepository;
	private final ForbiddenWordDTOToForbiddenWordMapper forbiddenWordDTOToForbiddenWordMapper;
	private final ListOfForbiddenWordsToListOfForbiddenWordsDTOMapper listOfForbiddenWordsToListOfForbiddenWordsDTOMapper;

	public ForbiddenWordServiceImpl(
		ForbiddenWordRepository forbiddenWordRepository,
		ForbiddenWordDTOToForbiddenWordMapper forbiddenWordDTOToForbiddenWordMapper,
		ListOfForbiddenWordsToListOfForbiddenWordsDTOMapper listOfForbiddenWordsToListOfForbiddenWordsDTOMapper
	) {
		this.forbiddenWordRepository = forbiddenWordRepository;
		this.forbiddenWordDTOToForbiddenWordMapper = forbiddenWordDTOToForbiddenWordMapper;
		this.listOfForbiddenWordsToListOfForbiddenWordsDTOMapper = listOfForbiddenWordsToListOfForbiddenWordsDTOMapper;
	}

	@Override
	public List<ForbiddenWordDTO> findAll() {
		List<ForbiddenWord> words = forbiddenWordRepository.findAll();
		return listOfForbiddenWordsToListOfForbiddenWordsDTOMapper.map(words);
	}

	@Override
	public ApiResponseDTO addForbiddenWord(@NotNull ForbiddenWordDTO dto) {
		forbiddenWordRepository.findByWord(dto.getWord()).ifPresent(existingGroup -> {
			throw new EntityAlreadyExistsException("Esta palabra ya esta prohibida");
		});
		ForbiddenWord mappedForbiddenWord = forbiddenWordDTOToForbiddenWordMapper.map(dto);
		ForbiddenWord savedForbiddenWord = forbiddenWordRepository.save(mappedForbiddenWord);
		return new ApiResponseDTO(
			savedForbiddenWord.getId().toString(),
			"La palabra " + savedForbiddenWord.getWord() + " ha sido prohibida"
		);
	}

	@Override
	public void deleteForbiddenWordById(Integer id) {
		forbiddenWordRepository.deleteById(id);
	}

	@Override
	public void deleteForbiddenWordByWord(String word) {
		forbiddenWordRepository.deleteByWord(word);

	}
}
