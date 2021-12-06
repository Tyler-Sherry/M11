/**
 * Translator class takes in a TranslationMatrix object which allows the translation object
 * the ability to call the translateText method of the translation object.
 */

public class Translator
{
    TranslationMatrix translationMatrix;

    public Translator(TranslationMatrix m)
    {
        translationMatrix = m;
    }
}
