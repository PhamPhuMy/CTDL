package set_student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
//	 public static final String fileName = "src/data/hamlet.txt";
	public static final String fileName = "src/data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	// {"Dai","hoc","Nong","Lam",Dai,hoc}
	// l1 = {Dai-1,hoc-1,Nong-1,Lam-1}
	public List<WordCount> getWordCounts() {
		List<WordCount> l1 = new ArrayList<>();
		for (String arr : words) {
			WordCount w1 = new WordCount(arr, 1);
			if (!l1.contains(w1)) {
				l1.add(w1);
			} else {
				w1 = l1.get(l1.indexOf(w1));
				w1.setCount(w1.getCount() + 1);
			}
		}
		return l1;
	}

	// Returns the words that their appearance are 1, do not consider duplicated
	// words
	public Set<String> getUniqueWords() {
		Set<String> s1 = new LinkedHashSet<>();
		for (WordCount arr : getWordCounts()) {
			if (arr.getCount() == 1) {
				s1.add(arr.getWord());
			}
		}
		return s1;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> array = new LinkedHashSet<>(words);
		return array;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		TreeSet<WordCount> t1 = new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		t1.addAll(getWordCounts());
		return t1;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		TreeSet<WordCount> t1 = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				if (o1.getCount() == o2.getCount()) {
					return o2.getWord().compareTo(o1.getWord());
				}
				return o2.getCount() - o1.getCount();
			}

		});
		t1.addAll(getWordCounts());
		return t1;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> s1 = new LinkedHashSet<>(words);
		for (String arr : words) {
			if (arr.charAt(0) == pattern.charAt(0)) {
				s1.remove(arr);
			}
		}
		return s1;
	}

	public static void main(String[] args) {
		MyWordCount m1 = new MyWordCount();
		System.out.println(m1.getWordCounts());
		System.out.println(m1.getUniqueWords());
		System.out.println(m1.getDistinctWords());
		System.out.println(m1.printWordCounts());
		System.out.println(m1.exportWordCountsByOccurence());
		System.out.println(m1.filterWords("D"));
	}
}
