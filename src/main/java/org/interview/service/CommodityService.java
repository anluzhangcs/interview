package org.interview.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.interview.domain.SearchModel;
import org.interview.domain.entity.Commodity;
import org.interview.utils.ResponseResult;

/**
 * (Commodity)
 *
 * @author manny
 * @since 2023-06-28 11:03:54
 */
public interface CommodityService extends IService<Commodity> {

    ResponseResult addCommodity(Commodity commodity);

    ResponseResult deleteCommodity(Long id);

    ResponseResult editCommodity(Commodity commodity);

    ResponseResult queryCommodity(SearchModel model);

    Double getPriceById(Long id);
}

