package cn.lilq.cloudalibaba.cloudcommon.util;

import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @auther: Li Liangquan
 * @date: 2021/3/16 20:55
 */
public class CopyUtil {
    /**
     *
     * @param obj
     * @param classObj
     * @return
     */
    public static <T> List<T> copyList(Object obj, Class<T> classObj) {
        List<T> list2 = new ArrayList<>();
        if (!Objects.isNull(obj)) {
            List list1 = (List) obj;
            list1.forEach(item -> {
                try {
                    T data = classObj.getDeclaredConstructor().newInstance();
                    BeanUtil.copyProperties(item,data);
                    list2.add(data);
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ignored) {
                }
            });
        }
        return list2;
    }

    public static <T> T copyObj(Object obj, Class<T> classObj) {
        return BeanUtil.copyProperties(obj, classObj);
    }

}
