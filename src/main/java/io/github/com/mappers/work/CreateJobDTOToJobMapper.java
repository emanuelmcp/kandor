package io.github.com.mappers.work;

import io.github.com.dto.work.CreateJobDTO;
import io.github.com.entities.skills.Job;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ActionDTOToActionMapper.class,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateJobDTOToJobMapper {
	CreateJobDTOToJobMapper INSTANCE = Mappers.getMapper(CreateJobDTOToJobMapper.class);
	Job map(CreateJobDTO dto);
}
