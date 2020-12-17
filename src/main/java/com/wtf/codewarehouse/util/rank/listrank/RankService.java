package com.wtf.codewarehouse.util.rank.listrank;

import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/11/24 15:11
 */
public interface RankService {

    /**
     * 填充集合排名
     * 使用前先排序，list.sort(Comparator.comparingDouble(Object::getT).reversed());
     * @param list
     * @return
     */
    List<? extends BaseRank> fillListRank(List<? extends BaseRank> list);

}
