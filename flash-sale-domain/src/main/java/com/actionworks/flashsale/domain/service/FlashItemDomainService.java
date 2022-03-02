package com.actionworks.flashsale.domain.service;

import com.actionworks.flashsale.domain.model.entity.FlashItem;

public interface FlashItemDomainService {
    /**
     * 发布秒杀商品
     */
    void publishFlashItem(FlashItem flashItem);

    /**
     * 上线秒杀商品
     *
     * @param itemId 秒杀商品ID
     */
    void onlineFlashItem(Long itemId);

    /**
     * 下线秒杀商品
     *
     * @param itemId 秒杀商品ID
     */
    void offlineFlashItem(Long itemId);

    /**
     * 通过ID获取秒杀商品
     *
     * @param itemId 秒杀商品ID
     */
    FlashItem getById(Long itemId);
}
