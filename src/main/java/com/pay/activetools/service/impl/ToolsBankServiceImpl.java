package com.pay.activetools.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pay.activetools.bean.ToolsBankBean;
import com.pay.activetools.entity.ToolsBank;
import com.pay.activetools.mapper.ToolsBankMapper;
import com.pay.activetools.service.ToolsBankService;
import com.pay.activetools.utils.BeanUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工具银行表 服务实现类
 * </p>
 *
 * @author zhibin.cui
 * @since 2018-08-23
 */
@Service
public class ToolsBankServiceImpl extends ServiceImpl<ToolsBankMapper, ToolsBank> implements ToolsBankService {

    @Override
    public void insertOrUpdateToolsBank(ToolsBank toolsBank) throws Exception {
        Long id = toolsBank.getId();
        if (id != null) {
            ToolsBank findToolsBank = selectById(id);
            if (findToolsBank != null) {
                BeanUtil.copyPropertiesIgnoreNull(toolsBank, findToolsBank);
                updateAllColumnById(findToolsBank);
            }
        } else {
            insert(toolsBank);
        }
    }

    @Override
    public Page<ToolsBank> findToolsBankPage(Page<ToolsBank> page, ToolsBank toolsBank) {
        ToolsBankBean toolsBankBean = new ToolsBankBean();
        EntityWrapper<ToolsBank> wrapper = new EntityWrapper<>(toolsBank);
        Page<ToolsBank> toolsBankPage = selectPage(page, wrapper);
//        List<ToolsBank> toolsBankList = toolsBankPage.getRecords();
        return toolsBankPage;
    }
}
