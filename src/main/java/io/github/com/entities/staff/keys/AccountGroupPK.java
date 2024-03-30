package io.github.com.entities.staff.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AccountGroupPK {
	@Column(name = "uuid")
	String uuid;

	@Column(name = "group_id")
	Integer groupId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AccountGroupPK that)) return false;
		return Objects.equals(getUuid(), that.getUuid()) && Objects.equals(getGroupId(), that.getGroupId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUuid(), getGroupId());
	}
}
