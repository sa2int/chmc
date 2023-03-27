package io.bigtreelab.rndbox.api.domain.category;

import io.bigtreelab.rndbox.api.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;
    @Column(name = "level", nullable = false)
    private int level;
    @Column(name = "apper_id", nullable = false)
    private int apperId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "gender_type", nullable = false)
    private String genderType;
    @Column(name = "use_yn", nullable = false)
    private String useYn;
}
