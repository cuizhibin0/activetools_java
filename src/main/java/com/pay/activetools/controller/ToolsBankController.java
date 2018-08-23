package com.pay.activetools.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.pay.activetools.bean.JsonResultView;
import com.pay.activetools.entity.ToolsBank;
import com.pay.activetools.enums.CodeEnum;
import com.pay.activetools.service.ToolsBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 工具银行表 前端控制器
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
@Controller
@RequestMapping("/toolsBank")
public class ToolsBankController {
    private static Logger logger = LoggerFactory.getLogger(ToolsBankController.class);

    @Autowired
    private ToolsBankService toolsBankService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject saveToolsBank(ToolsBank toolsBank) {
        try {
            toolsBankService.insert(toolsBank);
        } catch (Exception e) {
            logger.error("保存:{}异常:{}", e);
            return CodeEnum.FAIL.getJsonMsg();
        }
        return CodeEnum.SUCCESS.getJsonMsg();

    }

    public JsonResultView findToolsBank(ToolsBank toolsBank, @RequestParam(value = "num", defaultValue = "1") Integer num,
                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        JsonResultView view = new JsonResultView();
        Page<ToolsBank> page = new Page<ToolsBank>(num,size);
        Page<ToolsBank> toolsBankPage = toolsBankService.selectPage(page);

        return view;

    }

}

