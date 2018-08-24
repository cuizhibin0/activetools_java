package com.pay.activetools.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.pay.activetools.bean.JsonResultView;
import com.pay.activetools.entity.ToolsBank;
import com.pay.activetools.enums.CodeEnum;
import com.pay.activetools.service.ToolsBankService;
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
        logger.info("保存银行参数:{}",toolsBank);
        try {
            toolsBankService.insertOrUpdateToolsBank(toolsBank);
        } catch (Exception e) {
            logger.error("保存:{}异常:{}", e);
            return CodeEnum.FAIL.getJsonMsg();
        }
        return CodeEnum.SUCCESS.getJsonMsg();
    }

    @RequestMapping( value = "/find",method = RequestMethod.POST)
    @ResponseBody
    public JsonResultView findToolsBank(ToolsBank toolsBank, @RequestParam(required = false, defaultValue = "1") Integer num,
                                        @RequestParam(required = false, defaultValue = "10") Integer size) {
        JsonResultView view = new JsonResultView();
        logger.info("查询银行开始");
        Page<ToolsBank> page = new Page<>(num,size);
        Page<ToolsBank> toolsBankPage = null;
        try {
//            toolsBank.setId(1L);
            EntityWrapper<ToolsBank> wrapper = new EntityWrapper<>(toolsBank);
            toolsBankPage = toolsBankService.selectPage(page,wrapper);
        } catch (Exception e) {
            logger.error("查询银行异常:{}",e);
            view.setMsg(CodeEnum.FAIL.getMsg());
            view.setCode(CodeEnum.FAIL.getCode());
            return view;
        }
        view.setObject(toolsBankPage);
        logger.info("查询银行结束:{}",toolsBankPage);
        return view;
    }

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultView findToolsBankById(Long id){
        logger.info("id:{}查询银行开始",id);
        JsonResultView view = new JsonResultView();
        try {
            ToolsBank toolsBank = toolsBankService.selectById(id);
            view.setObject(toolsBank);
            return view;
        } catch (Exception e) {
            logger.error("id:{}查询银行异常:{}",e);
        }
        view.setCode(CodeEnum.SUCCESS.getCode());
        return view;
    }
}

