package io.bigtreelab.rndbox.api.repository;

import io.bigtreelab.rndbox.api.domain.category.Category;
import io.bigtreelab.rndbox.api.dto.Category.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

//    List<Category> findAllByUseYn(String useYn);

    List<Category> findAll();
//    List<CategoryDto> findAllFetchJoinLoginDate();
}
