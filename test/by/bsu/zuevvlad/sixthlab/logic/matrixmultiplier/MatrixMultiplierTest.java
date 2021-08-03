package by.bsu.zuevvlad.sixthlab.logic.matrixmultiplier;

import by.bsu.zuevvlad.sixthlab.entity.matrix.Matrix;
import by.bsu.zuevvlad.sixthlab.logic.integerelementsgenerator.IntegerElementsGenerator;
import by.bsu.zuevvlad.sixthlab.logic.matrixmultiplier.matrixmultiplierexception.NotValidMatricesToMultiplyException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class MatrixMultiplierTest
{
    public MatrixMultiplierTest()
    {
        super();
    }

    @Test
    public final void multiplyOfMatricesShouldBeFound()
            throws ExecutionException, InterruptedException
    {
        final int amountOfRowsOfFirstMatrix = 2;
        final int amountOfColumnsOfFirstMatrix = 3;
        final Integer[][] elementOfFirstMatrix
                = MatrixMultiplierTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfFirstMatrix, amountOfColumnsOfFirstMatrix);
        final Matrix<Integer> firstMatrix = new Matrix<Integer>(elementOfFirstMatrix);

        final int amountOfRowsOfSecondMatrix = 3;
        final int amountOfColumnsOfSecondMatrix = 3;
        final Integer[][] elementsOfSecondMatrix
                = MatrixMultiplierTest.INTEGER_ELEMENTS_GENERATOR.generateTwoDimensionalArray(
                        amountOfRowsOfSecondMatrix, amountOfColumnsOfSecondMatrix);
        final Matrix<Integer> secondMatrix = new Matrix<Integer>(elementsOfSecondMatrix);

        final MatrixMultiplier matrixMultiplier = new MatrixMultiplier();
        final Matrix<Future<Double>> actualMultiplyOfMatrices
                = matrixMultiplier.findMultiply(firstMatrix, secondMatrix);
        final Matrix<Double> expectedMultiplyOfMatrices = MatrixMultiplierTest.findMultiplyOfElementsOfMatrices(
                elementOfFirstMatrix, elementsOfSecondMatrix);

        Assert.assertTrue(MatrixMultiplierTest.areEquals(actualMultiplyOfMatrices, expectedMultiplyOfMatrices));
    }

    private static final int MINIMAL_BORDER_OF_GENERATION = -10;
    private static final int MAXIMAL_BORDER_OF_GENERATION = 10;
    private static final IntegerElementsGenerator INTEGER_ELEMENTS_GENERATOR
            = new IntegerElementsGenerator(MatrixMultiplierTest.MINIMAL_BORDER_OF_GENERATION,
                                           MatrixMultiplierTest.MAXIMAL_BORDER_OF_GENERATION);

    private static Matrix<Double> findMultiplyOfElementsOfMatrices(final Integer[][] firstElements,
                                                                   final Integer[][] secondElements)
    {
        final Double[][] elementsOfMultiply = new Double[firstElements.length][secondElements[0].length];
        for(int i = 0; i < elementsOfMultiply.length; i++)
        {
            for(int j = 0; j < elementsOfMultiply[0].length; j++)
            {
                elementsOfMultiply[i][j] = 0.;
                for(int k = 0; k < secondElements.length; k++)
                {
                    elementsOfMultiply[i][j] += (double)(firstElements[i][k] * secondElements[k][j]);
                }
            }
        }
        return new Matrix<Double>(elementsOfMultiply);
    }

    private static boolean areEquals(final Matrix<Future<Double>> firstMatrix,
                                     final Matrix<Double> secondMatrix)
            throws ExecutionException, InterruptedException
    {
        if(firstMatrix.findAmountOfRows() != secondMatrix.findAmountOfRows()
                || firstMatrix.findAmountOfColumns() != secondMatrix.findAmountOfColumns())
        {
            return false;
        }
        double currentElementOfFirstMatrix;
        double currentElementOfSecondMatrix;
        for(int i = 0; i < firstMatrix.findAmountOfRows(); i++)
        {
            for(int j = 0; j < firstMatrix.findAmountOfColumns(); j++)
            {
                currentElementOfFirstMatrix = firstMatrix.findElement(i, j).get();
                currentElementOfSecondMatrix = secondMatrix.findElement(i, j);
                if(Double.compare(currentElementOfFirstMatrix, currentElementOfSecondMatrix) != 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Test(expectedExceptions = NotValidMatricesToMultiplyException.class)
    public final void multiplyOfMatricesShouldNotBeFound()
    {
        final int amountOfRowsOfFirstMatrix = 3;
        final int amountOfColumnsOfFirstMatrix = 2;
        final Integer[][] elementOfFirstMatrix
                = MatrixMultiplierTest.INTEGER_ELEMENTS_GENERATOR
                .generateTwoDimensionalArray(amountOfRowsOfFirstMatrix, amountOfColumnsOfFirstMatrix);
        final Matrix<Integer> firstMatrix = new Matrix<Integer>(elementOfFirstMatrix);

        final int amountOfRowsOfSecondMatrix = 3;
        final int amountOfColumnsOfSecondMatrix = 3;
        final Integer[][] elementsOfSecondMatrix
                = MatrixMultiplierTest.INTEGER_ELEMENTS_GENERATOR.generateTwoDimensionalArray(
                amountOfRowsOfSecondMatrix, amountOfColumnsOfSecondMatrix);
        final Matrix<Integer> secondMatrix = new Matrix<Integer>(elementsOfSecondMatrix);

        final MatrixMultiplier matrixMultiplier = new MatrixMultiplier();
        matrixMultiplier.findMultiply(firstMatrix, secondMatrix);
    }
}
