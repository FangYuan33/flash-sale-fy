package com.actionworks.flashsale.nacos;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 存一些Nacos配置中需要动态变更的参数
 */
@Getter
@Component
@RefreshScope
public class NacosProperties {

    /**
     * 控制秒杀商品库存预热
     */
    @Value("${scheduler.warmUpFlag}")
    private Boolean warmUpFlag;
}