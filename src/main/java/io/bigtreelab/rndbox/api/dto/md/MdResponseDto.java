package io.bigtreelab.rndbox.api.dto.md;

import io.bigtreelab.rndbox.api.domain.md.MdCody;
import io.bigtreelab.rndbox.api.domain.md.MdCodyDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class MdResponseDto {
    private MdCody mdCody;
    private List<MdCodyDetail> mdCodyDetailList;

    public MdResponseDto(MdCody mdCody, List<MdCodyDetail> mdCodyDetailList) {
        this.mdCody = mdCody;
        this.mdCodyDetailList = mdCodyDetailList;
    }
}
