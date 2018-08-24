package com.pay.activetools.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;
/**
 * bean字段copy工具类
 * @Description: 这里用一句话描述这个类的作用
 * @see: BeanUtil 此处填写需要参考的类
 * @version 2018年5月8日 下午3:23:32 
 * @author zhibin.cui
 */
public class BeanUtil {

    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }


    private static void getEmptyNames(final BeanWrapper src, java.beans.PropertyDescriptor[] pds, Set<String> emptyNames) {
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<String>();

        getEmptyNames(src, pds, emptyNames);

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);

    }
}
