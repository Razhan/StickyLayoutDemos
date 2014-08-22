package me.naiyu.android.stickylayoutdemos.util;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
	
	public static List<String> getListViewItems(int count) {
		List<String> items = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			items.add("item " + i);
		}
		return items;
	}

}
