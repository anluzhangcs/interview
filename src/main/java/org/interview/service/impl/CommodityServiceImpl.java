package org.interview.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interview.domain.SearchModel;
import org.interview.mapper.CommodityMapper;
import org.interview.domain.entity.Commodity;
import org.interview.service.CommodityService;
import org.interview.utils.ResponseResult;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * (Commodity)
 *
 * @author manny
 * @since 2023-06-28 11:03:54
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {

    /**
     * 添加商品
     * @param commodity
     * @return
     */
    @Override
    public ResponseResult addCommodity(Commodity commodity) {

        save(commodity);

        return ResponseResult.ok().setMessage("添加成功");
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteCommodity(Long id) {
        removeById(id);
        return ResponseResult.ok().setMessage("删除成功");
    }

    /**
     * 更新商品
     * @param commodity
     * @return
     */
    @Override
    public ResponseResult editCommodity(Commodity commodity) {
        updateById(commodity);
        return ResponseResult.ok().setMessage("修改成功");
    }

    /**
     * 查询
     * @param model
     * @return
     */
    @Override
    public ResponseResult queryCommodity(SearchModel model) {
        String name = model.getName();
        long current = model.getCurrent();
        long size = model.getSize();

        IPage<Commodity> page = new Page<>(current, size);

        LambdaQueryWrapper<Commodity> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Commodity::getStoreTime);
        if (name != "" && Objects.nonNull(name)) {
            wrapper.like(Commodity::getName, name);
        }
        page(page, wrapper);


        return ResponseResult.ok().setData(page);
    }

}

