package com.wtf.codewarehouse.util.rank.listrank;

import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/11/24 15:37
 */
@Data
public class Demo extends BaseRank {

    private String name;

    private Long score;


    @Override
    void setTFromU(Object o, Object from) {

    }
}
