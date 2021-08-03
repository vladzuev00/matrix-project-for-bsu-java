package by.bsu.zuevvlad.sixthlab.entity.matrix.exception;

public final class MatrixAccessException extends MatrixException
{
    public MatrixAccessException()
    {
        super();
    }

    public MatrixAccessException(final String description)
    {
        super(description);
    }

    public MatrixAccessException(final Exception cause)
    {
        super(cause);
    }

    public MatrixAccessException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
