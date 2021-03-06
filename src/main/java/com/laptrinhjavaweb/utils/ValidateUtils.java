package com.laptrinhjavaweb.utils;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.constant.BuildingTypeConstant;

public class ValidateUtils {
	public static boolean isValid(Object obj) {
		boolean isTrue = null != obj && !BuildingTypeConstant.STRING_EMPTY.equals(obj.toString());
		// truyền vào isTrue khác null và khác rỗng
		if (isTrue) {
			if (obj instanceof String) {
				return true;
			} 
			else if (obj instanceof Integer) {
				return 0 <= Integer.parseInt(obj.toString());
			}
		}
		return false;
	}

	public static List<Long> isValid(List<Long> list) {
		List<Long> result = new ArrayList<Long>();
		if(!list.isEmpty()) {
			for (Long item : list) {
				if(item > 0) {
					result.add(item);
				}
			}
			return result;
		}
		return new ArrayList<>();
	}

}
