package com.qb.ad.common.util;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

public class CompareObjectUtils {


    /**
     * 比较两个实体属性值，返回一个map以有差异的属性名为key，value为obj2此属性名的值
     *
     * @param existed   进行属性比较的对象1
     * @param dest      进行属性比较的对象2
     * @param fileds 选择忽略比较的属性数组
     * @return 属性差异比较结果map
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, String> compareFields(Object existed, Object dest, List<String> fileds) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        if (fileds.isEmpty()) {
            return Collections.emptyMap();
        }
        if (existed.getClass() == dest.getClass()) {// 只有两个对象都是同一类型的才有可比性
            Class clazz = existed.getClass();
            // 获取object的属性描述
            PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz,
                    Object.class).getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {// 这里就是所有的属性了
                String name = pd.getName();// 属性名
                if (!fileds.contains(name)) {
                    continue;
                }
                Method readMethod = pd.getReadMethod();// get方法
                // 在obj1上调用get方法等同于获得obj1的属性值
                Object o1 = readMethod.invoke(existed);
                // 在obj2上调用get方法等同于获得obj2的属性值
                Object o2 = readMethod.invoke(dest);
                if (o1 instanceof String) {
                    if (o1 == null || o2 == null) {
                        continue;
                    } else if (o1 == null && o2 != null) {
                        map.put(name, o2.toString());
                        continue;
                    }
                    if (!o1.equals(o2)) {// 比较这两个值是否相等,不等就可以放入map了
                        map.put(name, o2.toString());
                    }
                }
            }
        }
        return map;
    }

}
