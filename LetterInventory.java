public class LetterInventory {
    // properties
    private int[] letterCount;
    private int totalCharCount;
    private int lettersInAlphabet;
    // constructor
    public LetterInventory(String data) {
        lettersInAlphabet = 26;
        totalCharCount = 0;
        letterCount = new int[lettersInAlphabet];
        for (int i = 0; i < data.length(); i++) {
            if(Character.isAlphabetic(data.charAt(i))) {
                letterCount[convert(data.toLowerCase().charAt(i))]++;
                totalCharCount++;
            }
        }
    }
    // returns the number of times a letter appears in our array
    // throws an exception if the char is non-alphabetic
    public int get(char letter) {
        return letterCount[convert(Character.toLowerCase(letter))];
    }
    // sets the count for a given letter to the value passed in,
    // throws an exception if the letter is non-alphabetic or if the int value is less than 0
    public void set(char letter, int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        letterCount[convert(Character.toLowerCase(letter))] = value;
        totalCharCount += value;
    }
    // returns the sum of all counts in the inventory
    public int size() {
        return totalCharCount;
    }
    // returns true if  the inventory is empty
    public boolean isEmpty() {
        return totalCharCount == 0;
    }
    // converts the inventory to a formatted, alphabetized string
    public String toString() {
        String output = "";
        int buffer;
        for (int i = 0; i < lettersInAlphabet; i++) {
            buffer = letterCount[i];
            while (buffer > 0) {
                char asciiToChar = (char) (i + 97);
                output += asciiToChar;
                buffer--;
            }
        }
        return ("[" + output + "]");
    }
    // returns a new inventory object that's the sum of this object and the passed-in object
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < lettersInAlphabet; i++) {
            sum.letterCount[i] = (this.letterCount[i] + other.letterCount[i]);
            sum.totalCharCount += (sum.letterCount[i]);
        }
        return sum;
    }
    // returns a new inventory object that's the difference of this object minus the passed-in object
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory difference = new LetterInventory("");
        for (int i = 0; i < lettersInAlphabet; i++) {
            if (this.letterCount[i] - other.letterCount[1] < 0) {
                return null;
            }
            difference.letterCount[i] = (this.letterCount[i] - other.letterCount[i]);
            difference.totalCharCount += difference.letterCount[i];
        }
        return difference;
    }
    // Converts a char to an int ranging from 0-25, each mapping to a letter of the alphabet from a->z in our array
    // Throws an exception if the char isn't alphabetic
    public int convert(char letter) {
        if(!Character.isAlphabetic(letter)) {
            throw new IllegalArgumentException();
        }
        return (Character.toLowerCase(letter) - 97);
    }
}

