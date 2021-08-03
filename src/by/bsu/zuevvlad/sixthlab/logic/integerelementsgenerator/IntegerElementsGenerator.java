package by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator;

import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.exception.IntegerElementsGeneratorCreatingException;
import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.exception.IntegerElementsGeneratorGenerationException;
import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.exception.IntegerElementsGeneratorModificationException;
import by.bsu.zuevvlad.sixthlab.logic.validator.integerelementsgenerator.IntegerElementsGeneratorValidator;

public final class IntegerElementsGenerator
{
    private int minimalBorderOfGeneration;
    private int maximalBorderOfGeneration;

    public IntegerElementsGenerator(final int minimalBorderOfGeneration, final int maximalBorderOfGeneration)
    {
        if(!IntegerElementsGenerator.INTEGER_ELEMENTS_GENERATOR_VALIDATOR
                .areValidBordersOfGeneration(minimalBorderOfGeneration, maximalBorderOfGeneration))
        {
            throw new IntegerElementsGeneratorCreatingException("Impossible to create generator of integers with given "
                    + "minimal border of generation: " + minimalBorderOfGeneration + ", maximal border of generation "
                    + maximalBorderOfGeneration + ".");
        }
        this.minimalBorderOfGeneration = minimalBorderOfGeneration;
        this.maximalBorderOfGeneration = maximalBorderOfGeneration;
    }

    private static final IntegerElementsGeneratorValidator INTEGER_ELEMENTS_GENERATOR_VALIDATOR
            = new IntegerElementsGeneratorValidator();

    public final void setMinimalBorderOfGeneration(final int minimalBorderOfGeneration)
    {
        if(!IntegerElementsGenerator.INTEGER_ELEMENTS_GENERATOR_VALIDATOR
                .isValidMinimalBorderOfGeneration(minimalBorderOfGeneration, this))
        {
            throw new IntegerElementsGeneratorModificationException("Impossible to set given new not valid "
                    + "minimal border of generation: " + minimalBorderOfGeneration + ".");
        }
        this.minimalBorderOfGeneration = minimalBorderOfGeneration;
    }

    public final int getMinimalBorderOfGeneration()
    {
        return this.minimalBorderOfGeneration;
    }

    public final void setMaximalBorderOfGeneration(final int maximalBorderOfGeneration)
    {
        if(!IntegerElementsGenerator.INTEGER_ELEMENTS_GENERATOR_VALIDATOR
                .isValidMaximalBorderOfGeneration(maximalBorderOfGeneration, this))
        {
            throw new IntegerElementsGeneratorModificationException("Impossible to set given new not valid "
                    + "maximal border of generation: " + maximalBorderOfGeneration + ".");
        }
        this.maximalBorderOfGeneration = maximalBorderOfGeneration;
    }

    public final int getMaximalBorderOfGeneration()
    {
        return this.maximalBorderOfGeneration;
    }

    public final Integer[] generateOneDimensionalArray(final int amountOfGeneratedElements)
    {
        if(!IntegerElementsGenerator.INTEGER_ELEMENTS_GENERATOR_VALIDATOR
                .isValidAmountOfGeneratedElements(amountOfGeneratedElements))
        {
            throw new IntegerElementsGeneratorGenerationException("Impossible to generate " + amountOfGeneratedElements
                    + " elements.");
        }
        final Integer[] generatedElements = new Integer[amountOfGeneratedElements];
        for(int i = 0; i < amountOfGeneratedElements; i++)
        {
            generatedElements[i] = (int)(Math.random()
                    * (this.maximalBorderOfGeneration - minimalBorderOfGeneration + 1))
                    + this.minimalBorderOfGeneration;
        }
        return generatedElements;
    }

    public final Integer[][] generateTwoDimensionalArray(final int amountOfRows, final int amountOfColumns)
    {
        if(      !(IntegerElementsGenerator.INTEGER_ELEMENTS_GENERATOR_VALIDATOR.isValidAmountOfRowsOfGeneratedTwoDimensionalArray(amountOfRows)
                && IntegerElementsGenerator.INTEGER_ELEMENTS_GENERATOR_VALIDATOR.isValidAmountOfColumnsOfGeneratedTwoDimensionalArray(amountOfColumns)))
        {
            throw new IntegerElementsGeneratorGenerationException("Impossible to generate two dimensional array of "
                    + "integers with amount of rows: " + amountOfRows + ", amount of columns: " + amountOfColumns
                    + ".");
        }
        final Integer[][] generatedElements = new Integer[amountOfRows][];
        for(int i = 0; i < amountOfRows; i++)
        {
            generatedElements[i] = this.generateOneDimensionalArray(amountOfColumns);
        }
        return generatedElements;
    }
}
