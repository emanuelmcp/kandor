package io.github.com.mappers.chat;

import io.github.com.dto.chat.ForbiddenWordDTO;
import io.github.com.entities.chat.ForbiddenWord;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ForbiddenWordDTOToForbiddenWordMapper {
	ForbiddenWordDTOToForbiddenWordMapper INSTANCE = Mappers.getMapper(ForbiddenWordDTOToForbiddenWordMapper.class);
	ForbiddenWord map(ForbiddenWordDTO dto);
}
