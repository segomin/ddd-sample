package com.sshop.asset.command.domain.category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findById(CategoryNo id);

    List<Category> findAll();
}
