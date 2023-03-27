package io.bigtreelab.rndbox.api.domain.md;

import io.bigtreelab.rndbox.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "clothes_md")
public class Md extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "md_id", nullable = false)
    private int mdId;
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Column(name = "color_id", nullable = false)
    private int colorId;

    @Builder
    public Md(int mdId, int categoryId, int colorId) {
        this.mdId = mdId;
        this.categoryId = categoryId;
        this.colorId = colorId;
    }

}

