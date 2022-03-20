package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * いいねデータのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_LIK)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_LIK_COUNT,
            query = JpaConst.Q_LIK_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_LIK_COUNT_BY_EMPLOYEE,
            query = JpaConst.Q_LIK_COUNT_BY_EMPLOYEE_DEF)
})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Like {

    /**
     * id
     */
    @Id
    @Column(name = JpaConst.LIK_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 従業員id
     */
    @Column(name = JpaConst.LIK_COL_EMP, nullable = false)
    private String employeeId;

    /**
     * 日報id
     */
    @Column(name = JpaConst.LIK_COL_REP, nullable = false)
    private String reportId;

}