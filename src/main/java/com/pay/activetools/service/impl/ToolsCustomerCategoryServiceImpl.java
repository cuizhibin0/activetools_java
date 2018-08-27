package com.pay.activetools.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pay.activetools.entity.ToolsCustomerCategory;
import com.pay.activetools.mapper.ToolsCustomerCategoryMapper;
import com.pay.activetools.service.ToolsCustomerCategoryService;
import com.pay.activetools.utils.BeanUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户类别表 服务实现类
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
@Service
public class ToolsCustomerCategoryServiceImpl extends ServiceImpl<ToolsCustomerCategoryMapper, ToolsCustomerCategory> implements ToolsCustomerCategoryService {

    @Override
    public void insertOrUpdateMcc(ToolsCustomerCategory toolsCustomerCategory) throws Exception {

        if (toolsCustomerCategory.getId() != null) {
            ToolsCustomerCategory findToolsCustomerCategory = selectById(toolsCustomerCategory.getId());
            if (findToolsCustomerCategory != null) {
                BeanUtil.copyPropertiesIgnoreNull(toolsCustomerCategory, findToolsCustomerCategory);
                updateAllColumnById(findToolsCustomerCategory);
            }
        } else {
            insert(toolsCustomerCategory);
        }
    }

    @Override
    public ToolsCustomerCategory findCustomerCategoryById(Long id) throws Exception {
        ToolsCustomerCategory toolsCustomerCategory = selectById(id);
        return toolsCustomerCategory;
    }

    @Override
    public Page<ToolsCustomerCategory> findCustomerCategory(Page<ToolsCustomerCategory> page, ToolsCustomerCategory toolsCustomerCategory) throws Exception {
        EntityWrapper<ToolsCustomerCategory> wrapper = new EntityWrapper<>(toolsCustomerCategory);
        wrapper.orderBy("status",false);
        Page<ToolsCustomerCategory> pageMcc = selectPage(page, wrapper);
        return pageMcc;
    }
}
