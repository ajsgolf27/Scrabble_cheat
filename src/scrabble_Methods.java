package scrabble;
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



import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Vector;

public class scrabble_Methods {

	private File words = new File("A Words.txt");
	private Vector<String> dictionaryList = new Vector<String>();
	private Vector<String> sameSize = new Vector<String>();
	private String userLetters;
	private String userLettersLowerCase;
	private String wordInDictionaryList;
	private char individualLettersFromUser;
	private String wordFromSameSizeList;
	private Vector<String> returnedWordsList = new Vector<String>();
	private Vector<String> smallerWordsList = new Vector<String>();
	private Collection<String> noDuplicateStrings = new LinkedHashSet<String>();
	private Collection<String> checkSmallerWords = new LinkedHashSet<String>();
	
	
	// opens the file containing the words and saves them to a vector
		public void openFiles() throws IOException{
			Scanner Files = new Scanner(words);
			while(Files.hasNext()){
				String wordsInFile = Files.nextLine().trim();
				dictionaryList.add(wordsInFile);
			}
			Files.close();
		}
		
		// takes the users input 
		public void enterWords(){
			System.out.println("Please enter your letters");
			Scanner userInput = new Scanner( System.in );
			userLetters = userInput.next();
			userLettersLowerCase = userLetters.toLowerCase();
			userInput.close();
		}
		
		public void matchBySize(){
			for(int ij = 0; ij < dictionaryList.size(); ij++){
				wordInDictionaryList = dictionaryList.get(ij);
				if(wordInDictionaryList.length() <= userLetters.length() ){
					sameSize.add(wordInDictionaryList);
				}
			}
		}
		
		public Vector <String> smallWordsList(){

			String smallWord;
			String smallerWord;
			char smallLetter;
			int length;
			smallerWordsList.add(userLettersLowerCase);
			// takes the user letters and takes every away a letter to make smaller letter 
			// combinations 
			for(int x3 = 0; x3 < smallerWordsList.size(); x3++){

				smallWord = smallerWordsList.get(x3);
				length = smallWord.length();
				StringBuilder sb = new StringBuilder(smallWord);
				for (int x4 = 0; x4 < length; x4++){
					smallLetter = sb.charAt(0);
					sb.deleteCharAt(0);
					smallerWord = sb.toString();
					if(sb.length() < 2){
					}else{
						smallerWordsList.add(smallerWord);
					}
					sb.append(smallLetter);
				}

			}
			
			checkSmallerWords.addAll(smallerWordsList);
			smallerWordsList.clear();
			smallerWordsList.addAll(checkSmallerWords);
			return smallerWordsList;
			
		}

		//checks all the words
		//this works by counting the letters in the word being compared, so if the 2 words have 
		//the same amount of letters you have found a match. 
		public void checkSubWords (String word){
			 String fromSmallwordsList = word;
			char letter;
			
			 int a = 0, b = 0, c = 0, d = 0, e = 0,  f = 0, g = 0, h = 0, i = 0,
						j = 0, k = 0, l = 0, m = 0, n = 0, o = 0, p = 0,  q = 0, r = 0, s = 0,
						t = 0, u = 0, v = 0, w = 0, x = 0,  y = 0,  z = 0,  a2 = 0, b2 = 0, c2 = 0,
						d2 = 0, e2 = 0, f2 = 0, g2 = 0, h2 = 0, i2 = 0, j2 = 0, k2 = 0, l2 = 0, m2 = 0, 
						n2 = 0, o2 = 0, p2 = 0, q2 = 0, r2 = 0, s2 = 0, t2 = 0,  u2 = 0,  v2 = 0, w2 = 0,
						x2 = 0, y2 = 0, z2 = 0;


			// add the value of the user given letters
			for(int jk = 0; jk < fromSmallwordsList.length(); jk++){
				individualLettersFromUser = fromSmallwordsList.charAt(jk);

				switch(individualLettersFromUser){
				case 'a':
					a++;
					break;
				case 'b':
					b++;
					break;
				case 'c':
					c++;
					break;
				case 'd':
					d++;
					break;
				case 'e':
					e++;
					break;
				case 'f':
					f++;
					break;
				case'g':
					g++;
					break;
				case 'h':
					h++;
					break;
				case 'i':
					i++;
					break;
				case 'j':
					j++;
					break;
				case 'k':
					k++;
					break;
				case 'l':
					l++;
					break;
				case 'm':
					m++;
					break;
				case 'n':
					n++;
					break;
				case 'o':
					o++;
					break;
				case 'p':
					p++;
					break;
				case 'q':
					q++;
					break;
				case 'r':
					r++;
					break;
				case 's':
					s++;
					break;
				case 't':
					t++;
					break;
				case 'u':
					u++;
					break;
				case 'v':
					v++;
					break;
				case 'w':
					w++;
					break;
				case 'x':
					x++;
					break;
				case 'y':
					y++;
					break;
				case 'z':
					z++;
					break;
				}
			}
		
			//go through the word list to compare the number of each letter 
			for(int hk = 0; hk < sameSize.size(); hk++){
				wordFromSameSizeList = sameSize.get(hk);
				for(int hlk = 0; hlk < wordFromSameSizeList.length(); hlk++){
					letter = wordFromSameSizeList.charAt(hlk);

					switch(letter){
					case 'a':
						a2++;
						break;
					case 'b':
						b2++;
						break;
					case 'c':
						c2++;
						break;
					case 'd':
						d2++;
						break;
					case 'e':
						e2++;
						break;
					case 'f':
						f2++;
						break;
					case'g':
						g2++;
						break;
					case 'h':
						h2++;
						break;
					case 'i':
						i2++;
						break;
					case 'j':
						j2++;
						break;
					case 'k':
						k2++;
						break;
					case 'l':
						l2++;
						break;
					case 'm':
						m2++;
						break;
					case 'n':
						n2++;
						break;
					case 'o':
						o2++;
						break;
					case 'p':
						p2++;
						break;
					case 'q':
						q2++;
						break;
					case 'r':
						r2++;
						break;
					case 's':
						s2++;
						break;
					case 't':
						t2++;
						break;
					case 'u':
						u2++;
						break;
					case 'v':
						v2++;
						break;
					case 'w':
						w2++;
						break;
					case 'x':
						x2++;
						break;
					case 'y':
						y2++;
						break;
					case 'z':
						z2++;
						break;

					}

				}
				
				if (a == a2 && b == b2 && c == c2 && d == d2 && e == e2 && f == f2 && g == g2 && h == h2 && i == i2 && j == j2 && k == k2 && l == l2 && m == m2 && n == n2 && o == o2 && p == p2 && q == q2 && r == r2 && s == s2 && t == t2 && u == u2 && v == v2 && w == w2 && x == x2 && y == y2 && z == z2 ){
					// adds the match to a vector to be returned later
					noDuplicateStrings.add(wordFromSameSizeList);
					//returnedWordsList.addElement(wordFromSameSizeList);
				}
				
				a2 = 0; b2 = 0; c2 = 0; d2 = 0; e2 = 0; f2 = 0; g2 = 0;
				h2 = 0; i2 = 0; j2 = 0; k2 = 0; l2 = 0; m2 = 0; n2 = 0;
				o2 = 0; p2 = 0; q2 = 0; r2 = 0; s2 = 0; t2 = 0; u2 = 0;
				v2 = 0; w2 = 0; x2 = 0; y2 = 0; z2 = 0;
			}	
		}
		
		//return the vector of matched words
		public Vector <String>  returnedWords(){
			returnedWordsList.addAll(noDuplicateStrings);
			return returnedWordsList;

		}



}


