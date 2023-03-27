package io.bigtreelab.rndbox.api.dto.md;

import io.bigtreelab.rndbox.api.domain.md.Md;
import lombok.*;

import java.awt.*;

public class MdDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MdRequest {

        private int mdId;
        private int categoryId;
        private int colorId;

        public Md toEntity() {
            return Md.builder()
                    .categoryId(categoryId)
                    .colorId(colorId)
                    .build();
        }
    }


    @Getter
    @AllArgsConstructor
    public static class  MdResponse {
        private int mdId;
        private int categoryId;
        private int colorId;

            public MdResponse(Md entity) {
            this.mdId = entity.getMdId();
            this.categoryId = entity.getCategoryId();
            this.colorId = entity.getColorId();
        }
    }
}
