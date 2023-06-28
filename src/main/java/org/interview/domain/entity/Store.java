package org.interview.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Store)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
@Data
@NoArgsConstructor
public class Store {
    //店标识
    private Long id;
    //店名
    private String name;


}

