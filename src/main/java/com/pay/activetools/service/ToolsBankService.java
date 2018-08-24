package com.pay.activetools.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.pay.activetools.entity.ToolsBank;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 工具银行表 服务类
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
public interface ToolsBankService extends IService<ToolsBank> {

    public void insertOrUpdateToolsBank(ToolsBank toolsBank) throws Exception;

    public Page<ToolsBank> findToolsBankPage(Page<ToolsBank> page,ToolsBank toolsBank);

}
