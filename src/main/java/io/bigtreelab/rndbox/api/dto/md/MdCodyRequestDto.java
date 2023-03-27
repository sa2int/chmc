package io.bigtreelab.rndbox.api.dto.md;

import io.bigtreelab.rndbox.api.domain.md.Md;
import io.bigtreelab.rndbox.api.domain.md.MdCody;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MdCodyRequestDto {
    private int mdId;
    private String name;

    private List<MdCodyDetailRequestDto> mdCodyDetailList;

    public MdCody toEntity() {
        return MdCody.builder()
                .mdId(mdId)
                .name(name)
                .build();
    }
}
