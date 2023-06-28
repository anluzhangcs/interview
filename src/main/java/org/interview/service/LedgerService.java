package org.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.domain.LedgerModel;
import org.interview.domain.StockModel;
import org.interview.domain.entity.Ledger;
import org.interview.utils.ResponseResult;

/**
 * (Ledger)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
public interface LedgerService extends IService<Ledger> {

    ResponseResult outOrIn(StockModel model);

    ResponseResult queryLedger(LedgerModel model);

    ResponseResult countGood(Long id);
}

