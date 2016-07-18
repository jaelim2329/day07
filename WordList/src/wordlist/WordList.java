/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordlist;

/**
 *
 * @author jaelim
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class WordList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path toRead = Paths.get("prideandprejudice.txt");
        try (BufferedReader reader = Files.newBufferedReader(toRead, StandardCharsets.UTF_8)){
            String line;
            String[] eachWord;
            Set<String> s = new TreeSet<String>();
            while((line = reader.readLine()) != null) {
                eachWord = line.split("\\W+");
                for (String word : eachWord){
                	s.add(word);
                }
            }
            
            System.out.println(s.toString());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
