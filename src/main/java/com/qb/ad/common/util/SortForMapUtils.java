package com.qb.ad.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class SortForMapUtils {

	/**
	 * map集合排序
	 * 
	 * @param repayItemDataMapOneByOne
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedHashMap<String, Map<String, String>> sort(LinkedHashMap<String, Map<String, String>> repayItemDataMapOneByOne)
			throws Exception {
		// 将排过序的数据放到新map中
		LinkedHashMap<String, Map<String, String>> sortRepayItemMap = new LinkedHashMap<String, Map<String, String>>();
		List<Integer> list = new ArrayList<Integer>();
		// 获取所有的期号
		Iterator entries = repayItemDataMapOneByOne.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String mapOfKey = (String) entry.getKey();
			String[] split = mapOfKey.split("_");
			list.add(Integer.valueOf(split[split.length - 1]));
		}
		// 期号去重
		list = new ArrayList<Integer>(new LinkedHashSet<Integer>(list));
		// 期号排序
		Collections.sort(list);
		// 遍历期号，按期号顺序排序
		for (int i = 0; i < list.size(); i++) {
			Iterator entries2 = repayItemDataMapOneByOne.entrySet().iterator();
			while (entries2.hasNext()) {
				Map.Entry entry = (Map.Entry) entries2.next();
				String mapOfKey = (String) entry.getKey();
				String[] split = mapOfKey.split("_");
				if (Integer.valueOf(split[split.length - 1]) == list.get(i)) {
					sortRepayItemMap.put((String) entry.getKey(), (Map<String, String>) entry.getValue());
				}
			}
		}
		return sortRepayItemMap;
	}

	/**
	 * v2：给map排序
	 * 
	 * @param repayItemDataMapOneByOne
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedHashMap<String, Map<String, String>> sort2(LinkedHashMap<String, Map<String, String>> repayItemDataMapOneByOne)
			throws Exception {
		LinkedHashMap<String, Map<String, String>> sortRepayItemMap = new LinkedHashMap<String, Map<String, String>>();
		Map<String, List<String>> rock = new LinkedHashMap<String, List<String>>();
		Iterator entries = repayItemDataMapOneByOne.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			List<String> list = new ArrayList<String>();
			String[] split = String.valueOf(entry.getKey()).split("_");
			String periods = split[split.length - 1];
			Set<String> keySet = rock.keySet();
			if (!keySet.contains(periods)) {
				list = new ArrayList<String>();
				list.add(JSONObject.toJSONString((Map<String, String>) entry.getValue()));
			} else {
				list = rock.get(periods);
				list.add(JSONObject.toJSONString((Map<String, String>) entry.getValue()));
			}
			rock.put(periods, list);
		}
		List<String> keyList = new ArrayList<String>(rock.keySet());
		Collections.sort(keyList);
		for (Iterator ite = keyList.iterator(); ite.hasNext();) {
			String temp = (String) ite.next();
			List<String> list = rock.get(temp);
			for (String string : list) {
				sortRepayItemMap.put(UUID.randomUUID().toString() + "_" + temp, JSON.parseObject(string, Map.class));
			}
		}
		return sortRepayItemMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		LinkedHashMap<String, Map<String, String>> repayItemDataMapOneByOne = new LinkedHashMap<String, Map<String, String>>();
		LinkedHashMap<String, Map<String, String>> sortRepayItemMap = new LinkedHashMap<String, Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("asd5", "dsa");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("asd2", "dsa");
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("asd2", "dsa");
		Map<String, String> map4 = new HashMap<String, String>();
		map4.put("asd3", "dsa");
		repayItemDataMapOneByOne.put("aa_as_5", map);
		repayItemDataMapOneByOne.put("aa_ad_2", map2);
		repayItemDataMapOneByOne.put("aa_af_2", map3);
		repayItemDataMapOneByOne.put("aa_ag_3", map4);
//		try {
//			repayItemDataMapOneByOne = sort(repayItemDataMapOneByOne);
//		} catch (Exception e) {
//			System.err.println("集合排序异常");
//		}
		System.out.println(JSONObject.toJSONString(repayItemDataMapOneByOne));
		Map<String, List<String>> rock = new LinkedHashMap<String, List<String>>();
		Iterator entries = repayItemDataMapOneByOne.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			List<String> list = new ArrayList<String>();
			String[] split = String.valueOf(entry.getKey()).split("_");
			String periods = split[split.length - 1];
			Set<String> keySet = rock.keySet();
			if (!keySet.contains(periods)) {
				list = new ArrayList<String>();
				list.add(JSONObject.toJSONString((Map<String, String>) entry.getValue()));
			} else {
				list = rock.get(periods);
				list.add(JSONObject.toJSONString((Map<String, String>) entry.getValue()));
			}
			rock.put(periods, list);
		}
		System.out.println(JSONObject.toJSONString(rock));
		List<String> keyList = new ArrayList<String>(rock.keySet());
		Collections.sort(keyList);
		for (Iterator ite = keyList.iterator(); ite.hasNext();) {
			String temp = (String) ite.next();
			List<String> list = rock.get(temp);
			for (String string : list) {
				sortRepayItemMap.put(UUID.randomUUID().toString(), JSON.parseObject(string, Map.class));
			}
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println(JSONObject.toJSONString(sortRepayItemMap));
//		rock.put("", "");
//		List<Integer> list = new ArrayList<Integer>();
//		Iterator entries = repayItemDataMapOneByOne.entrySet().iterator();
//		while (entries.hasNext()) {
//			Map.Entry entry = (Map.Entry) entries.next();
//			String mapOfKey = (String) entry.getKey();
//			String[] split = mapOfKey.split("_");
//			list.add(Integer.valueOf(split[split.length - 1]));
//		}
//		list = new ArrayList<Integer>(new LinkedHashSet<Integer>(list));
//		Collections.sort(list);
//		System.out.println(JSONObject.toJSONString(list));
//		for (int i = 0; i < list.size(); i++) {
//			Iterator entries2 = repayItemDataMapOneByOne.entrySet().iterator();
//			while (entries2.hasNext()) {
//				Map.Entry entry = (Map.Entry) entries2.next();
//				String mapOfKey = (String) entry.getKey();
//				String[] split = mapOfKey.split("_");
//				if (Integer.valueOf(split[split.length - 1]) == list.get(i)) {
//					sortRepayItemMap.put((String) entry.getKey(), (Map<String, String>) entry.getValue());
//				}
//			}
//		}
//		System.out.println(JSONObject.toJSONString(sortRepayItemMap));
	}

}
