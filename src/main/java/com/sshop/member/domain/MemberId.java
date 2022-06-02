package com.sshop.member.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Access(AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Embeddable
public class MemberId implements Serializable {
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "member_id")
	private Long id;

	public static MemberId of(Long id) {
		return new MemberId(id);
	}
}
