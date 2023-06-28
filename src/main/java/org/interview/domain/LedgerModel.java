package org.interview.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Manny
 * @create 2023-06-28-17:03
 */
@Data
public class LedgerModel {

    private Long goodId;

    private LocalDateTime createTime;

    private long current;

    private long size;

}
