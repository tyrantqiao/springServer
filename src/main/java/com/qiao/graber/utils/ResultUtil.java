package com.qiao.graber.utils;

import com.qiao.graber.domain.Baike;
import com.qiao.graber.domain.Result;
import com.qiao.graber.exception.BaikeException;

/**
 * @author qiao
 * email tyrantqiao@icloud.com
 * 2017/8/813:35
 */

public class ResultUtil {
    public static Result<Baike> success(Baike baike) {
        Result<Baike> resultBaike = new Result<>();
        resultBaike.setCode(200);
        resultBaike.setMsg("succeed");
        resultBaike.setData(baike);
        return resultBaike;
    }

    public static Result<Baike> error(int code, String msg) {
        Result<Baike> resultBaike = new Result<>();
        resultBaike.setCode(code);
        resultBaike.setMsg(msg);
        resultBaike.setData(null);
        return resultBaike;
    }
}
