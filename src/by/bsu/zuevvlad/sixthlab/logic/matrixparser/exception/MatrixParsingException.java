package by.bsu.zuevvlad.sixthlab.logic.matrixparser.exception;

public final class MatrixParsingException extends MatrixParserException
{
    public MatrixParsingException()
    {
        super();
    }

    public MatrixParsingException(final String description)
    {
        super(description);
    }

    public MatrixParsingException(final Exception cause)
    {
        super(cause);
    }

    public MatrixParsingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
