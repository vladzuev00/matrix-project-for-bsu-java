package by.bsu.zuevvlad.sixthlab.logic.filereader.exception;

public final class FileReadingException extends Exception
{
    public FileReadingException()
    {
        super();
    }

    public FileReadingException(final String description)
    {
        super(description);
    }

    public FileReadingException(final Exception cause)
    {
        super(cause);
    }

    public FileReadingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
