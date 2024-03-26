package io.github.com.mappers;

import io.github.com.dto.auth.AuthenticationDataDTO;
import io.github.com.entities.staff.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthenticationDataDTOToAccount {
	AuthenticationDataDTOToAccount INSTANCE = Mappers.getMapper(AuthenticationDataDTOToAccount.class);
	Account map(AuthenticationDataDTO dto);
}
