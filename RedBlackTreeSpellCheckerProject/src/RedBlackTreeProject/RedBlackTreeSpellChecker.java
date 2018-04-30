package RedBlackTreeProject;





import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class RedBlackTreeSpellChecker {

    private RedBlackTree wordList;

    /**
     * Constructor that loads the list of words into memory
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public RedBlackTreeSpellChecker() throws FileNotFoundException, IOException {
		FileInputStream fstream = new FileInputStream("shortwords.txt");
		// Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        int wordCount = 0;
        wordList = new RedBlackTree();
        while((strLine = br.readLine()) != null) {
        	wordList.insert(strLine);
        	   wordCount = wordCount + 1;
        }


        System.out.println("Red Black Tree loaded with " + wordCount + " words");
        System.out.println("The height of the tree is " + wordList.height());
        System.out.println("2 * log(n + 1)" + (2 * Math.log(wordCount + 1)));
        printUsage();
        in.close();
    }

    /**
     *
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    @SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException {
        RedBlackTreeSpellChecker sCheck = new RedBlackTreeSpellChecker();

        Scanner in = new Scanner(System.in);
        String input;
        
        // Run the spell checker infinitely until user wishes to exit
        while (true) {
            System.out.print("> ");
            input = in.nextLine();

            // If user doesn't enter anything, ignore and continue
            if (input == null || input.length() == 0) {
                continue;
            }
            
            // For each option, its corresponding action is taken
            if (input.equals("p")) {
                System.out.println("Level Order Traversal:");
                sCheck.wordList.levelOrderTraversal();
                continue;
            } else if (input.equals("!")) {
                System.out.println("Bye !");
                return;
            } else if (input.startsWith("c ")) {
                if (sCheck.wordList.contains(input.substring(2))) {
                    System.out.println("Found " + sCheck.wordList.closeBy(input.substring(2)) + " after " + sCheck.wordList.getRecentCompares() + " comparisons");
                } else {
                    System.out.println("The word \"" + input.substring(2) + "\" is not present in dictionary. Perhaps you mean " + sCheck.wordList.closeBy(input.substring(2)));
                }
                continue;
            } else if (input.startsWith("a ")) {
                sCheck.wordList.insert(input.substring(2));
                System.out.println("The word \"" + input.substring(2) + "\" has been added to the dictionary");
                continue;
            } else {
                System.out.println("Invalid option");
                sCheck.printUsage();
                continue;
            }
        }

    }

    private void printUsage() {
        System.out.println("Legal commands are: ");
        System.out.println("<p> to print the entire word tree");
        System.out.println("<!> to quit");
        System.out.println("<c> <word> to spell check this word");
        System.out.println("<a> <word> add word to tree");
    }
}