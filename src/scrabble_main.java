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


		Vector<String> returnedWords = new Vector<String>();
		Vector<String> returnedSmallWords = new Vector<String>();
		
		Anagrams an;
		an = new Anagrams();
		an.openFiles();
		an.enterWords();
		an.matchBySize();
		returnedSmallWords.addAll(an.smallWordsList());
		for (int j = 0; j < returnedSmallWords.size(); j++){
			an.checkSubWords(returnedSmallWords.get(j));
		}
		returnedWords.addAll(an.returnedWords());
		
		for (String returnedWord: returnedWords){

			System.out.println(returnedWord);

		}
	

	}

}
