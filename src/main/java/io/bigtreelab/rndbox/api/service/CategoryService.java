package io.bigtreelab.rndbox.api.service;

import io.bigtreelab.rndbox.api.domain.category.Category;
import io.bigtreelab.rndbox.api.dto.Category.CategoryDto;
import io.bigtreelab.rndbox.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Transactional(readOnly = true)
    public List<CategoryDto.CategoryResponse> getCategoryList() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto.CategoryResponse::new)
                .collect(Collectors.toList());
    }

//    @Transactional(readOnly = true)
//    public List<CategoryDto> getCategoryList() {
//        return categoryRepository.findAllFetchJoinLoginDate();
//    }


}
