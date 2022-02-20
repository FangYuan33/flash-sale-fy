# 方圆整理的高并发秒杀系统

## 1. 介绍
高并发秒杀系统实战项目，记录每一分成长

## 2. 软件架构

- flash-sale-domain: 领域层，包含实体类
- flash-sale-infrastructure: 基础设施层，包含mapper文件
- flash-sale-app: 应用层，包含service服务
- flash-sale-controller: controller层
- environment-mysql: 保存数据库脚本

## 3. 分支说明

### 3.1 base-framework
- 想在这个分支搭建一个基础框架，什么项目代码都没有，能从这个分支上从0到1的开发

### 3.2 base-function
- 基础功能开发，包括秒杀活动的操作和秒杀品操作