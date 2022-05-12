package com.laptrinhjavaweb.utils;

import java.util.Map;

public class MapUtil {
    public static <T> T getObject(Map<String,Object> params, String key, Class<T> tClass) {
        Object obj = params.get(key);
        return params.containsKey(key)? tClass.cast(obj):null;
    }
}