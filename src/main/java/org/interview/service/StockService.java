package org.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.domain.StockModel;
import org.interview.domain.entity.Stock;
/**
 * (Stock)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
public interface StockService extends IService<Stock> {


    public Long updateStock(StockModel model);

    public Long getStock(Long id);
}

