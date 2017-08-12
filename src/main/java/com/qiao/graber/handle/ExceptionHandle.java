package com.qiao.graber.handle;

import com.qiao.graber.domain.Result;
import com.qiao.graber.exception.BaikeException;
import com.qiao.graber.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qiao
 * email tyrantqiao@icloud.com
 * 12:12
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = BaikeException.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof BaikeException) {
            BaikeException baikeException=(BaikeException) e;
            return ResultUtil.error(baikeException.getCode(),baikeException.getError());
        }else {
            return ResultUtil.error(-1,"unknown error");
        }
    }
}
