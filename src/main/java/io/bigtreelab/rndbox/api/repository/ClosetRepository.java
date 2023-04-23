package io.bigtreelab.rndbox.api.repository;

import io.bigtreelab.rndbox.api.domain.md.MdQueryDsl;
import io.bigtreelab.rndbox.api.domain.user.Closet;
import io.bigtreelab.rndbox.api.domain.user.ClosetQueryDsl;
import io.bigtreelab.rndbox.api.dto.closet.ClosetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClosetRepository extends JpaRepository<Closet, Long> {

    @Query(nativeQuery = true, value = "SELECT closet_id, user_no, category_id, color_id , category_p_id FROM fasion.closet where closet_id in (:closetId) order by category_p_id ASC")
    List<Closet> findAllClosetQueryDslInterfaceWithNative(@Param("closetId") String[] closestId);


}
