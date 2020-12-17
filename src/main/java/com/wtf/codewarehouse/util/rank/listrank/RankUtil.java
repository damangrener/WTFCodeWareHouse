package com.wtf.codewarehouse.util.rank.listrank;

import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/11/24 15:20
 */
public class RankUtil implements RankService {


    @Override
    public List<? extends BaseRank> fillListRank(List<? extends BaseRank> list) {

        if (CollectionUtils.isEmpty(list)) {
            throw new RuntimeException();
        }

        int j = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list.get(i).setRank(j);
                j++;
            } else if (list.get(i).getT().equals(list.get(i - 1).getT())) {
                list.get(i).setRank(list.get(i - 1).getRank());
            } else {
                list.get(i).setRank(j);
                j++;
            }

        }

        return list;
    }
}
