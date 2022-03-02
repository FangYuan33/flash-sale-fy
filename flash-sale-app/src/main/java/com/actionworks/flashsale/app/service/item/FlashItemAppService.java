package com.actionworks.flashsale.app.service.item;

import com.actionworks.flashsale.app.model.command.FlashItemPublishCommand;
import com.actionworks.flashsale.app.model.result.AppResult;

public interface FlashItemAppService {
    /**
     * 发布秒杀商品
     *
     * @param activityId 秒杀活动ID
     */
    <T> AppResult<T> publishFlashItem(Long activityId, FlashItemPublishCommand command);

    /**
     * 上线秒杀商品
     *
     * @param itemId 秒杀商品ID
     */
    <T> AppResult<T> onlineFlashItem(Long itemId);

    /**
     * 下线秒杀商品
     *
     * @param itemId 秒杀商品ID
     */
    <T> AppResult<T> offlineFlashItem(Long itemId);

    /**
     * 通过ID 获取单条秒杀商品信息
     *
     * @param itemId 秒杀商品ID
     */
    <T> AppResult<T> getById(Long itemId);
}
