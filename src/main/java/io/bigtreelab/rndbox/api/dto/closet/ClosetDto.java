package io.bigtreelab.rndbox.api.dto.closet;


import io.bigtreelab.rndbox.api.domain.md.Md;
import io.bigtreelab.rndbox.api.domain.md.MdQueryDsl;
import io.bigtreelab.rndbox.api.domain.user.Closet;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ClosetDto {

    private int closetId;
    private int userNo;
    private int categoryId;
    private int colorId;
    private int categoryPId;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MdRequest {

        private int closetId;
        private int userNo;
        private int categoryId;
        private int colorId;
        private int categoryPId;

        public Closet toEntity() {
            return Closet.builder()
                    .closetId(closetId)
                    .userNo(userNo)
                    .categoryId(categoryId)
                    .colorId(colorId)
                    .categoryPId(categoryPId)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public class Response {
        private int closetId;
        private int userNo;
        private int categoryId;
        private int colorId;
        private int categoryPId;

        public Response(Closet entity) {
            this.closetId = entity.getClosetId();
            this.userNo = entity.getUserNo();
            this.categoryPId = entity.getCategoryPId();
            this.categoryId = entity.getCategoryId();
            this.colorId = entity.getColorId();
        }

    }


        public ClosetDto(Closet entity) {
            this.closetId = entity.getClosetId();
            this.userNo = entity.getUserNo();
            this.categoryPId = entity.getCategoryPId();
            this.categoryId = entity.getCategoryId();
            this.colorId = entity.getColorId();
        }



}
