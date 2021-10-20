/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.eugeneforest.toolbox.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 通用工具类
 *
 * @author Chill
 */
public class CommonUtil {
	public static Map<String, Object> formatHumpName(Map<String, Object> map) {
		Map<String, Object> newMap = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = toFormatCol(key);
			newMap.put(newKey, entry.getValue());
		}
		return newMap;
	}

	public static String toFormatCol(String colName) {
		StringBuilder sb = new StringBuilder();
		String[] str = colName.toLowerCase().split("_");
		int i = 0;
		for (String s : str) {
			if (s.length() == 1) {
				s = s.toUpperCase();
			}
			i++;
			if (i == 1) {
				sb.append(s);
				continue;
			}
			if (s.length() > 0) {
				sb.append(s.substring(0, 1).toUpperCase());
				sb.append(s.substring(1));
			}
		}
		return sb.toString();
	}
}
