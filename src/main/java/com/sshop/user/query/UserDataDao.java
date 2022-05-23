package com.sshop.user.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserDataDao extends Repository<UserData, String> {

    UserData findById(String userId);

    Page<UserData> findByBlocked(boolean blocked, Pageable pageable);
    List<UserData> findByNameLike(String name, Pageable pageable);

    List<UserData> findAll(Specification<UserData> spec, Pageable pageable);

    List<UserData> findFirst3ByNameLikeOrderByName(String name);
    Optional<UserData> findFirstByNameLikeOrderByName(String name);
    UserData findFirstByBlockedOrderById(boolean blocked);
}
