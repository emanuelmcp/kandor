package io.github.com.dto.chat;

import lombok.Data;

import java.io.Serializable;

@Data
public class ForbiddenWordDTO implements Serializable {
	String word;
}
