package com.sshop.cart.command.domain;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartNo> {
}
