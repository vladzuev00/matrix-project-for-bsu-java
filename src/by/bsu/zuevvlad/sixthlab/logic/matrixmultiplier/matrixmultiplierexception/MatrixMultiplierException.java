package by.bsu.zuevvlad.sixthlab.logic.matrixmultiplier.matrixmultiplierexception;

public class MatrixMultiplierException extends RuntimeException
{
    public MatrixMultiplierException()
    {
        super();
    }

    public MatrixMultiplierException(final String description)
    {
        super(description);
    }

    public MatrixMultiplierException(final Exception cause)
    {
        super(cause);
    }

    public MatrixMultiplierException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
