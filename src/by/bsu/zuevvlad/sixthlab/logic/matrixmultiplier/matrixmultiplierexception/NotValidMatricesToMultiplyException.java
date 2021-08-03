package by.bsu.zuevvlad.sixthlab.logic.matrixmultiplier.matrixmultiplierexception;

public final class NotValidMatricesToMultiplyException extends MatrixMultiplierException
{
    public NotValidMatricesToMultiplyException()
    {
        super();
    }

    public NotValidMatricesToMultiplyException(final String description)
    {
        super(description);
    }

    public NotValidMatricesToMultiplyException(final Exception cause)
    {
        super(cause);
    }

    public NotValidMatricesToMultiplyException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
