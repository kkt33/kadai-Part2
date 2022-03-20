package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Like;

public class LikeConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param lv LikeViewのインスタンス
     * @return Likeのインスタンス
     */
    public static Like toModel(LikeView lv) {
        return new Like(
                lv.getId(),
                lv.getEmployeeId(),
                lv.getReportId());
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param l Likeのインスタンス
     * @return LikeViewのインスタンス
     */
    public static LikeView toView(Like l) {

        if (l == null) {
            return null;
        }

        return new LikeView(
                l.getId(),
                l.getEmployeeId(),
                l.getReportId());
    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<LikeView> toViewList(List<Like> list) {
        List<LikeView> lvs = new ArrayList<>();

        for (Like l : list) {
            lvs.add(toView(l));
        }

        return lvs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param l DTOモデル(コピー先)
     * @param lv Viewモデル(コピー元)
     */
    public static void copyViewToModel(Like l, LikeView lv) {
        l.setId(lv.getId());
        l.setEmployeeId(lv.getEmployeeId());
        l.setReportId(lv.getReportId());

    }

}
