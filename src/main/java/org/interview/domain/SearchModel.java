package org.interview.domain;

import lombok.Data;

/**
 * 查询条件
 * @author Manny
 * @create 2023-06-28-15:29
 */

@Data
public class SearchModel {

    private String name;

    private long current;

    private long size;

}
