package io.github.com.mappers.work;

import io.github.com.dto.work.JobDTO;
import io.github.com.entities.skills.Job;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListOfJobsToListOfJobsDTOMapper {
	ListOfJobsToListOfJobsDTOMapper INSTANCE = Mappers.getMapper(ListOfJobsToListOfJobsDTOMapper.class);
	List<JobDTO> map(List<Job> entities);
}
