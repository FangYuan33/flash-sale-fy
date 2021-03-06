CREATE database `flash_sale`;

-- 初始化秒杀活动表
CREATE TABLE IF NOT EXISTS flash_sale.`flash_activity` (
    `id`            bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `activity_name` varchar(30) NOT NULL COMMENT '秒杀活动名称',
    `activity_desc` text COMMENT '秒杀活动描述',
    `start_time`    datetime    NOT NULL COMMENT '秒杀活动开始时间',
    `end_time`      datetime    NOT NULL COMMENT '秒杀活动结束时间',
    `status`        tinyint(2)  DEFAULT NULL COMMENT '秒杀活动状态 10-已发布 20-已上线 30-已下线',
    `modified_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '秒杀活动表';

-- 初始化秒杀商品表
CREATE TABLE IF NOT EXISTS flash_sale.`flash_item` (
    `id`              bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '秒杀品ID',
    `activity_id`     bigint(20)  NOT NULL COMMENT '所属活动id',
    `item_title`      varchar(50) NOT NULL COMMENT '秒杀品名称标题',
    `item_sub_title`  varchar(50) DEFAULT NULL COMMENT '秒杀品副标题',
    `item_desc`       text COMMENT '秒杀品介绍富文本文案',
    `initial_stock`   int(11)     NOT NULL DEFAULT '0' COMMENT '秒杀品初始库存',
    `available_stock` int(11)     NOT NULL DEFAULT '0' COMMENT '秒杀品可用库存',
    `original_price`  bigint(20)  NOT NULL COMMENT '秒杀品原价',
    `flash_price`     bigint(20)  NOT NULL COMMENT '秒杀价',
    `start_time`      datetime    NOT NULL COMMENT '秒杀开始时间',
    `end_time`        datetime    NOT NULL COMMENT '秒杀结束时间',
    `status`          tinyint(2)  NOT NULL COMMENT '秒杀品状态 10-已发布 20-已上线 30-已下线',
    `modified_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_time`     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '秒杀品';

-- 初始化秒杀订单表
CREATE TABLE IF NOT EXISTS flash_sale.`flash_order` (
    `id`            bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '秒杀订单ID',
    `item_id`       bigint(20)  NOT NULL COMMENT '秒杀品ID',
    `activity_id`   bigint(20)  NOT NULL COMMENT '秒杀活动ID',
    `user_id`       bigint(20)  NOT NULL COMMENT '用户ID',
    `item_title`    varchar(50) NOT NULL COMMENT '秒杀品名称',
    `flash_price`   bigint(20)  NOT NULL COMMENT '秒杀价',
    `quantity`      int(11)     NOT NULL COMMENT '数量',
    `total_amount`  bigint(20)  NOT NULL COMMENT '总价格',
    `status`        tinyint(2)  NOT NULL COMMENT '订单状态 10-已创建 20-已取消',
    `modified_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `flash_order_user_id_idx` (`user_id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '秒杀订单表';

-- 新增秒杀商品预热情况字段
alter table `flash_item` add column `warm_up` tinyint(1) default 0 comment '库存预热情况 0-未预热 1-已预热' after activity_id;