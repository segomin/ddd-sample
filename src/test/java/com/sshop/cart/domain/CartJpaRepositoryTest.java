package com.sshop.cart.domain;

import com.sshop.cart.adapter.out.CartJpaRepository;
import com.sshop.member.domain.MemberId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

//@AutoConfigureTestDatabase (connection = H2)
@SpringBootTest
//@DataJpaTest
class CartJpaRepositoryTest {

	@Autowired
	CartJpaRepository cartJpaRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void testFindCart() {
		jdbcTemplate.update("""
		insert into cart values (?, ?, ?, ?, ?, ?, ?)
""", 10L, 20L, 30L, 1000, "some name", "some field", "some json");

		var carts = cartJpaRepository.findByMemberId(MemberId.of(20L));

		Assertions.assertEquals(carts.size(), 1);
	}
}