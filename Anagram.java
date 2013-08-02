//created by NIKHIL GARG
import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import java.io.*;

public class Anagram {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		s = s.toLowerCase();
		Scanner sc1 = new Scanner(s);

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> anagrams = new ArrayList<>();
		while (sc1.hasNext()) {
			String word = sc1.next();
			String sortedWord = sort_String(word);

			anagrams = map.get(sortedWord);

			if (anagrams == null)
				anagrams = new ArrayList<String>();

			anagrams.add(word);
			map.put(sortedWord, anagrams);

		}

		ret(s, map);
	}

	static void ret(String s, HashMap<String, ArrayList<String>> map) {
		List<List<String>> myList = new ArrayList<List<String>>();

		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {

			HashSet<String> wrd = new HashSet<String>();
			for (String n : entry.getValue()) {
				wrd.add(n);

			}
			List<String> list = new ArrayList<String>();
			for (String n1 : wrd) {

				if (wrd.size() > 1) {
					list.add(n1);

				}
				Collections.reverse(list);
				if (list.size() != 0) {
					myList.add(list);
				}

			}

		}

		HashSet<List<String>> hs = new HashSet<List<String>>();
		hs.addAll(myList);
		myList.clear();
		myList.addAll(hs);
		Collections.reverse(myList);
		Iterator<List<String>> iterator = myList.iterator();
		while (iterator.hasNext()) {

			Iterator<String> iterator1 = iterator.next().iterator();
			while (iterator1.hasNext()) {
				System.out.print(iterator1.next() + " ");
			}
			System.out.print("\n");
		}

	}

	private static String sort_String(String word) {
		char[] ch = word.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
