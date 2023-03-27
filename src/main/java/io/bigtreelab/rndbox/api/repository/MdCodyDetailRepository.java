package io.bigtreelab.rndbox.api.repository;

import io.bigtreelab.rndbox.api.domain.md.Md;
import io.bigtreelab.rndbox.api.domain.md.MdCodyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdCodyDetailRepository extends JpaRepository<MdCodyDetail, Long> {
}
