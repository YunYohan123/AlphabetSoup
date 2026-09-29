//Yohan Yun
//9/24/2026
//This program creates a Soup object thatt stores letters and a company name. Methods let you add, remove, randomly select letters, 
// and placing  company name in the middle of the letters.
public class Soup {
    //these are instance variables 
    private String letters;
    private String company;

    //Postcondition: this is a constructor it sets the instance variables (more on this later in the year)
    //No precondition, creates a Soup object with letters set to "" and company set to "none"
    public Soup(){
        letters ="";
        company = "none";
    }

    //precondition: company is a valid String value
    //Postcondition: sets the name of the company to the provided name
    public void setCompany(String company){
        this.company = company;
    }

    //No precondition
    //Postcondition: returns the company name
    public String getCompany(){
        return company;
    }

    //No precondition
    //Postcondition: returns letters
    public String getLetters(){
        return letters;
    }

//below are the functions you'll be writing.

    //No precondition, word is null
    //Postcondition: adds a word to the pool of letters known as "letters"
    public void add(String word){
        if (word != null){
            letters += word;
        }
    }

    //No precondition
    //Postcondition: Use Math.random() to get a random character from the letters string and return it.
    public char randomLetter(){
        int index = (int) (Math.random() * letters.length());
        if (letters.length() == 0){
            return '\0';
        }
        else{
            return letters.charAt(index);
        }
    }

    //No precondition
    //Postcondition: returns the letters currently stored with the company name placed directly in the center of all
    //the letters
    public String companyCentered(){
        int middle = letters.length() / 2;
        return letters.substring(0, middle) + company + letters.substring(middle);
    }

    //No precondition
    //Postcondition: should remove the first available vowel from letters. If there are no vowels this method has no effect.
    public void removeFirstVowel(){
        for (int i = 0; i < letters.length(); i++){ 
            char letter = letters.charAt(i);
            
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') { 
                letters = letters.substring(0, i) + letters.substring(i + 1); 
                return;
            } 
        }
    }

    //precondition: num isn't greater than the length of letters
    //Postcondition: should remove "num" letters from a random spot in the string letters. You may assume num never exceeds the 
    //length of the string.
    public void removeSome(int num){
        int start = (int)(Math.random() * (letters.length() - num + 1));
        
        letters = letters.substring(0, start) + letters.substring(start + num);
    }

    //No precondition
    //Postcondition: should remove the word "word" from the string letters. If the word is not found in letters then it does nothing.
    public void removeWord(String word){
        int position = letters.indexOf(word); 
        
        if (position >= 0){ 
            letters = letters.substring(0, position) + letters.substring(position + word.length()); 
        }
    }
}
