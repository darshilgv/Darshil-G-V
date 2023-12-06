package Games_CLI_java;
import java.util.*;

class Game {
    Scanner in = new Scanner(System.in);
    private int chan = 6;
    private final String[] ew = {
            "apple", "banana", "orange", "grape", "kiwi",
            "java", "python", "javascript", "html", "css",
            "computer", "programming", "algorithm", "database",
            "moon", "sun", "star", "galaxy", "planet",
            "mountain", "river", "ocean", "forest", "desert",
            "cat", "dog", "bird", "elephant", "lion",
            "music", "art", "history", "science", "math",
            "book", "pen", "paper", "keyboard", "mouse",
            "happy", "sad", "exciting", "calm", "energetic"
    };
    String[] dw = {
            "ubiquitous", "serendipity", "ephemeral", "effervescent", "labyrinthine",
            "quixotic", "meticulous", "resilient", "vicissitude", "plethora",
            "antediluvian", "perspicacious", "sycophant", "indolent", "perfidious",
            "juxtapose", "obfuscate", "mellifluous", "cogent", "ubiquity",
            "effulgent", "verisimilitude", "obfuscation", "plebeian", "sanguine",
            "quagmire", "quintessential", "rapacious", "sycophantic", "ineffable",
            "cynosure", "panacea", "ephemeral", "equanimity", "recalcitrant",
            "aberration", "innocuous", "superfluous", "esoteric", "idiosyncrasy",
            "languid", "quandary", "querulous", "inchoate", "recalcitrant"
    };
    private String curr = "";
    String filled = "";
    int nf = 0;

    private void genWord(int m) {
        Random r = new Random();
        int ind;
        if (m==1){
            ind = r.nextInt(ew.length);
            curr = ew[ind];
        }
        else {
            ind = r.nextInt(dw.length);
            curr = dw[ind];
        }
        for (int i = 0; i < curr.length(); i++) {
            filled += "_ ";
        }
    }

    public void printHangman() {
        if (chan == 6) {
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("| ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("----------------------");
        } else if (chan == 5) {
            System.out.println("|---------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("| ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("----------------------");
        } else if (chan == 4) {
            System.out.println("|---------");
            System.out.println("|        |");
            System.out.println("|      ");
            System.out.println("|      ");
            System.out.println("|      ");
            System.out.println("|      ");
            System.out.println("|      ");
            System.out.println("|      ");
            System.out.println("|");
            System.out.println("----------------------");
        } else if (chan == 3) {
            System.out.println("|---------");
            System.out.println("|        |");
            System.out.println("|      -----");
            System.out.println("|      |- -|");
            System.out.println("|      -----");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println("|        ");
            System.out.println("|");
            System.out.println("----------------------");
        } else if (chan == 2) {
            System.out.println("|---------");
            System.out.println("|        |");
            System.out.println("|      -----");
            System.out.println("|      |- -|");
            System.out.println("|      -----");
            System.out.println("|        |");
            System.out.println("|        |");
            System.out.println("|       ");
            System.out.println("|");
            System.out.println("----------------------");

        } else if (chan == 1) {
            System.out.println("|---------");
            System.out.println("|        |");
            System.out.println("|      -----");
            System.out.println("|      |- -|");
            System.out.println("|      -----");
            System.out.println("|      __|__");
            System.out.println("|        |");
            System.out.println("|       ");
            System.out.println("|");
            System.out.println("----------------------");
        } else if (chan == 0) {
            System.out.println("|---------");
            System.out.println("|        |");
            System.out.println("|      -----");
            System.out.println("|      |- -|");
            System.out.println("|      -----");
            System.out.println("|      __|__");
            System.out.println("|        |");
            System.out.println("|       / \\");
            System.out.println("|");
            System.out.println("----------------------");
            gameOver(1);
        }
    }

    public void gameOver(int c) {
        if (c == 1) {
            System.out.println("Game over! he is hanging");
        } else {
            System.out.println("You won he he! congratulations!");
        }
        System.out.println("Word= "+curr);
        System.exit(c);
    }

    public void try_Insert(char ch) {
        boolean f = false;
        int freq = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) == ch) {
                f=true;
                if (filled.charAt(i+i) == '_') {
                    StringBuilder x = new StringBuilder(filled);
                    x.setCharAt((i + i), ch);
                    filled= String.valueOf(x);
                    freq++;
                }else{
                    System.out.println("Already Entered Letter");
                }
            }
        }
        if (!f)
            chan--;
        else
            nf += freq;
    }

    Game() {
        System.out.println("Select your mode: ");
        System.out.println("1. Easy");
        System.out.println("2. Difficult");
        int m=in.nextInt();
        switch (m){
            case 1:
                genWord(1);
                break;

            case 2:
                genWord(2);
                break;

            default:
                System.out.println("Invalid Input!!!!!!");
                System.exit(0);
                break;
        }
        System.out.println("Guess the Word:");
        while (true) {
            if (nf == curr.length()){
                gameOver(2);
                break;
            }
            printHangman();
            System.out.println("Number of Chances left= "+chan);
            System.out.println("Word: "+filled);
            System.out.println("Enter a letter: ");
            char ch = in.next().charAt(0);
            ch=Character.toLowerCase(ch);
            try_Insert(ch);
        }
    }
}

public class Hangman {
    public static void main(String[] args) {
        Game g = new Game();
    }
}
