package io.github.com.mappers.work;

import io.github.com.dto.work.JobDTO;
import io.github.com.entities.skills.Job;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateJobDTOToJobMapper {
	UpdateJobDTOToJobMapper INSTANCE = Mappers.getMapper(UpdateJobDTOToJobMapper.class);
	void map(JobDTO dto, @MappingTarget Job entity);
}
