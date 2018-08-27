package com.pay.activetools.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.pay.activetools.bean.JsonResultView;
import com.pay.activetools.entity.ToolsCustomerCategory;
import com.pay.activetools.enums.CodeEnum;
import com.pay.activetools.service.ToolsCustomerCategoryService;
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
 * 商户类别表 前端控制器
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
@Controller
@RequestMapping("/mcc")
public class ToolsCustomerCategoryController {
    private static Logger logger = LoggerFactory.getLogger(ToolsCustomerCategoryController.class);

    @Autowired
    private ToolsCustomerCategoryService toolsCustomerCategoryService;

    /**
     * 保存或修改
     *
     * @param toolsCustomerCategory
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject saveCustomerCategory(ToolsCustomerCategory toolsCustomerCategory) {
        logger.info("保存或修改MCC参数", toolsCustomerCategory);
        try {
            toolsCustomerCategoryService.insertOrUpdateMcc(toolsCustomerCategory);
            return CodeEnum.SUCCESS.getJsonMsg();
        } catch (Exception e) {
            logger.error("保存或修改MCC异常:{}", e);
        }
        return CodeEnum.FAIL.getJsonMsg();
    }

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultView findCustomerCategoryById(Long id) {
        JsonResultView view = new JsonResultView();
        try {
            ToolsCustomerCategory toolsCustomerCategory = toolsCustomerCategoryService.findCustomerCategoryById(id);
            view.setObject(toolsCustomerCategory);
            return view;
        } catch (Exception e) {
            logger.error("根据id:{}查询MCC异常:{}", id, e);
        }
        view.setCode(CodeEnum.FAIL.getCode());
        return view;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultView findCustomerCategoryBy(ToolsCustomerCategory toolsCustomerCategory,
                                                 @RequestParam(required = false, defaultValue = "1") Integer num,
                                                 @RequestParam(required = false, defaultValue = "10") Integer size) {
        JsonResultView view = new JsonResultView();
        logger.info("查询MCC参数:{}", toolsCustomerCategory);
        Page<ToolsCustomerCategory> page = new Page<>(num, size);
        try {
            Page<ToolsCustomerCategory> customerCategory = toolsCustomerCategoryService.findCustomerCategory(page, toolsCustomerCategory);
            logger.info("{}",customerCategory.getRecords());
            view.setObject(customerCategory);
            return view;
        } catch (Exception e) {
            logger.error("查询MCC异常:{}", e);
        }
        view.setCode(CodeEnum.FAIL.getCode());
        return view;
    }
}

