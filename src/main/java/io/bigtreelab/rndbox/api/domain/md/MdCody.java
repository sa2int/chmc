package io.bigtreelab.rndbox.api.domain.md;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "clothes_md_cody")
public class MdCody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "md_cody_id", nullable = false)
    private int mdCodyId;
    @Column(name = "md_id", nullable = false)
    private int mdId;
    @Column(name = "name", nullable = false)
    private String name;

    @Builder
    public MdCody(int mdCodyId, int mdId, String name) {
        this.mdCodyId = mdCodyId;
        this.mdId = mdId;
        this.name = name;
    }
}
