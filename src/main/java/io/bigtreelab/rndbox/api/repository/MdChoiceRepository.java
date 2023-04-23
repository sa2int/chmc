package io.bigtreelab.rndbox.api.repository;

import io.bigtreelab.rndbox.api.domain.md.Md;
import io.bigtreelab.rndbox.api.domain.md.MdChoice;
import io.bigtreelab.rndbox.api.domain.md.MdQueryDsl;
import io.bigtreelab.rndbox.api.dto.md.MdChoiceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MdChoiceRepository extends JpaRepository<MdChoice, Long> {
    MdChoiceDto.Response findByCategoryIdTopAndColorIdTopAndCategoryIdPantsAndColorIdPants(int categoryIdTop,int colorIdTop,int categoryIdPants,int colorIdPants);
    MdChoiceDto.Response findByCategoryIdTopAndColorIdTopAndCategoryIdPantsAndColorIdPantsAndCategoryIdOuterAndColorIdOuter(int categoryIdTop,int colorIdTop,int categoryIdPants,int colorIdPants,int categoryIdOuter,int colorIdOuter);

}
