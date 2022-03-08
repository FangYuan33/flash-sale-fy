package com.actionworks.flashsale.controller.model.exception;

import com.actionworks.flashsale.app.exception.BizException;
import com.actionworks.flashsale.app.model.result.AppResult;
import com.actionworks.flashsale.domain.exception.DomainException;
import com.actionworks.flashsale.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 处理业务异常
     */
    @ExceptionHandler(value = {BizException.class, DomainException.class, RepositoryException.class})
    public AppResult<Object> businessException(RuntimeException e) {
        log.error(e.getMessage(), e);

        return AppResult.error(e.getMessage());
    }

    @ExceptionHandler(value = {SQLException.class, NullPointerException.class, Exception.class})
    public AppResult<Object> sqlExceptionAndNPE(Exception e) {
        log.error(e.getMessage(), e);

        if (e instanceof SQLException) {
            return AppResult.error("数据库操作异常");
        }

        if (e instanceof NullPointerException) {
            return AppResult.error("空指针异常");
        }

        return AppResult.error(e.getMessage());
    }
}
