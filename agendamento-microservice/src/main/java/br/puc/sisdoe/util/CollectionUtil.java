package br.puc.sisdoe.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {
	
	public static <E> List<E> iterableToList(Iterable<E> iter) {
		List<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}
}
