package com.sshop.user.command.domain;

import com.sshop.common.model.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void save() {
		User user = new User(UserId.of("id1"), "이름2");
		user.changeEmails(Set.of(Email.of("mail1@mail.com"), Email.of("mail2@mail.com")));
		userRepository.save(user);

		var actual = userRepository.findById(UserId.of("id1")).get();
		assertThat(actual.getId()).isEqualTo(user.getId());
		assertThat(actual.getEmails().getEmails()).isEqualTo(user.getEmails().getEmails());
	}
}