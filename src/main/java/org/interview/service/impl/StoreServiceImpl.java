package org.interview.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interview.mapper.StoreMapper;
import org.interview.domain.entity.Store;
import org.interview.service.StoreService;
import org.springframework.stereotype.Service;

/**
 * (Store)
 *
 * @author manny
 * @since 2023-06-28 16:31:41
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

}

