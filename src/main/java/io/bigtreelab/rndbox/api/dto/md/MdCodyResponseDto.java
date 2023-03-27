package io.bigtreelab.rndbox.api.dto.md;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MdCodyResponseDto {
    private int mdId;
    private String name;
    private List<MdCodyDetailRequestDto> mdCodyDetailList;
}
