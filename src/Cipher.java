import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cipher class serves as the main for the program.
 * The class asks the user which cipher they would like to use and then instructs them
 * to enter a file path to the text to be translated.  The main then calls the translateText
 * method of the Translator class which outputs to either caesar_execution.txt, substitution_execution.txt,
 * or vigenere_execution.txt files.  The loop ends when the filepath entered is "quit."
 *
 * @author Tyler Sherry
 */
public class Cipher
{
    public static void main(String[] args) throws IOException
    {
        Scanner scnr = new Scanner(System.in);
        String userEntry;
        String userEnteredFilePath;
        Translator translator;

        ArrayList<String> caesarTextArrayList = new ArrayList<String>();
        String[] caesarStringArray;
        Caesar caesar = new Caesar();

        ArrayList<String> substitutionTextArrayList = new ArrayList<String>();
        String[] substitutionStringArray;
        Substitution substitution = new Substitution();

        ArrayList<String> vigenereTextArrayList = new ArrayList<String>();
        String[] vigenereStringArray;
        Vigenere vigenere = new Vigenere();

        System.out.println("Which cipher would you like to use? Caesar, Substitution, or Vigenere");

        userEntry = scnr.nextLine();


            if (userEntry.equals("Caesar") || userEntry.equals("caesar"))
            {
                //Take in file path of text to be translated until user enters "quit."
                translator = new Translator(caesar);
                System.out.println("Entering the Caesar cipher.");
                System.out.println("Enter in the file path you want to be ciphered and \"quit\" when you are finished to cipher the text");
                userEnteredFilePath = scnr.nextLine();

                while (!userEnteredFilePath.equals("quit"))
                {
                    //Read in all the string information from the file here
                    File file = new File(userEnteredFilePath);
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String stringFromFile;
                    while((stringFromFile = br.readLine()) != null)
                    {
                        caesarTextArrayList.add(stringFromFile);
                    }
                    caesarStringArray = new String[caesarTextArrayList.size()];

                    caesarTextArrayList.toArray(caesarStringArray);


                    translator.translationMatrix.translate(caesarStringArray);

                    System.out.println("What is the next file");
                    userEnteredFilePath = scnr.nextLine();
                };
            }


            if(userEntry.equals("Substitution") || userEntry.equals("substitution"))
            {
                //Take in file path of text to be translated until user enters "quit."
                translator = new Translator(substitution);
                System.out.println("Entering the Substitution cipher.");
                System.out.println("Enter in the file path you want to be ciphered and \"quit\" when you are finished to cipher the text");
                userEnteredFilePath = scnr.nextLine();

                while (!userEnteredFilePath.equals("quit"))
                {
                    //Read in all the string information from the file here
                    File file = new File(userEnteredFilePath);
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String stringFromFile;
                    while((stringFromFile = br.readLine()) != null)
                    {
                        substitutionTextArrayList.add(stringFromFile);
                    }
                    substitutionStringArray = new String[substitutionTextArrayList.size()];

                    substitutionTextArrayList.toArray(substitutionStringArray);


                    translator.translationMatrix.translate(substitutionStringArray);

                    System.out.println("What is the next file");
                    userEnteredFilePath = scnr.nextLine();
                };
            }


            if(userEntry.equals("Vigenere") || userEntry.equals("vigenere"))
            {
                //Take in file path of text to be translated until user enters "quit."
                System.out.println("Entering the Vigenere cipher.");
                System.out.println("Enter in the file path you want to be ciphered and \"quit\" when you are finished to cipher the text");
                userEnteredFilePath = scnr.nextLine();

                while (!userEnteredFilePath.equals("quit"))
                {
                    //Read in all the string information from the file here
                    File file = new File(userEnteredFilePath);
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String stringFromFile;
                    while((stringFromFile = br.readLine()) != null)
                    {
                        vigenereTextArrayList.add(stringFromFile);
                    }
                    vigenereStringArray = new String[vigenereTextArrayList.size()];

                    vigenereTextArrayList.toArray(vigenereStringArray);

                    System.out.println("What is the key for vigenere cipher: ");
                    String vigenereKey = scnr.nextLine();
                    vigenere.key = vigenereKey;
                    translator = new Translator(vigenere);


                    translator.translationMatrix.translate(vigenereStringArray);

                    System.out.println("What is the next file");
                    userEnteredFilePath = scnr.nextLine();
                };
            }
    }
}
