import java.io.*;

/**
 * Vigenere class that implements the translation matrix and performs a vigenere cipher
 * @author Tyler Sherry
 */
public class Vigenere implements TranslationMatrix
{
    /**
     * A string array to pass into the different ciphers
     *
     * @param words - Passed in string array to be translated
     * @param key - String key that will be used in the vigenere cipher
     * @return String of cipher words
     */
    public String key;

    @Override
    public String translate(String[] words) throws IOException
    {
        String vigenereText = "";
        String individualWords = words[0];
        char[] characters = individualWords.toCharArray();
        char[] keyCharacters = this.key.toCharArray();
        char[] keyArray = new char[characters.length];

         /* generate a key array, using keyword in cyclic
            manner equal to the length of original message  */
        for (int i = 0, j = 0; i < characters.length; ++i, ++j)
        {
            if (j == keyCharacters.length)
            {
                j = 0;
            }
            keyArray[i] = Character.toUpperCase(keyCharacters[j]);
        }

        for (int i = 0; i < characters.length; i++)
        {

            if (Character.isLetter(characters[i]))
            {
                int letter = Math.abs(characters[i] - keyArray[i]);
                char ch = (char) letter;
                ch += 'A';
                vigenereText += ch;
            }
            else
            {
                vigenereText += characters[i];
            }
        }

        //Write the execution of the cipher to the output file and console
        System.out.println(vigenereText);
        File f = new File("C:\\Users\\Tyler\\Desktop\\SWENG311\\M11\\Resources\\vigenere_execution.txt");
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF(vigenereText);
        return vigenereText;
    }
}
