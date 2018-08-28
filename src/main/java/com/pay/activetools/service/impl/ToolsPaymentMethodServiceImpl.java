package com.pay.activetools.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pay.activetools.constant.Constant;
import com.pay.activetools.entity.ToolsPaymentMethod;
import com.pay.activetools.mapper.ToolsPaymentMethodMapper;
import com.pay.activetools.service.ToolsPaymentMethodService;
import com.pay.activetools.utils.BeanUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付方式表 服务实现类
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
@Service
public class ToolsPaymentMethodServiceImpl extends ServiceImpl<ToolsPaymentMethodMapper, ToolsPaymentMethod> implements ToolsPaymentMethodService {

    @Override
    public void insertOrUpdatePayType(ToolsPaymentMethod toolsPaymentMethod) throws Exception {
        Long id = toolsPaymentMethod.getId();
        if (id != null) {
            ToolsPaymentMethod paymentMethod = selectById(id);
            BeanUtil.copyPropertiesIgnoreNull(toolsPaymentMethod, paymentMethod);
            updateById(paymentMethod);
        } else {
            insert(toolsPaymentMethod);
        }

    }

    @Override
    public Page<ToolsPaymentMethod> findPayType(Page<ToolsPaymentMethod> page, ToolsPaymentMethod toolsPaymentMethod) throws Exception {
        EntityWrapper<ToolsPaymentMethod> wrapper = new EntityWrapper<>(toolsPaymentMethod);
        wrapper.orderBy(Constant.ORDER_BY,false);
        Page<ToolsPaymentMethod> toolsPaymentMethodPage = selectPage(page, wrapper);
        return toolsPaymentMethodPage;
    }

    @Override
    public ToolsPaymentMethod findPayTypeById(Long id) throws Exception {
        ToolsPaymentMethod toolsPaymentMethod = selectById(id);
        return toolsPaymentMethod;
    }
}
