package com.pay.activetools.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.pay.activetools.bean.JsonResultView;
import com.pay.activetools.entity.ToolsPaymentMethod;
import com.pay.activetools.enums.CodeEnum;
import com.pay.activetools.service.ToolsPaymentMethodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 支付方式表 前端控制器
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
@Controller
@RequestMapping("/payType")
public class ToolsPaymentMethodController {
    private static Logger logger = LoggerFactory.getLogger(ToolsPaymentMethodController.class);

    @Autowired
    private ToolsPaymentMethodService toolsPaymentMethodService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject savePayType(ToolsPaymentMethod toolsPaymentMethod) {
        try {
            toolsPaymentMethodService.insertOrUpdatePayType(toolsPaymentMethod);
        } catch (Exception e) {
            logger.error("保存或修改支付方式异常:{}", e);
            return CodeEnum.FAIL.getJsonMsg();
        }
        return CodeEnum.SUCCESS.getJsonMsg();
    }


    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultView findPayType(ToolsPaymentMethod toolsPaymentMethod,
                                      @RequestParam(required = false, defaultValue = "1") Integer num,
                                      @RequestParam(required = false, defaultValue = "10") Integer size) {
        JsonResultView view = new JsonResultView();
        Page<ToolsPaymentMethod> page = new Page<>(num, size);
        try {
            page = toolsPaymentMethodService.findPayType(page,toolsPaymentMethod);
            view.setObject(page);
        } catch (Exception e) {
            logger.error("查询支付方式异常:{}",e);
            view.setCode(CodeEnum.FAIL.getCode());
            return view;
        }
        return view;
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    @ResponseBody
    public JsonResultView findPayTypeById(Long id){
        JsonResultView view = new JsonResultView();
        try {
            ToolsPaymentMethod toolsPaymentMethod = toolsPaymentMethodService.findPayTypeById(id);
            view.setObject(toolsPaymentMethod);
        } catch (Exception e) {
            logger.error("根据id:{}查询支付方式异常:{}",e);
            view.setCode(CodeEnum.FAIL.getCode());
            return view;
        }
        return view;
    }
}

