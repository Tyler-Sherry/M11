import java.io.*;
import java.util.Arrays;

/**
 * Caesar class that implements the translation matrix and performs a caesar cipher
 * @author Tyler Sherry
 */
public class Caesar implements TranslationMatrix
{
    /**
     * A string array to pass into the different ciphers
     *
     * @param words
     * @return String of cipher words
     */
    @Override
    public String translate(String[] words) throws IOException
    {
        //The text will be broken into individual characters and then formed into a string return value
        String cipherText = "";
        String individualWords = words[0];
        char[] characters = individualWords.toCharArray();

        //The below for loop does the cipher translation
        for (int i = 0; i < characters.length; i++)
        {
            char ch = characters[i];
            if (Character.isLetter(ch))
            {
                if (Character.isLowerCase(ch))
                {
                    char newCharacter = (char)(ch - 3);
                    if (newCharacter < 'a')
                    {
                        cipherText += (char)(ch + (26 - 3));
                    }
                    else
                    {
                        cipherText += newCharacter;
                    }
                }
                else if (Character.isUpperCase(ch))
                {
                    char newCharacter = (char)(ch - 3);
                    if (newCharacter < 'A')
                    {
                        cipherText += (char)(ch + (26 - 3));
                    }
                    else
                    {
                        cipherText += newCharacter;
                    }
                }
            }
            else
            {
                cipherText += ch;
            }
        }

        //Write the execution of the cipher to the output file and console
        System.out.println(cipherText);
        File f = new File("C:\\Users\\Tyler\\Desktop\\SWENG311\\M11\\Resources\\caesar_execution.txt");
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF(cipherText);
        return cipherText;
    }
}
