package io.github.com.entities.chat;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "forbidden_word")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForbiddenWord {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forbidden_word_id_seq")
	Integer id;

	@Column(name = "word")
	String word;
}
