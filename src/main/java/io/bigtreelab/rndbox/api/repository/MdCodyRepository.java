package io.bigtreelab.rndbox.api.repository;

import io.bigtreelab.rndbox.api.domain.md.Md;
import io.bigtreelab.rndbox.api.domain.md.MdCody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdCodyRepository extends JpaRepository<MdCody, Long> {
}
