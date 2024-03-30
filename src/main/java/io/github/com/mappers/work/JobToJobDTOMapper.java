package io.github.com.mappers.work;

import io.github.com.dto.work.JobDTO;
import io.github.com.entities.skills.Job;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobToJobDTOMapper {
	JobToJobDTOMapper INSTANCE = Mappers.getMapper(JobToJobDTOMapper.class);
	JobDTO map(Job entity);
}
