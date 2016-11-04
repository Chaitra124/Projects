import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
	public static void main(String args[]) {

		ArrayList<WordCount> list=new ArrayList<>();
		try( BufferedReader reader=new BufferedReader(new FileReader("c:/Code/workspace/amit/bin/input.txt")) ) {
			String line;
			while((line=reader.readLine())!=null) {
				String[] words=line.split(" ");
				for(String word:words)
					addWord(word,list);
			}
			Collections.sort(list,null);
			WordCount wc1=list.get(0);
			WordCount wc2=list.get(list.size()-1);
			System.out.print("\n"+wc1.word+" is the word with highest count: "+wc1.count);
			System.out.print("\n"+wc2.word+" is the word with lowest count: "+wc2.count);
		} catch(FileNotFoundException fnfex) {
			fnfex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}

	}
	public static void addWord(String word, ArrayList<WordCount> list) {
		WordCount wordCount=null;
		for(WordCount wc:list)
			if(wc.word.equals(word)) {
				wordCount=wc;
				break;
			}
		if(wordCount==null) {
			wordCount=new WordCount(word,1);
			list.add(wordCount);
		}
		else
			++wordCount.count;
	}
}

class WordCount implements Comparable<WordCount> {
	public String word;
	public int count;
	public WordCount(String word, int count) {
		this.word=word;
		this.count=count;
	}
	public int compareTo(WordCount wc) {
		if(this.count<wc.count)
			return 1;
		else if(this.count>wc.count)
			return -1;
		else
			return 0;
	}
	@Override
	public String toString() { return "{"+this.word+","+this.count+"}"; }
}