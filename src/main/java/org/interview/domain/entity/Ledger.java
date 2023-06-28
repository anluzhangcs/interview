package org.interview.domain.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Ledger)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ledger {
    //台账id
    private Long id;
    //商品标识
    private Long goodId;
    //店标识
    private Long storeId;
    //流水时间
    private LocalDateTime createTime;
    //0-出库;1-入库
    private Integer type;


}

