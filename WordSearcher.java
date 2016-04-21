import java.util.*;
import java.io.*;
/**
 * A program that loads the English dictionary into memory and allows the user
 * to search the dictionary.
 * Author : Yuantao Niu
 */ 
public class WordSearcher {

    public static String processWord(String s){
        String w= "";
        if (s == null)
            return w;
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)>=97 && (s.charAt(i)<=122))
                w = w + s.charAt(i);
            else if (s.charAt(i)>= 65 && s.charAt(i)<=90)
                w = w+ Character.toLowerCase(s.charAt(i));
            else 
                continue;
        }
        return w;
    }

    public static void main(String[] args) {
        try {
            
            TrieNode newNode = new TrieNode();
            
            File wordsFile = new File("words.txt");
            BufferedReader reader = new BufferedReader(new FileReader(wordsFile));
            
            
            String word;// = reader.readLine();
            while((word = reader.readLine())!=null){
                
                //word = reader.readLine();
                try{word = processWord(word);}catch(Exception e){System.err.println(word);}
                //System.out.println(word);
                newNode.add(word);
            }
   

            Scanner input = new Scanner(System.in);
            System.out.print("Enter a pattern string: ");
            while (input.hasNextLine()) {
                String line = input.nextLine();
                newNode.match(line);
                System.out.print("Enter a string: ");

            }
        }
        catch (IOException x) { 
            System.err.println(x);
        }
    }
}
