package io.bigtreelab.rndbox.api.dto.Category;

import io.bigtreelab.rndbox.api.domain.category.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

public class CategoryDto {
//    private Long categoryId;
//    private int level;
//    private int apperId;
//    private String name;
//    private String genderType;
//    private String useYn;
//
//    public CategoryDto(
//            Long categoryId,
//            int level,
//            int apperId,
//            String name,
//            String genderType,
//            String useYn
//    ) {
//        this.categoryId = categoryId;
//        this.level = level;
//        this.apperId = apperId;
//        this.name = name;
//        this.genderType = genderType;
//        this.useYn = useYn;
//    }

    @Getter
    @AllArgsConstructor
    public static class CategoryResponse {
        private Long categoryId;
        private int level;
        private int apperId;
        private String name;
        private String genderType;
        private String useYn;

        public CategoryResponse(Category entity) {
            this.categoryId = entity.getCategoryId();
            this.level = entity.getLevel();
            this.apperId = entity.getApperId();
            this.name = entity.getName();
            this.genderType = entity.getGenderType();
            this.useYn = entity.getUseYn();
        }

//        public CategoryResponse(CategoryDto entity) {
//            this.categoryId = entity.getCategoryId();
//            this.level = entity.getLevel();
//            this.apperId = entity.getApperId();
//            this.name = entity.getName();
//            this.genderType = entity.getGenderType();
//            this.useYn = entity.getUseYn();
//        }


    }
}
