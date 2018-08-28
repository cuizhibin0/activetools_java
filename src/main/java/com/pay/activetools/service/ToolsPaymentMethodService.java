package com.pay.activetools.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.pay.activetools.entity.ToolsPaymentMethod;

/**
 * <p>
 * 支付方式表 服务类
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */

public interface ToolsPaymentMethodService extends IService<ToolsPaymentMethod> {

    void insertOrUpdatePayType(ToolsPaymentMethod toolsPaymentMethod) throws Exception;

    Page<ToolsPaymentMethod> findPayType(Page<ToolsPaymentMethod> page, ToolsPaymentMethod toolsPaymentMethod) throws Exception;

    ToolsPaymentMethod findPayTypeById(Long id) throws Exception;
}
