package by.bsu.zuevvlad.sixthlab.entity.matrix;

import by.bsu.zuevvlad.sixthlab.entity.matrix.exception.MatrixAccessException;
import by.bsu.zuevvlad.sixthlab.entity.matrix.exception.MatrixCreatingException;
import by.bsu.zuevvlad.sixthlab.entity.matrix.exception.MatrixModificationException;
import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.IntegerElementsGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

public final class MatrixTest
{
    @Test
    public final void matrixShouldBeCreatedWithGivenAmountOfRowsAndColumns()
    {
        final int amountOfRows = 4;
        final int amountOfColumns = 5;
        final Matrix<Object> createdMatrix = new Matrix<Object>(amountOfRows, amountOfColumns);
        final int expectedAmountOfRows = amountOfRows;
        final int expectedAmountOfColumns = amountOfColumns;
        final int actualAmountOfRows = createdMatrix.findAmountOfRows();
        final int actualAmountOfColumns = createdMatrix.findAmountOfColumns();
        Assert.assertTrue(actualAmountOfRows == expectedAmountOfRows
                && actualAmountOfColumns == expectedAmountOfColumns);
    }

    @Test(expectedExceptions = MatrixCreatingException.class)
    public final void matrixShouldNotBeCreatedWithGivenAmountOfRowsAndColumns()
    {
        final int amountOfRows = 0;
        final int amountOfColumns = 4;
        new Matrix<Object>(amountOfRows, amountOfColumns);
    }

    @Test
    public final void matrixShouldBeCreatedWithGivenElements()
    {
        final int amountOfRows = 4;
        final int amountOfColumns = 5;
        final Integer[][] elements = new Integer[amountOfRows][amountOfColumns];
        final Matrix<Integer> createdMatrix = new Matrix<Integer>(elements);
        final int expectedAmountOfRows = amountOfRows;
        final int expectedAmountOfColumns = amountOfColumns;
        final int actualAmountOfRows = createdMatrix.findAmountOfRows();
        final int actualAmountOfColumns = createdMatrix.findAmountOfColumns();
        final boolean testIsSuccess = (actualAmountOfRows == expectedAmountOfRows
                && actualAmountOfColumns == expectedAmountOfColumns);
        Assert.assertTrue(testIsSuccess);
    }

    @Test(expectedExceptions = MatrixCreatingException.class)
    public final void matrixShouldNotBeCreatedWithGivenElements()
    {
        final int amountOfRows = 4;
        final Integer[][] elements = new Integer[amountOfRows][];
        for(int i = 0; i < amountOfRows; i++)
        {
            elements[i] = new Integer[i + 1];
        }
        new Matrix<Integer>(elements);
    }

    @Test
    public final void amountOfRowsOfMatrixShouldBeFound()
    {
        final int amountOfRows = 3;
        final int amountOfColumns = 4;
        final Integer[][] elements = new Integer[amountOfRows][amountOfColumns];
        final Matrix<Integer> matrix = new Matrix<Integer>(elements);
        final int expectedAmountOfRowsOfMatrix = amountOfRows;
        final int actualAmountOfRowsOfMatrix = matrix.findAmountOfRows();
        final boolean testIsSuccess = (actualAmountOfRowsOfMatrix == expectedAmountOfRowsOfMatrix);
        Assert.assertTrue(testIsSuccess);
    }

    @Test
    public final void amountOfColumnsOfMatrixShouldBeFound()
    {
        final int amountOfRows = 3;
        final int amountOfColumns = 4;
        final Integer[][] elements = new Integer[amountOfRows][amountOfColumns];
        final Matrix<Integer> matrix = new Matrix<Integer>(elements);
        final int expectedAmountOfColumnsOfMatrix = amountOfColumns;
        final int actualAmountOfColumnsOfMatrix = matrix.findAmountOfColumns();
        final boolean testIsSuccess = (actualAmountOfColumnsOfMatrix == expectedAmountOfColumnsOfMatrix);
        Assert.assertTrue(testIsSuccess);
    }

    @Test
    public final void elementShouldBeFound()
    {
        final int amountOfRowsOfMatrix = 5;
        final int amountOfColumnsOfMatrix = 5;
        final Integer[][] elementsOfMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfMatrix, amountOfColumnsOfMatrix);
        final Matrix<Integer> matrix = new Matrix<Integer>(elementsOfMatrix);
        final int indexOfRowOfFoundElement = amountOfRowsOfMatrix / 2;
        final int indexOfColumnOfFoundElement = amountOfColumnsOfMatrix / 2;
        final Integer expectedFoundElement = elementsOfMatrix[indexOfRowOfFoundElement][indexOfColumnOfFoundElement];
        final Integer actualFoundElement = matrix.findElement(indexOfRowOfFoundElement, indexOfColumnOfFoundElement);
        Assert.assertSame(actualFoundElement, expectedFoundElement);
    }

    private static final int MINIMAL_BORDER_OF_GENERATION = -10;
    private static final int MAXIMAL_BORDER_OF_GENERATION = 10;
    private static final IntegerElementsGenerator INTEGER_ELEMENTS_GENERATOR
            = new IntegerElementsGenerator(MatrixTest.MINIMAL_BORDER_OF_GENERATION,
                                           MatrixTest.MAXIMAL_BORDER_OF_GENERATION);

    @Test(expectedExceptions = MatrixAccessException.class)
    public final void elementShouldNotBeFound()
    {
        final int amountOfRowsOfMatrix = 5;
        final int amountOfColumnsOfMatrix = 5;
        final Integer[][] elementsOfMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfMatrix, amountOfColumnsOfMatrix);
        final Matrix<Integer> matrix = new Matrix<Integer>(elementsOfMatrix);
        final int indexOfRowOfFoundElement = amountOfRowsOfMatrix;
        final int indexOfColumnOfFoundElement = amountOfColumnsOfMatrix;
        matrix.findElement(indexOfRowOfFoundElement, indexOfColumnOfFoundElement);
    }

    @Test
    public final void elementShouldBeUpdated()
    {
        final int amountOfRowsOfMatrix = 5;
        final int amountOfColumnsOfMatrix = 5;
        final Integer[][] elementsOfMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfMatrix, amountOfColumnsOfMatrix);
        final Matrix<Integer> matrix = new Matrix<Integer>(elementsOfMatrix);
        final int indexOfRowOfUpdatedElement = amountOfRowsOfMatrix / 2;
        final int indexOfColumnOfUpdatedElement = amountOfColumnsOfMatrix / 2;
        final Integer newValueOfUpdatedElement
                = elementsOfMatrix[indexOfRowOfUpdatedElement][indexOfColumnOfUpdatedElement] + 1;
        matrix.updateElement(newValueOfUpdatedElement, indexOfRowOfUpdatedElement, indexOfColumnOfUpdatedElement);
        final Integer expectedValueOfUpdatedElement = newValueOfUpdatedElement;
        final Integer actualValueOfUpdatedElement = matrix
                .findElement(indexOfRowOfUpdatedElement, indexOfColumnOfUpdatedElement);
        Assert.assertSame(actualValueOfUpdatedElement, expectedValueOfUpdatedElement);
    }

    @Test(expectedExceptions = MatrixModificationException.class)
    public final void elementShouldNotBeUpdated()
    {
        final int amountOfRowsOfMatrix = 5;
        final int amountOfColumnsOfMatrix = 5;
        final Integer[][] elementsOfMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfMatrix, amountOfColumnsOfMatrix);
        final Matrix<Integer> matrix = new Matrix<Integer>(elementsOfMatrix);
        final int indexOfRowOfUpdatedElement = amountOfRowsOfMatrix;
        final int indexOfColumnOfUpdatedElement = amountOfColumnsOfMatrix;
        final int newValueOfUpdatedElement = 0;
        matrix.updateElement(newValueOfUpdatedElement, indexOfRowOfUpdatedElement, indexOfColumnOfUpdatedElement);
    }

    @Test
    public final void matrixShouldBeIterated()
    {
        final int amountOfRowsOfMatrix = 5;
        final int amountOfColumnsOfMatrix = 5;
        final Integer[][] elementsOfMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfMatrix, amountOfColumnsOfMatrix);
        final Matrix<Integer> matrix = new Matrix<Integer>(elementsOfMatrix);
        final Iterator<Integer> matrixIterator = matrix.iterator();
        Integer currentElementOfMatrix;
        for(int i = 0; i < amountOfRowsOfMatrix; i++)
        {
            for(int j = 0; j < amountOfColumnsOfMatrix; j++)
            {
                currentElementOfMatrix = matrixIterator.next();
                if(!currentElementOfMatrix.equals(elementsOfMatrix[i][j]))
                {
                    Assert.fail();
                }
            }
        }
        Assert.assertFalse(matrixIterator.hasNext());
    }

    @Test
    public final void matrixShouldBeEqual()
    {
        final int amountOfRows = 5;
        final int amountOfColumns = 5;
        final Integer[][] generatedElements = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRows, amountOfColumns);
        final Matrix<Integer> firstMatrix = new Matrix<Integer>(generatedElements);
        final Matrix<Integer> secondMatrix = new Matrix<Integer>(generatedElements);
        Assert.assertEquals(firstMatrix, secondMatrix);
    }

    @Test
    public final void matrixShouldNotBeEqual()
    {
        final int amountOfRowsOfFirstMatrix = 5;
        final int amountOfColumnsOfFirstMatrix = 5;
        final Integer[][] elementsOfFirstMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfFirstMatrix, amountOfColumnsOfFirstMatrix);
        final Matrix<Integer> firstMatrix = new Matrix<Integer>(elementsOfFirstMatrix);

        final int amountOfRowsOfSecondMatrix = amountOfRowsOfFirstMatrix + 1;
        final int amountOfColumnsOfSecondMatrix = amountOfColumnsOfFirstMatrix + 1;
        final Integer[][] elementsOfSecondMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfSecondMatrix, amountOfColumnsOfSecondMatrix);
        final Matrix<Integer> secondMatrix = new Matrix<Integer>(elementsOfSecondMatrix);

        Assert.assertNotEquals(firstMatrix, secondMatrix);
    }

    @Test
    public final void hashCodeOfMatrixShouldBeFound()
    {
        final int amountOfRowsOfMatrix = 5;
        final int amountOfColumnsOfMatrix = 5;
        final Integer[][] elementsOfMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfMatrix, amountOfColumnsOfMatrix);
        final Matrix<Integer> matrix = new Matrix<Integer>(elementsOfMatrix);
        final int expectedHashCodeOfMatrix = Arrays.deepHashCode(elementsOfMatrix);
        final int actualHashCodeOfMatrix = matrix.hashCode();
        Assert.assertEquals(actualHashCodeOfMatrix, expectedHashCodeOfMatrix);
    }

    @Test
    public final void matrixShouldBeTransformedToString()
    {
        final int amountOfRowsOfMatrix = 5;
        final int amountOfColumnsOfMatrix = 5;
        final Integer[][] elementsOfMatrix = MatrixTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfMatrix, amountOfColumnsOfMatrix);
        final Matrix<Integer> matrix = new Matrix<Integer>(elementsOfMatrix);
        final String expectedDescriptionOfMatrix = matrix.getClass().getSimpleName() + "[elements = "
                + Arrays.deepToString(elementsOfMatrix) + "]";
        final String actualDescriptionOfMatrix = matrix.toString();
        Assert.assertEquals(actualDescriptionOfMatrix, expectedDescriptionOfMatrix);
    }
}
