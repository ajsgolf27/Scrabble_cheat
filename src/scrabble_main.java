/*The MIT License (MIT)

Copyright (c) [2015] [Andrew Stallone]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/


import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Vector;


public class scrabble_main {

	public static void main(String[] args) throws IOException {


		Vector<String> mainWords = new Vector<String>();
		Vector<String> returnedWords = new Vector<String>();
		
		scrabble_Methods sm;
		sm = new scrabble_Methods();
		
		
		sm.openFiles();
		sm.enterWords();
		sm.matchBySize();
		sm.refineWordsList();
		
		// adds the list to a LinkedHashSet because it doesn't allow duplicate strings
		// therefore reducing the size of the list by 98.5% in turn optimizing performance.
		mainWords.addAll(sm.smallWordsList());
		Collection<String> noDuplicateStrings = new LinkedHashSet<String>(mainWords);
		mainWords.clear();
		mainWords.addAll(noDuplicateStrings);

		// passes in each word to be checked against the library
		for( int x = 0; x< mainWords.size(); x++){

			sm.checkSubWords(mainWords.get(x));
		}
		
		// get the list of all the possible words
		returnedWords.addAll(sm.returnedWords());

		// adds the words to a TreeSet to organize by alphabetical order
		TreeSet<String> treeset = new TreeSet<String>();
		treeset.addAll(returnedWords);
		returnedWords.clear();
		returnedWords.addAll(treeset);
		
		//prints the possible words to the console
		for (String returnedWord: returnedWords){

			System.out.println(returnedWord);

		}
		
		
		


	}

}
