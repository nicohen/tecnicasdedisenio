package persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public abstract class SearchSolver<T extends Object> {

	public ArrayList<T> solveCollection(Map<Long, T> table) {
		ArrayList<T> result = new ArrayList<T>();
		Iterator<Long> it = table.keySet().iterator();
		while (it.hasNext()) {
			T t = table.get(it.next());
			if (getCondition(t))
				result.add(t);
		}
		return result;
	}

	public T solveUnique(Map<Long, T> table) {
		T result = null;
		boolean flag = true;
		Iterator<Long> it = table.keySet().iterator();
		while (it.hasNext()&& flag) {
			T t = table.get(it.next());
			if (getCondition(t)){
				result = t;
				flag = false;
			}
		}
		return result;
	}
	
	public abstract boolean getCondition(T t);
}