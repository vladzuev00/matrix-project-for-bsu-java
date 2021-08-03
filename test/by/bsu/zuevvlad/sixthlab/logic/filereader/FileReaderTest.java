package by.bsu.zuevvlad.sixthlab.logic.filereader;

import by.bsu.zuevvlad.sixthlab.logic.filereader.exception.FileReadingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;

public final class FileReaderTest
{
    public FileReaderTest()
    {
        super();
    }

    @BeforeClass
    public final void writeContentInFile()
            throws IOException
    {
        try(final FileOutputStream fileOutputStream = new FileOutputStream(FileReaderTest.READ_FILE);
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream))
        {
            for(final char writtenCharacter : FileReaderTest.CONTENT_WRITING_IN_FILE.toCharArray())
            {
                bufferedOutputStream.write(writtenCharacter);
            }
        }
    }

    private static final String PATH_OF_READ_FILE_FROM_CONTENT_ROOT = "data\\fortest\\fortestreader";
    private static final File READ_FILE = new File(FileReaderTest.PATH_OF_READ_FILE_FROM_CONTENT_ROOT);
    private static final String CONTENT_WRITING_IN_FILE = "content for testing";

    @Test
    public final void contentFromFileShouldBeRead()
            throws FileReadingException
    {
        final FileReader fileReader = new FileReader();
        final String expectedReadContentOfFile = FileReaderTest.CONTENT_WRITING_IN_FILE;
        final String actualReadContentOfFile = fileReader.read(FileReaderTest.READ_FILE);
        Assert.assertEquals(actualReadContentOfFile, expectedReadContentOfFile);
    }

    @Test(expectedExceptions = FileReadingException.class)
    public final void contentFromFileShouldNotBeRead()
            throws FileReadingException
    {
        final FileReader fileReader = new FileReader();
        fileReader.read(FileReaderTest.NOT_EXISTING_FILE);
    }

    private static final String PATH_OF_READ_NOT_EXISTING_FILE = "data\\fortest\\notexistingfile";
    private static final File NOT_EXISTING_FILE = new File(FileReaderTest.PATH_OF_READ_NOT_EXISTING_FILE);
}
