package io.bigtreelab.rndbox.api.dto.md;

import io.bigtreelab.rndbox.api.domain.md.Md;
import io.bigtreelab.rndbox.api.domain.md.MdChoice;
import lombok.*;

public class MdChoiceDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MdChoiceRequest {

        private int mdChoiceId;
        private int categoryIdTop;
        private int colorIdTop;
        private int categoryIdPants;
        private int colorIdPants;
        private int categoryIdOuter;
        private int colorIdOuter;


        public MdChoice toEntity() {
            return MdChoice.builder()
                    .mdChoiceId(mdChoiceId)
                    .categoryIdTop(categoryIdTop)
                    .colorIdTop(colorIdTop)
                    .categoryIdPants(categoryIdPants)
                    .colorIdPants(colorIdPants)
                    .categoryIdOuter(categoryIdOuter)
                    .colorIdOuter(colorIdOuter)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class  Response {
        private int mdChoiceId;
        private int categoryIdTop;
        private int colorIdTop;
        private int categoryIdPants;
        private int colorIdPants;
        private int categoryIdOuter;
        private int colorIdOuter;

        public Response(MdChoice entity) {
            this.mdChoiceId = entity.getMdChoiceId();
            this.categoryIdTop = entity.getCategoryIdTop();
            this.colorIdTop = entity.getColorIdTop();
            this.categoryIdPants = entity.getCategoryIdPants();
            this.colorIdPants = entity.getColorIdPants();
            this.categoryIdOuter = entity.getCategoryIdOuter();
            this.colorIdOuter = entity.getColorIdOuter();
        }

    }

}
