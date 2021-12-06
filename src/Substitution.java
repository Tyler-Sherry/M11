import java.io.*;

/**
 * Substitution class that implements the translation matrix and performs a substitution cipher
 * @author Tyler Sherry
 */
public class Substitution implements TranslationMatrix
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
        String substitutionText = "";
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
                    char newCharacter = (char)(ch + 13);
                    if (newCharacter > 'z')
                    {
                        int leftover = newCharacter - 90;
                        char newNewCharacter = (char)('a' + leftover - 1);
                        substitutionText += newNewCharacter;
                    }
                    else
                    {
                        substitutionText += newCharacter;
                    }
                }
                else if (Character.isUpperCase(ch))
                {
                    char newCharacter = (char)(ch + 13);
                    if (newCharacter > 'Z')
                    {
                        int leftover = newCharacter - 90;
                        char newNewCharacter = (char)('A' + leftover - 1);
                        substitutionText += newNewCharacter;
                    }
                    else
                    {
                        substitutionText += newCharacter;
                    }
                }
            }
            else
            {
                substitutionText += ch;
            }
        }

        //Write the execution of the cipher to the output file and console
        System.out.println(substitutionText);
        File f = new File("C:\\Users\\Tyler\\Desktop\\SWENG311\\M11\\Resources\\substitution_execution.txt");
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF(substitutionText);
        return substitutionText;
    }
}
