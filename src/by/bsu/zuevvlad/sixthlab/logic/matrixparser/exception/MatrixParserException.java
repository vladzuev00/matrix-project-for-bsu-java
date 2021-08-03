package by.bsu.zuevvlad.sixthlab.logic.matrixparser.exception;

public class MatrixParserException extends Exception
{
    public MatrixParserException()
    {
        super();
    }

    public MatrixParserException(final String description)
    {
        super(description);
    }

    public MatrixParserException(final Exception cause)
    {
        super(cause);
    }

    public MatrixParserException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
