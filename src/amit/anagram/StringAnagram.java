package amit.anagram;
import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		String s1="ARMY";
		String s2="MARY";
		char[] char1=s1.toCharArray();
		char[] char2=s2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		String sorted1=new String(char1);
		String sorted2=new String(char2);
		//System.out.println(sorted1);
		//System.out.println(sorted2);
		
	if (sorted1.equals(sorted2)){
			System.out.println("Anagram");
		}
			else
			{
				System.out.println("Not anagram");
			}
		
		
		

	}

}
