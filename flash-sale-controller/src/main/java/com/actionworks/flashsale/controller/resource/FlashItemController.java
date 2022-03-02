package com.actionworks.flashsale.controller.resource;

import com.actionworks.flashsale.app.model.command.FlashItemPublishCommand;
import com.actionworks.flashsale.app.model.result.AppResult;
import com.actionworks.flashsale.app.service.item.FlashItemAppService;
import com.actionworks.flashsale.controller.model.convertor.FlashItemConvertor;
import com.actionworks.flashsale.controller.model.convertor.ResponseConvertor;
import com.actionworks.flashsale.controller.model.request.FlashItemPublishRequest;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 秒杀品Controller
 *
 * @author fangyuan
 */
@RestController
public class FlashItemController {

    @Resource
    private FlashItemAppService flashItemAppService;

    /**
     * 发布秒杀商品
     *
     * @param activityId 秒杀活动ID
     */
    @PostMapping("/activities/{activityId}/flash-items")
    public <T> SingleResponse<T> publishFlashItem(@PathVariable Long activityId,
                                                  @RequestBody FlashItemPublishRequest request) {
        FlashItemPublishCommand command = FlashItemConvertor.toCommand(request);

        AppResult<T> appResult = flashItemAppService.publishFlashItem(activityId, command);

        return ResponseConvertor.with(appResult);
    }

    /**
     * 上线秒杀商品
     *
     * @param itemId 秒杀商品ID
     */
    @PutMapping(value = "/flash-items/{itemId}/online")
    public <T> SingleResponse<T> onlineFlashItem(@PathVariable Long itemId) {
        AppResult<T> appResult = flashItemAppService.onlineFlashItem(itemId);

        return ResponseConvertor.with(appResult);
    }
}