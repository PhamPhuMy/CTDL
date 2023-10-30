package LAB6;

import java.util.Comparator;

public class MyArrayList<E> {
		public static final int DEFAULT_CAPACITY = 10;
		private E[] elements;
		private int size;

		public MyArrayList() {
			this.elements = (E[]) new Object[DEFAULT_CAPACITY];
		}

		public MyArrayList(int capacity) {
			this.elements = (E[]) new Object[capacity];
		}

		public void growSize() {
			E[] ob = (E[]) new Object[elements.length * 2];
			for (int i = 0; i < elements.length; i++) {
				ob[i] = elements[i];
			}
			this.elements = ob;
		}

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public E get(int i) throws IndexOutOfBoundsException {
			if (i < 0 || i >= size) {
				throw new IndexOutOfBoundsException();
			}
			return elements[i];
		}

		public E set(int i, E e) throws IndexOutOfBoundsException {
			if (i < 0 || i >= size) {
				throw new IndexOutOfBoundsException();
			}
			elements[i] = e;
			return elements[i];
		}

		public boolean add(E e) {
			if (size == elements.length) {
				growSize();
			}
			elements[size] = e;
			size++;
			return true;
		}

		public void add(int i, E e) throws IndexOutOfBoundsException {
			if (i < 0 || i >= size) {
				throw new IndexOutOfBoundsException();
			}
			if (size == elements.length) {
				growSize();
			}
			for (int j = size; j > i; j--) {
				elements[j] = elements[j - 1];
			}
			elements[i] = e;
			size++;
		}

		public E remove(int i) throws IndexOutOfBoundsException {
			if (i < 0 || i >= size) {
				throw new IndexOutOfBoundsException();
			}
			E ob = elements[i];
			for (int j = i; j < size - 1; j++) {
				elements[j] = elements[j + 1];
			}
			elements[size - 1] = null;
			size--;
			return ob;
		}

		public void clear() {
			for (int i = 0; i < size; i++) {
				elements[i] = null;
			}
			size = 0;
		}

		public int lastIndexOf(Object o) {
			for (int i = size - 1; i >= 0; i--) {
				if (elements[i].equals(o)) {
					return i;
				}
			}
			return -1;
		}

		@SuppressWarnings("unchecked")
		public E[] toArray() {
			E[] ob = (E[]) new Object[size];
			for (int i = 0; i < size; i++) {
				ob[i] = elements[i];
			}
			return ob;
		}

		public MyArrayList<E> clone() {
			MyArrayList<E> ob = new MyArrayList<E>(elements.length);
			for (int i = 0; i < size; i++) {
				ob.add(elements[i]);
			}
			return ob;
		}

		public boolean contains(E o) {
			if (indexOf(o) != -1) {
				return true;
			}
			return false;
		}

		public int indexOf(E o) {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(o)) {
					return i;
				}
			}
			return -1;
		}

		public boolean remove(E e) {
			int index = indexOf(e);
			if (index != -1) {
				remove(index);
				return true;
			}
			return false;
		}

		public void sort(Comparator<E> c) {
			for (int i = 0; i < size - 1; i++) {
				int min = i;
				for (int j = i; j < size; j++) {
					if (c.compare(elements[j], elements[min]) < 0) {
						min = j;
					}
				}
				E ob = elements[i];
				elements[i] = elements[min];
				elements[min] = ob;
			}
		}
	}

