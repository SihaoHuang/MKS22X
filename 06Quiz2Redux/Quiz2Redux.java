import java.util.*;
public class Quiz2Redux{  
  /*Returns an ArrayList<String> that contains all subsets of the
   *characters of String s. Assume s has no duplicate characters.
   *the characters should appear in the same order that they occur 
   *in the original string.
   */
  public static ArrayList<String> combinations(String s){
      ArrayList<String> words = new ArrayList<String>();
      help(s, words, "", 0);
      Collections.sort(words);
      return words;
  }
  
  public static void help(String s, ArrayList<String> words, String previous, int index){
    if(index == s.length()) {
      words.add(previous);
      return;
    }
    help(s, words, previous + Character.toString(s.charAt(index)), index + 1);
    help(s, words, previous, index + 1);
  }

  public static void main(String args[]){
    System.out.println(combinations("abcdefg"));
  }
}
   