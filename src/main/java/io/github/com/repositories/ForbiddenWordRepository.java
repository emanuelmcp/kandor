package io.github.com.repositories;

import io.github.com.entities.chat.ForbiddenWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForbiddenWordRepository extends JpaRepository<ForbiddenWord, Integer> {
	Optional<ForbiddenWord> findByWord(String word);
	void deleteByWord(String word);
}
