package io.bigtreelab.rndbox.api.repository;

import io.bigtreelab.rndbox.api.domain.md.Md;
import io.bigtreelab.rndbox.api.domain.md.MdQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public interface MdRepository extends JpaRepository<Md, Long> {
    @Query(nativeQuery = true, value = "SELECT a.md_id AS mdId, a.category_id AS mdCategoryId, " +
            " a.color_id AS mdColorId, b.name AS mdCodyName, "+
            " c.category_id AS mdCodyDetailCategoryId, c.color_id AS mdCodyDetailColorId "+
            " FROM clothes_md a INNER JOIN clothes_md_cody b ON a.md_id = b.md_id " +
            "INNER JOIN clothes_md_cody_detail c ON b.md_cody_id = c.md_cody_id")
    List<MdQueryDsl> findAllMdQueryDslInterfaceWithNative();

}
