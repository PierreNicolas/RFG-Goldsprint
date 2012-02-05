package com.rfg.goldsprint.view.utils;

import javax.swing.JComboBox;

import com.rfg.goldsprint.view.extcomponent.ComboItem;

public class ViewUtils {

	
public static int indexToSelect(int value, JComboBox list) {

		int index = 0;

		for (int i = 0; i < list.getItemCount(); i++) {
			if (value == ((ComboItem) list.getItemAt(i)).getValue()) {
				index = i;
				break;
			}
		}

		return index;
	}

}
