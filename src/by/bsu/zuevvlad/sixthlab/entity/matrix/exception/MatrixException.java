package by.bsu.zuevvlad.sixthlab.entity.matrix.exception;

public class MatrixException extends RuntimeException
{
    public MatrixException()
    {
        super();
    }

    public MatrixException(final String description)
    {
        super(description);
    }

    public MatrixException(final Exception cause)
    {
        super(cause);
    }

    public MatrixException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
