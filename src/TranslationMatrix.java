import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Translation Matrix interface that is implemented by the Caesar, Vigenere, and Substitution classes
 * @author Tyler Sherry
 */
public interface TranslationMatrix
{
    /**
     * A string array to pass into the different ciphers
     * @param words
     * @return String of cipher words
     */
    public String translate(String[] words) throws IOException;
}
