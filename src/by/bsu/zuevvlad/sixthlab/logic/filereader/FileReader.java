package by.bsu.zuevvlad.sixthlab.logic.filereader;

import by.bsu.zuevvlad.sixthlab.logic.filereader.exception.FileReadingException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileReader
{
    public FileReader()
    {
        super();
    }

    public final String read(final File readFile)
            throws FileReadingException
    {
        try(final FileInputStream fileInputStream = new FileInputStream(readFile);
            final BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream))
        {
            final StringBuilder contentOfFile = new StringBuilder();
            while(bufferedInputStream.available() != 0)
            {
                contentOfFile.append((char)bufferedInputStream.read());
            }
            return contentOfFile.toString();
        }
        catch (final IOException cause)
        {
            throw new FileReadingException(cause);
        }
    }
}
