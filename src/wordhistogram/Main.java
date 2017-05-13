package wordhistogram;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static ArrayList<Word> wordList = new ArrayList<>();
    private static String filePath = "C:\\Users\\CacTrainer\\Desktop\\Detyra CustomClass.txt";
    
    public static void main(String[] args) {
        
        String fileContents = readFile(filePath);
        loadWordCounts(fileContents);
        printWordHistogram();
    }
    
    public static void printWordHistogram() {
    
        for(Word listWord : wordList) {
            
            System.out.println("Word: \"" + 
                                listWord.getWord() + 
                                "\", count: " + 
                                listWord.getCount());
        }
    }
    
    public static void loadWordCounts(String src) {
    
        Pattern pattern = Pattern.compile("(\\w)+");
        Matcher matcher = pattern.matcher(src);
        
        while(matcher.find()) {
        
            String currentWord = matcher.group();
            
            Word listWord = getWordByString(currentWord);
             
            if(listWord != null) {
            
                listWord.incrementCount();
            }
            else {
            
                wordList.add(new Word(currentWord));
            }
        }
    } 
    
    private static Word getWordByString(String word) {
    
        for(Word listWord : wordList) {
            
            if(listWord.is(word)) {

                return listWord;
            }
        }
        
        return null;
    }
    
    private static String readFile(String fileName) {
    
        try {
            
            InputStream is = new FileInputStream(fileName); 
            BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 

            String line = buf.readLine(); StringBuilder sb = new StringBuilder(); 

            while(line != null){ 
                sb.append(line).append("\n"); 
                line = buf.readLine(); 
            } 

            return sb.toString();
        }
        catch(IOException ex) {
        
            return null;
        }
    }
}
