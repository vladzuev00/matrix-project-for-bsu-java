package by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator;

import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.exception.IntegerElementsGeneratorCreatingException;
import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.exception.IntegerElementsGeneratorGenerationException;
import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.exception.IntegerElementsGeneratorModificationException;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class IntegerElementsGeneratorTest
{
    public IntegerElementsGeneratorTest()
    {
        super();
    }

    @Test
    public final void integerElementsGeneratorShouldBeCreated()
    {
        final int minimalBorderOfGeneration = 10;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, maximalBorderOfGeneration);
        final int expectedMinimalBorderOfGeneration = minimalBorderOfGeneration;
        final int expectedMaximalBorderOfGeneration = maximalBorderOfGeneration;
        final int actualMinimalBorderOfGeneration = integerElementsGenerator.getMinimalBorderOfGeneration();
        final int actualMaximalBorderOfGeneration = integerElementsGenerator.getMaximalBorderOfGeneration();
        Assert.assertTrue(actualMinimalBorderOfGeneration == expectedMinimalBorderOfGeneration
                && actualMaximalBorderOfGeneration == expectedMaximalBorderOfGeneration);
    }

    @Test(expectedExceptions = IntegerElementsGeneratorCreatingException.class)
    public final void integerElementsGeneratorShouldNotBeCreated()
    {
        final int minimalBorderOfGeneration = 10;
        final int maximalBorderOfGeneration = 9;
        new IntegerElementsGenerator(minimalBorderOfGeneration, maximalBorderOfGeneration);
    }

    @Test
    public final void newMinimalBorderOfGenerationShouldBeSet()
    {
        final int initialMinimalBorderOfGeneration = 10;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(initialMinimalBorderOfGeneration, maximalBorderOfGeneration);
        final int newMinimalBorderOfGeneration = initialMinimalBorderOfGeneration / 2;
        integerElementsGenerator.setMinimalBorderOfGeneration(newMinimalBorderOfGeneration);
        final int expectedMinimalBorderOfGeneration = newMinimalBorderOfGeneration;
        final int actualMinimalBorderOfGeneration = integerElementsGenerator.getMinimalBorderOfGeneration();
        Assert.assertEquals(actualMinimalBorderOfGeneration, expectedMinimalBorderOfGeneration);
    }

    @Test(expectedExceptions = IntegerElementsGeneratorModificationException.class)
    public final void newMinimalBorderOfGenerationShouldNotBeSet()
    {
        final int initialMinimalBorderOfGeneration = 10;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(initialMinimalBorderOfGeneration, maximalBorderOfGeneration);
        final int newMinimalBorderOfGeneration = maximalBorderOfGeneration + 1;
        integerElementsGenerator.setMinimalBorderOfGeneration(newMinimalBorderOfGeneration);
    }

    @Test
    public final void minimalBorderOfGenerationShouldBeGot()
    {
        final int minimalBorderOfGeneration = 5;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, maximalBorderOfGeneration);
        final int expectedMinimalBorderOfGeneration = minimalBorderOfGeneration;
        final int actualMinimalBorderOfGeneration = integerElementsGenerator.getMinimalBorderOfGeneration();
        Assert.assertEquals(actualMinimalBorderOfGeneration, expectedMinimalBorderOfGeneration);
    }

    @Test
    public final void maximalBorderOfGenerationShouldBeSet()
    {
        final int minimalBorderOfGeneration = 10;
        final int initialMaximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, initialMaximalBorderOfGeneration);
        final int newMaximalBorderOfGeneration = initialMaximalBorderOfGeneration * 2;
        integerElementsGenerator.setMaximalBorderOfGeneration(newMaximalBorderOfGeneration);
        final int expectedMaximalBorderOfGeneration = newMaximalBorderOfGeneration;
        final int actualMaximalBorderOfGeneration = integerElementsGenerator.getMaximalBorderOfGeneration();
        Assert.assertEquals(actualMaximalBorderOfGeneration, expectedMaximalBorderOfGeneration);
    }

    @Test(expectedExceptions = IntegerElementsGeneratorModificationException.class)
    public final void maximalBorderOfGenerationShouldNotBeSet()
    {
        final int minimalBorderOfGeneration = 10;
        final int initialMaximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, initialMaximalBorderOfGeneration);
        final int newMaximalBorderOfGeneration = minimalBorderOfGeneration - 1;
        integerElementsGenerator.setMaximalBorderOfGeneration(newMaximalBorderOfGeneration);
    }

    @Test
    public final void maximalBorderOfGenerationShouldBeGot()
    {
        final int minimalBorderOfGeneration = 5;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, maximalBorderOfGeneration);
        final int expectedMaximalBorderOfGeneration = maximalBorderOfGeneration;
        final int actualMaximalBorderOfGeneration = integerElementsGenerator.getMaximalBorderOfGeneration();
        Assert.assertEquals(actualMaximalBorderOfGeneration, expectedMaximalBorderOfGeneration);
    }

    @Test
    public final void oneDimensionalArrayShouldBeGenerated()
    {
        final int minimalBorderOfGeneration = -10;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, maximalBorderOfGeneration);
        final int amountOfGeneratedElements = 30;
        final Integer[] generatedElements = integerElementsGenerator
                .generateOneDimensionalArray(amountOfGeneratedElements);
        final boolean testIsSuccess = generatedElements.length == amountOfGeneratedElements
                && IntegerElementsGeneratorTest.areElementsBelongsInterval(
                generatedElements, minimalBorderOfGeneration, maximalBorderOfGeneration);
        Assert.assertTrue(testIsSuccess);
    }

    private static boolean areElementsBelongsInterval(final Integer[] researchElements,
                                                      final int minimalBorderOfInterval,
                                                      final int maximalBorderOfInterval)
    {
        for(final Integer researchElement : researchElements)
        {
            if (!(minimalBorderOfInterval <= researchElement && researchElement <= maximalBorderOfInterval))
            {
                return false;
            }
        }
        return true;
    }

    @Test(expectedExceptions = IntegerElementsGeneratorGenerationException.class)
    public final void oneDimensionalArrayShouldNotBeGenerated()
    {
        final int minimalBorderOfGeneration = -10;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, maximalBorderOfGeneration);
        final int amountOfGeneratedElements = 0;
        integerElementsGenerator.generateOneDimensionalArray(amountOfGeneratedElements);
    }

    @Test
    public final void twoDimensionalArrayShouldBeGenerated()
    {
        final int minimalBorderOfGeneration = -10;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, maximalBorderOfGeneration);
        final int amountOfRows = 4;
        final int amountOfColumns = 5;
        final Integer[][] generatedElements = integerElementsGenerator
                .generateTwoDimensionalArray(amountOfRows, amountOfColumns);
        final boolean testIsSuccess = generatedElements.length == amountOfRows
                && generatedElements[0].length == amountOfColumns
                && IntegerElementsGeneratorTest.areElementsBelongsInterval(
                        generatedElements, minimalBorderOfGeneration, maximalBorderOfGeneration);
        Assert.assertTrue(testIsSuccess);
    }

    private static boolean areElementsBelongsInterval(final Integer[][] researchElements,
                                                      final int minimalBorderOfInterval,
                                                      final int maximalBorderOfInterval)
    {
        for(final Integer[] currentRow : researchElements)
        {
            for(final Integer researchElement : currentRow)
            {
                if (!(minimalBorderOfInterval <= researchElement && researchElement <= maximalBorderOfInterval))
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Test(expectedExceptions = IntegerElementsGeneratorGenerationException.class)
    public final void twoDimensionalArrayShouldNotBeGenerated()
    {
        final int minimalBorderOfGeneration = -10;
        final int maximalBorderOfGeneration = 10;
        final IntegerElementsGenerator integerElementsGenerator
                = new IntegerElementsGenerator(minimalBorderOfGeneration, maximalBorderOfGeneration);
        final int amountOfRows = 0;
        final int amountOfColumns = 5;
        integerElementsGenerator.generateTwoDimensionalArray(amountOfRows, amountOfColumns);
    }
}
