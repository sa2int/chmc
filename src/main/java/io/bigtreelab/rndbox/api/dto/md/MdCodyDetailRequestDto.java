package io.bigtreelab.rndbox.api.dto.md;

import io.bigtreelab.rndbox.api.domain.md.MdCody;
import io.bigtreelab.rndbox.api.domain.md.MdCodyDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MdCodyDetailRequestDto {

    private int mdCodyDetailId;
    private int mdCodyId;
    private int categoryId;
    private int colorId;

    public MdCodyDetail toEntity(int mdCodyId) {
        return MdCodyDetail.builder()
                .mdCodyId(mdCodyId)
                .categoryId(categoryId)
                .colorId(colorId)
                .build();
    }
}
