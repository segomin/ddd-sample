package com.sshop.project.domain;

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

@Access (AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Embeddable
public class ProjectId implements Serializable {
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long id;

	public static ProjectId of(Long id) {
		return new ProjectId(id);
	}
}
