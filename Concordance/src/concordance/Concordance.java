package concordance;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class Concordance {

	public static void main(String[] args) {
		Path toRead = Paths.get("prideandprejudice.txt");
        try (BufferedReader reader = Files.newBufferedReader(toRead, StandardCharsets.UTF_8)){
            String line;
            String[] eachWord;
            TreeMap<String, Integer> h = new TreeMap<String, Integer>();
            while((line = reader.readLine()) != null) {
                eachWord = line.split("\\W+");
                for (String word : eachWord){
                	if (h.containsKey(word)){
                		h.put(word, h.get(word) + 1);
                	}
                	else {
                		h.put(word,  1);
                	}
                }
            }
            
            for (String key : h.keySet()){
            	System.out.printf("Word '%s' occurred %d times\n", key, h.get(key));
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

	}

}
