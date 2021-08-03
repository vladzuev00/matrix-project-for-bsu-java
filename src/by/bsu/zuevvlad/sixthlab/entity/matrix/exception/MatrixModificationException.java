package by.bsu.zuevvlad.sixthlab.entity.matrix.exception;

public final class MatrixModificationException extends MatrixException
{
    public MatrixModificationException()
    {
        super();
    }

    public MatrixModificationException(final String description)
    {
        super(description);
    }

    public MatrixModificationException(final Exception cause)
    {
        super(cause);
    }

    public MatrixModificationException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
