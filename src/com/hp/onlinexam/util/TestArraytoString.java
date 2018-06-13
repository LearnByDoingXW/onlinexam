package com.hp.onlinexam.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArraytoString {
	public static void main(String[] args) {
		String[] Array = { "1", "2", "3", "4", "5" };
		String ids = ToolUtil.arraytoString(Array);
		System.out.println(ids);
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		Collections.shuffle(list);
		for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
		}
	}
}
