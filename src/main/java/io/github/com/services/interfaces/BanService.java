package io.github.com.services.interfaces;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.management.BanDTO;
import io.github.com.dto.management.BannedDTO;
import io.github.com.dto.management.UnbanDTO;

import java.util.List;

public interface BanService {
	List<BannedDTO> findAll();
	BannedDTO isPlayerBanned(BannedDTO uuid);
	ApiResponseDTO banPlayer(BanDTO dto);
	ApiResponseDTO unbanPlayer(UnbanDTO dto);
}
