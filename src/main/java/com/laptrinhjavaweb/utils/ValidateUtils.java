package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.BuildingConstant;

import java.util.ArrayList;
import java.util.List;

public class ValidateUtils {
    public static boolean isValid(Object obj) {
        boolean isTrue = null != obj && !BuildingConstant.EMPTY_STRING.equals(obj.toString());
        // truyền vào isTrue khác null và khác rỗng
        if (isTrue) {
            if (obj instanceof String) {
                return true;
            } else if (obj instanceof Integer) {
                return 0 <= Integer.parseInt(obj.toString());
            }
        }
        return false;
    }

    /* Nếu truyền vào giá trị null là dính Exception,
    isNotBlank là bao gồm cả check != null và != "" */
    public static boolean isNotBlank(String str) {
        return str != null && !BuildingConstant.EMPTY_STRING.equals(str);
    }

    public static List<Long> isValid(List<Long> list) {
        List<Long> result = new ArrayList<Long>();
        if (!list.isEmpty()) {
            for (Long item : list) {
                if (item > 0) {
                    result.add(item);
                }
            }
            return result;
        }
        return new ArrayList<>();
    }
}

