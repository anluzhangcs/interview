package org.interview.controller;
import org.interview.domain.SearchModel;
import org.interview.domain.entity.Commodity;
import org.interview.service.CommodityService;
import org.interview.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * (Commodity)
 *
 * @author manny
 * @since 2023-06-28 11:03:54
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController{

    @Autowired
    private CommodityService commodityService;


    @PostMapping("/add")
    public ResponseResult addCommodity(@RequestBody Commodity commodity) {
        return commodityService.addCommodity(commodity);
    }

    @GetMapping("/delete")
    public ResponseResult deleteCommodity(@PathVariable Long id) {
        return commodityService.deleteCommodity(id);
    }

    @PutMapping("/edit")
    public ResponseResult editCommodity(@RequestBody Commodity commodity) {
        return commodityService.editCommodity(commodity);
    }


    @GetMapping("/list")
    public ResponseResult queryCommodity(@RequestBody SearchModel model) {
        return commodityService.queryCommodity(model);
    }

}

