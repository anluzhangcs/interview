package org.interview.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interview.domain.StockModel;
import org.interview.mapper.StockMapper;
import org.interview.domain.entity.Stock;
import org.interview.service.StockService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * (Stock)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    /**
     * 更新库存
     * @param model
     * @return
     */
    @Override
    public Long updateStock(StockModel model) {

        Long storeId = model.getStoreId();
        Long goodId = model.getGoodId();
        Long size = model.getSize();
        Integer type = model.getType();

        LambdaQueryWrapper<Stock> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Stock::getGoodId, goodId).eq(Stock::getStoreId, storeId);
        Stock stock = getOne(queryWrapper);
        Long preNum = stock.getGoodNum();
        if (type == 0) { //出库
            if (preNum > size) {
                stock.setGoodNum(preNum-size);
                save(stock);
            }
        } else{ //入库
            stock.setGoodNum(preNum + size);
            save(stock);
        }


        return stock.getGoodNum();
    }

    /**
     * 根据商品id返回库存
     * @param id
     * @return
     */
    @Override
    public Long getStock(Long id) {
        LambdaQueryWrapper<Stock> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Stock::getGoodId, id);
        List<Stock> list = list(queryWrapper);
        Long sum = list.stream().collect(Collectors.summingLong(Stock::getGoodNum));

        return sum;
    }
}

