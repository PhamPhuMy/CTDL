package set_student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		ArrayList<T> toRemove = new ArrayList<>();
		for (T arr : coll) {
			if (p.test(arr)) {
				toRemove.add(arr);
			}
		}
		coll.removeAll(toRemove);
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		ArrayList<T> toRemove = new ArrayList<>();
		for (T arr : coll) {
			if (!p.test(arr)) {
				toRemove.add(arr);
			}
		}
		coll.removeAll(toRemove);
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> s1 = new LinkedHashSet<>();
		for (T arr : coll) {
			if (p.test(arr)) {
				s1.add(arr);
			}
		}
		return s1;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		ArrayList<T> l1 = new ArrayList<>(coll);
		for (T arr : l1) {
			if (p.test(arr)) {
				return l1.indexOf(arr);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		MyPredicates p1 = new MyPredicates();
		Predicate p = new Even();
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(23);
		l1.add(1);
		l1.add(44);
		l1.add(6);
		l1.add(20);
		l1.add(5);
		l1.add(7);
		l1.add(11);
		l1.add(23);
		System.out.println(l1);
//		p1.remove(l1, p);
		p1.retain(l1, p);
//		System.out.println(p1.collect(l1, p));
		System.out.println(l1);
//		System.out.println(p1.find(l1, p));
	}
}
