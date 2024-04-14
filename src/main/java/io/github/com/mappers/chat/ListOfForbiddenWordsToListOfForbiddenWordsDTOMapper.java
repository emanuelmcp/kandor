package io.github.com.mappers.chat;

import io.github.com.dto.chat.ForbiddenWordDTO;
import io.github.com.entities.chat.ForbiddenWord;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListOfForbiddenWordsToListOfForbiddenWordsDTOMapper {
	ListOfForbiddenWordsToListOfForbiddenWordsDTOMapper INSTANCE = Mappers.getMapper(ListOfForbiddenWordsToListOfForbiddenWordsDTOMapper.class);
	List<ForbiddenWordDTO> map(List<ForbiddenWord> entities);
}
