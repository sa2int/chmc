package io.bigtreelab.rndbox.api.dto.md;

import io.bigtreelab.rndbox.api.domain.md.MdQueryDsl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MdQueryDslDto {
    private String mdId;
    private String mdCategoryId;
    private String mdColorId;
    private String mdCodyName;
    private String mdCodyDetailCategoryId;
    private String mdCodyDetailColorId;

    public MdQueryDslDto(MdQueryDsl entity){
        this.mdId = entity.getMdId();
        this.mdCategoryId = entity.getMdCategoryId();
        this.mdColorId = entity.getMdColorId();
        this.mdCodyName = entity.getMdCodyName();
        this.mdCodyDetailCategoryId = entity.getMdCodyDetailCategoryId();
        this.mdCodyDetailColorId = entity.getMdCodyDetailColorId();
    }


}
