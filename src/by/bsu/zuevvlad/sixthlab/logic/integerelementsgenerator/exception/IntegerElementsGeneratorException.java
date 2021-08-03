package by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.exception;

public class IntegerElementsGeneratorException extends RuntimeException
{
    public IntegerElementsGeneratorException()
    {
        super();
    }

    public IntegerElementsGeneratorException(final String description)
    {
        super(description);
    }

    public IntegerElementsGeneratorException(final Exception cause)
    {
        super(cause);
    }

    public IntegerElementsGeneratorException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}
