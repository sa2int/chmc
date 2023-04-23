package io.bigtreelab.rndbox.api.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "closet")
public class Closet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "closet_id", nullable = false)
    private int closetId;
    @Column(name = "user_no", nullable = false)
    private int userNo;
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Column(name = "color_id", nullable = false)
    private int colorId;
    @Column(name = "category_p_id", nullable = false)
    private int categoryPId;

    @Builder
    public Closet(int closetId, int userNo, int categoryId, int colorId, int categoryPId) {
        this.closetId = closetId;
        this.userNo = userNo;
        this.categoryId = categoryId;
        this.colorId = colorId;
        this.categoryPId = categoryPId;
    }

}
