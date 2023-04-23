package io.bigtreelab.rndbox.api.domain.md;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "clothes_md_choice")
public class MdChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "md_choice_id", nullable = false)
    private int mdChoiceId;
    @Column(name = "category_id_top", nullable = false)
    private int categoryIdTop;
    @Column(name = "color_id_top", nullable = false)
    private int colorIdTop;
    @Column(name = "category_id_pants", nullable = false)
    private int categoryIdPants;
    @Column(name = "color_id_pants", nullable = false)
    private int colorIdPants;
    @Column(name = "category_id_outer", nullable = false)
    private int categoryIdOuter;
    @Column(name = "color_id_outer", nullable = false)
    private int colorIdOuter;

    @Builder
    public MdChoice(int mdChoiceId, int categoryIdTop, int colorIdTop,
    int categoryIdPants, int colorIdPants, int categoryIdOuter, int colorIdOuter
    ) {
        this.mdChoiceId = mdChoiceId;
        this.categoryIdTop = categoryIdTop;
        this.colorIdTop = colorIdTop;
        this.categoryIdPants = categoryIdPants;
        this.colorIdPants = colorIdPants;
        this.categoryIdOuter = categoryIdOuter;
        this.colorIdOuter = colorIdOuter;
    }

}
