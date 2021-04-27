package apps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author bdmyers
 */
// An application to demonstrate Java library's NavigableSet (i.e., SortedSet)
public class DictionaryAppWithSet {
	public static void main(String[] args) throws IOException {
	    BufferedReader input = new BufferedReader(new FileReader("words.txt"));

		System.out.println("Adding to our dictionary...");

		NavigableSet<String> dictionary = new TreeSet<>();

		for (String word : input.lines().collect(Collectors.toList())) {
			// convert to lower case then put into Set
			dictionary.add(word.toLowerCase());
		}

		System.out.println("Our dictionary contains " + dictionary.size() + " words");

		// demonstrate some of the SortedMap methods
		System.out.println("contains the word tea?: "+ dictionary.contains("tea"));
		System.out.println("contains the word yourself?: "+ dictionary.contains("yourself"));
		System.out.println("first: "+dictionary.first());
		String firstWord = dictionary.first();
		String second = dictionary.higher(firstWord);
		String third = dictionary.higher(second);
		System.out.println("second:"+second);
		System.out.println("third:"+third);
		System.out.println("last: "+dictionary.last());
		System.out.println("nearest above iowa: "+dictionary.ceiling("iowa"));
		System.out.println("nearest below iowa: "+dictionary.floor("iowa"));
		
		// print the first 3 L-words
		System.out.println("First 3 L-words");
		Iterator<String> iwords = dictionary.subSet("l", "m").iterator();
		System.out.println(iwords.next());
		System.out.println(iwords.next());
		System.out.println(iwords.next());
	}	
}
