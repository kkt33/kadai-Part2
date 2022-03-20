package services;

import java.util.List;

import actions.views.LikeConverter;
import actions.views.LikeView;
import constants.JpaConst;
import models.Like;

/**
 * 日報テーブルの操作に関わる処理を行うクラス
 */
public class LikeService extends ServiceBase {

    /**
     * 日報からいいね件数を取得する
     * @param repId 日報ID
     * @return いいね件数
     */
    public long count(String repId) {
        long count = (long) em.createNamedQuery(JpaConst.Q_LIK_COUNT, Long.class)
                .setParameter(JpaConst.JPQL_PARM_REPORT_ID, repId)
                .getSingleResult();

        return count;
    }

    /**
     * 従業員IDと日報IDからいいねデータリストを取得する
     * @param empId 従業員ID
     * @param repId 日報ID
     * @return いいね件数
     */
    public List<LikeView> countByEmployee(String empId, String repId) {
        List<Like> likes = em.createNamedQuery(JpaConst.Q_LIK_COUNT_BY_EMPLOYEE, Like.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE_ID, empId)
                .setParameter(JpaConst.JPQL_PARM_REPORT_ID, repId)
                .getResultList();

        return LikeConverter.toViewList(likes);
    }

    /**
     * idを条件にデータを1件取得する
     * @param id
     * @return 取得データのインスタンス
     */
    private Like findOneInternal(int id) {
        return em.find(Like.class, id);
    }

    /**
     * いいねデータを1件登録する
     * @param l いいねデータ
     */
    public void create(LikeView lv) {
        em.getTransaction().begin();
        em.persist(LikeConverter.toModel(lv));
        em.getTransaction().commit();
    }

    /**
     * いいねデータを削除する
     * @param l いいねデータ
     */
    public void delete(LikeView lv) {
        em.getTransaction().begin();
        Like l = findOneInternal(lv.getId());
        em.remove(l);
        em.getTransaction().commit();

    }
}