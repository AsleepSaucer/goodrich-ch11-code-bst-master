package apps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Collectors;

import net.datastructures.Entry;

import net.datastructures.SortedTableMap;
import net.datastructures.SortedMap;

/**
 *
 * @author bdmyers
 */
// An application to demonstrate SortedMap
// This application doesn't use the value part of Map entries so you could use a Set instead.
// See DictionaryAppWithSet for that version.
public class DictionaryApp {
	public static void main(String[] args) throws IOException {
	    BufferedReader input = new BufferedReader(new FileReader("words.txt"));

		System.out.println("Adding to our dictionary...");

		// our dictionary only has words, not definitions, so we will arbitrarily choose Integer as the type of value
		SortedMap<String, Integer> dictionary = new SortedTableMap<>();

		for (String word : input.lines().collect(Collectors.toList())) {
			// convert to lower case then put into Map
			dictionary.put(word.toLowerCase(), 1); // any value other than null will work here; we arbitrarily picked 1
		}

		System.out.println("Our dictionary contains " + dictionary.size() + " words");

		// demonstrate some of the SortedMap methods
		System.out.println("contains the word tea?: "+(dictionary.get("tea")!=null));
		System.out.println("contains the word yourself?: "+(dictionary.get("yourself")!=null));
		System.out.println("first: "+dictionary.firstEntry().getKey());
		String firstWord = dictionary.firstEntry().getKey();
		Entry<String,Integer> second = dictionary.higherEntry(firstWord);
		Entry<String,Integer> third = dictionary.higherEntry(second.getKey());
		System.out.println("second:"+second.getKey());
		System.out.println("third:"+third.getKey());
		System.out.println("last: "+dictionary.lastEntry().getKey());
		System.out.println("nearest above iowa: "+dictionary.ceilingEntry("iowa").getKey());
		System.out.println("nearest below iowa: "+dictionary.floorEntry("iowa").getKey());
		
		// print the first 3 L-words
		System.out.println("First 3 L-words");
		Iterator<Entry<String,Integer>> iwords = dictionary.subMap("l", "m").iterator();
		System.out.println(iwords.next().getKey());
		System.out.println(iwords.next().getKey());
		System.out.println(iwords.next().getKey());
	}	
}
