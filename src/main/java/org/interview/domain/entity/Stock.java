package org.interview.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Stock)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
@Data
@NoArgsConstructor
public class Stock {
    //店id
    private Long storeId;
    //商品id
    private Long goodId;
    //商品库存
    private Long goodNum;


}

