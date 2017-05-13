package wordhistogram;

public class Word {
    
    private String  word;
    private int     count;

    public Word(String word) {
    
        this.word = word.toLowerCase();
        this.count = 1;
    }
    
    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public boolean is(String word) {
    
        return this.word.equalsIgnoreCase(word);
    }
    
    public void incrementCount() {
    
        count++;
    }
}
