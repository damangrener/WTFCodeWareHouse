package com.wtf.codewarehouse.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sangxinghai
 * @date 2020/7/7 19:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryConfig {
    private String categoryCodePrev;
    private String categoryNamePrev;
    private String categoryCode;
    private String categoryName;

    private String iconPath;
}
