package com.sshop.user.query;

import org.springframework.data.jpa.domain.Specification;

public class UserDataSpecs {

    public static Specification<UserData> nonBlocked() {
        return (root, query, cb) -> cb.equal(root.<Boolean>get("blocked"), false);
    }

    public static Specification<UserData> nameLike(String keyword) {
        return (root, query, cb) -> cb.like(root.<String>get("name"), keyword + "%");
    }
}
