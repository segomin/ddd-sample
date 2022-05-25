package com.sshop.cart.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
public class CartId implements Serializable {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    public static CartId of(Long id) {
        return new CartId(id);
    }
}
