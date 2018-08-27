package com.pay.activetools.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.pay.activetools.entity.ToolsCustomerCategory;

/**
 * <p>
 * 商户类别表 服务类
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
public interface ToolsCustomerCategoryService extends IService<ToolsCustomerCategory> {

    /**
     * 保存或者修改MCC
     *
     * @param toolsCustomerCategory
     */
    void insertOrUpdateMcc(ToolsCustomerCategory toolsCustomerCategory) throws Exception;

    /**
     * 根据id查询MCC
     *
     * @param id
     * @return
     */
    ToolsCustomerCategory findCustomerCategoryById(Long id) throws Exception;

    /**
     * 根据条件查询MCC
     *
     * @param toolsCustomerCategory
     * @return
     */
    Page<ToolsCustomerCategory> findCustomerCategory(Page<ToolsCustomerCategory> page, ToolsCustomerCategory toolsCustomerCategory) throws Exception;
}
