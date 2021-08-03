package by.bsu.zuevvlad.sixthlab.entity.matrix.exception;

public final class MatrixCreatingException extends MatrixException
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
