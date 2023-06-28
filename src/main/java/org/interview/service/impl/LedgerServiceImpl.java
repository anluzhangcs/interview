package org.interview.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interview.domain.LedgerModel;
import org.interview.domain.StockModel;
import org.interview.domain.entity.Commodity;
import org.interview.domain.entity.Stock;
import org.interview.mapper.LedgerMapper;
import org.interview.domain.entity.Ledger;
import org.interview.mapper.StockMapper;
import org.interview.service.CommodityService;
import org.interview.service.LedgerService;
import org.interview.service.StockService;
import org.interview.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * (Ledger)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
@Service
public class LedgerServiceImpl extends ServiceImpl<LedgerMapper, Ledger> implements LedgerService {

    @Autowired
    private StockService stockService;

    @Autowired
    private CommodityService commodityService;

    /**
     * 出入库
     * @param model
     * @return
     */
    @Override
    public ResponseResult outOrIn(StockModel model) {
        Long storeId = model.getStoreId();
        Long goodId = model.getGoodId();
        Long size = model.getSize();
        Integer type = model.getType();

        save(new Ledger(null, goodId, storeId, LocalDateTime.now(), model.getType()));

        //修改库存
        Long stock = stockService.updateStock(model);

        return ResponseResult.ok(stock);
    }

    /**
     * 查询特定商品
     * @param id
     * @return
     */
    @Override
    public ResponseResult countGood(Long id) {
        //库存
        Long stock = stockService.getStock(id);

        //单价
        Double price = commodityService.getPriceById(id);

        Map<String, Object> map = new HashMap<>();
        map.put("stock", stock);
        map.put("totalPrice", stock * price);

        return ResponseResult.ok(map);
    }

    /**
     * 查询流水
     * @param model
     * @return
     */
    @Override
    public ResponseResult queryLedger(LedgerModel model) {
        long current = model.getCurrent();
        long size = model.getSize();
        Long goodId = model.getGoodId();
        LocalDateTime createTime = model.getCreateTime();

        IPage<Ledger> page = new Page<>(current, size);

        LambdaQueryWrapper<Ledger> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Ledger::getGoodId, goodId).eq(Ledger::getType, 1);
        wrapper.gt(Ledger::getCreateTime, createTime);

        page(page, wrapper);


        return ResponseResult.ok().setData(page);
    }
}

