package by.bsu.zuevvlad.sixthlab.logic.matrixcreator.exception;

public class MatrixCreatingException extends MatrixCreatorException
{
    public MatrixCreatingException()
    {
        super();
    }

    public MatrixCreatingException(final String description)
    {
        super(description);
    }

    public MatrixCreatingException(final Exception cause)
    {
        super(cause);
    }

    public MatrixCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
