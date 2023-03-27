package io.bigtreelab.rndbox.api.domain.md;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "clothes_md_cody_detail")
public class MdCodyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "md_cody_detail_id", nullable = false)
    private int mdCodyDetailId;
    @Column(name = "md_cody_id", nullable = false)
    private int mdCodyId;
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Column(name = "color_id", nullable = false)
    private int colorId;

    @Builder
    public MdCodyDetail(int mdCodyDetailId, int mdCodyId, int categoryId, int colorId) {
        this.mdCodyDetailId = mdCodyDetailId;
        this.mdCodyId = mdCodyId;
        this.categoryId = categoryId;
        this.colorId = colorId;
    }
}
