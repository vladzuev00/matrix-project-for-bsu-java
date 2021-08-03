package by.bsu.zuevvlad.sixthlab.logic.validator.integerelementsgenerator;

import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.IntegerElementsGenerator;

public final class IntegerElementsGeneratorValidator
{
    public IntegerElementsGeneratorValidator()
    {
        super();
    }

    public final boolean areValidBordersOfGeneration(final int researchMinimalBorderOfGeneration,
                                                     final int researchMaximalBorderOfGeneration)
    {
        return researchMinimalBorderOfGeneration <= researchMaximalBorderOfGeneration;
    }

    public final boolean isValidMinimalBorderOfGeneration(final int researchMinimalBorderOfGeneration,
                                                          final IntegerElementsGenerator integerElementsGenerator)
    {
        return researchMinimalBorderOfGeneration <= integerElementsGenerator.getMaximalBorderOfGeneration();
    }

    public final boolean isValidMaximalBorderOfGeneration(final int researchMaximalBorderOfGeneration,
                                                          final IntegerElementsGenerator integerElementsGenerator)
    {
        return researchMaximalBorderOfGeneration >= integerElementsGenerator.getMinimalBorderOfGeneration();
    }

    public final boolean isValidAmountOfGeneratedElements(final int researchAmountOfGeneratedElements)
    {
        return IntegerElementsGeneratorValidator.MINIMAL_ALLOWABLE_AMOUNT_OF_GENERATED_ELEMENTS <= researchAmountOfGeneratedElements
                && researchAmountOfGeneratedElements <= IntegerElementsGeneratorValidator.MAXIMAL_ALLOWABLE_AMOUNT_OF_GENERATED_ELEMENTS;
    }

    private static final int MINIMAL_ALLOWABLE_AMOUNT_OF_GENERATED_ELEMENTS = 1;
    private static final int MAXIMAL_ALLOWABLE_AMOUNT_OF_GENERATED_ELEMENTS = 99999999;

    public final boolean isValidAmountOfRowsOfGeneratedTwoDimensionalArray(final int researchAmountOfRows)
    {
        return IntegerElementsGeneratorValidator.MINIMAL_ALLOWABLE_AMOUNT_OF_ROWS_OF_GENERATED_TWO_DIMENSIONAL_ARRAY <= researchAmountOfRows
                && researchAmountOfRows <= IntegerElementsGeneratorValidator.MAXIMAL_ALLOWABLE_AMOUNT_OF_ROWS_OF_GENERATED_TWO_DIMENSIONAL_ARRAY;
    }

    private static final int MINIMAL_ALLOWABLE_AMOUNT_OF_ROWS_OF_GENERATED_TWO_DIMENSIONAL_ARRAY = 1;
    private static final int MAXIMAL_ALLOWABLE_AMOUNT_OF_ROWS_OF_GENERATED_TWO_DIMENSIONAL_ARRAY = 9999;

    public final boolean isValidAmountOfColumnsOfGeneratedTwoDimensionalArray(final int researchAmountOfColumns)
    {
        return IntegerElementsGeneratorValidator.MINIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS_OF_GENERATED_TWO_DIMENSIONAL_ARRAY <= researchAmountOfColumns
                && researchAmountOfColumns <= IntegerElementsGeneratorValidator.MAXIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS_OF_GENERATED_TWO_DIMENSIONAL_ARRAY;
    }

    private static final int MINIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS_OF_GENERATED_TWO_DIMENSIONAL_ARRAY = 1;
    private static final int MAXIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS_OF_GENERATED_TWO_DIMENSIONAL_ARRAY = 9999;
}
