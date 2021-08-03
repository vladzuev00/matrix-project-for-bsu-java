package by.bsu.zuevvlad.sixthlab.logic.matrixcreator.exception;

public class MatrixCreatorException extends Exception
{
    public MatrixCreatorException()
    {
        super();
    }

    public MatrixCreatorException(final String description)
    {
        super(description);
    }

    public MatrixCreatorException(final Exception cause)
    {
        super(cause);
    }

    public MatrixCreatorException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
