package io.github.com.services.management;

import io.github.com.dto.common.ApiResponseDTO;
import io.github.com.dto.management.BanDTO;
import io.github.com.dto.management.BannedDTO;
import io.github.com.dto.management.UnbanDTO;
import io.github.com.services.interfaces.BanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Service
public class BanServiceImpl implements BanService {

	private final RedisTemplate<String, String> redisTemplate;
	private static final String PREFIX = "banned:";

	@Autowired
	public BanServiceImpl(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public List<BannedDTO> findAll() {
		String[] keys = Objects.requireNonNull(redisTemplate.keys(PREFIX + "*")).toArray(new String[0]);
		return Stream.of(keys)
			.map(key -> BannedDTO
				.builder()
				.uuid(key.replace(PREFIX, ""))
				.reason(redisTemplate.opsForValue().get(key))
				.expires(redisTemplate.getExpire(key, TimeUnit.SECONDS))
				.build()
			)
			.toList();
	}

	@Override
	public BannedDTO isPlayerBanned(BannedDTO dto) {
		String key = PREFIX + dto.getUuid();
		String reason = redisTemplate.opsForValue().get(key);
		return BannedDTO
			.builder()
			.uuid(dto.getUuid())
			.reason(reason)
			.expires(redisTemplate.getExpire(key, TimeUnit.SECONDS))
			.build();
	}

	@Override
	public ApiResponseDTO banPlayer(BanDTO dto) {
		String uuid = dto.getUuid();
		if (dto.getExpires() == -1) redisTemplate.opsForValue().set(PREFIX + uuid, dto.getReason());
		else redisTemplate.opsForValue().set(PREFIX + uuid, dto.getReason(), dto.getExpires(), TimeUnit.SECONDS);
		return new ApiResponseDTO(
			dto.getUuid(),
			"Player " + uuid + " has been banned"
		);
	}

	@Override
	public ApiResponseDTO unbanPlayer(UnbanDTO dto) {
		String uuid = dto.getUuid();
		redisTemplate.delete(PREFIX + uuid);
		return new ApiResponseDTO(
			uuid,
			"Player " + uuid + " has been unbanned"
		);
	}
}
