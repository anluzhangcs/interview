package org.interview.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * (Commodity)
 *
 * @author manny
 * @since 2023-06-28 11:03:54
 */
@Data
@NoArgsConstructor
public class Commodity {
    //标识
    private Long id;
    //名称
    private String name;
    //规格
    private String specification;
    //单价
    private Double price;
    //入库时间
    private LocalDateTime storeTime;
    //逻辑删除(0-未删除;1-删除)
    private Integer delFlag;


}

