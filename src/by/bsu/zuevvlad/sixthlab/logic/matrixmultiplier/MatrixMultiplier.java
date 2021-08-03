package by.bsu.zuevvlad.sixthlab.logic.matrixmultiplier;

import by.bsu.zuevvlad.sixthlab.entity.matrix.Matrix;
import by.bsu.zuevvlad.sixthlab.logic.matrixmultiplier.matrixmultiplierexception.NotValidMatricesToMultiplyException;
import by.bsu.zuevvlad.sixthlab.logic.validator.matrix.MatrixValidator;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class MatrixMultiplier
{
    private final ExecutorService executorService;

    public MatrixMultiplier()
    {
        super();
        this.executorService = Executors.newFixedThreadPool(MatrixMultiplier.findPreferredAmountRunningThreads());
    }

    private static int findPreferredAmountRunningThreads()
    {
        final int amountAvailableProcessors = Runtime.getRuntime().availableProcessors();
        return amountAvailableProcessors * 2;
    }

    public final <TypeOfElement extends Number> Matrix<Future<Double>> findMultiply(
            final Matrix<TypeOfElement> firstMatrix, final Matrix<TypeOfElement> secondMatrix)
    {
        if(!MatrixMultiplier.MATRIX_VALIDATOR.<TypeOfElement>areValidMatricesToMultiply(firstMatrix, secondMatrix))
        {
            throw new NotValidMatricesToMultiplyException("Impossible to multiply given matrices. First matrix: "
                    + firstMatrix + ", second matrix: " + secondMatrix + ".");
        }
        final int amountOfRowsOfMatrixOfMultiply = firstMatrix.findAmountOfRows();
        final int amountOfColumnsOfMatrixOfMultiply = secondMatrix.findAmountOfColumns();
        final Matrix<Future<Double>> matrixOfMultiply = new Matrix<Future<Double>>(
                amountOfRowsOfMatrixOfMultiply, amountOfColumnsOfMatrixOfMultiply);
        Future<Double> currentHolderOfElement;
        for(int i = 0; i < matrixOfMultiply.findAmountOfRows(); i++)
        {
            for(int j = 0; j < matrixOfMultiply.findAmountOfColumns(); j++)
            {
                currentHolderOfElement = this.executorService.submit(
                        new CalculatorOfElementOfMultiply<TypeOfElement>(i, j, firstMatrix, secondMatrix));
                matrixOfMultiply.updateElement(currentHolderOfElement, i, j);
            }
        }
        return matrixOfMultiply;
    }

    private static final MatrixValidator MATRIX_VALIDATOR = new MatrixValidator();

    private static final class CalculatorOfElementOfMultiply<TypeOfElement extends Number> implements Callable<Double>
    {
        private final int indexOfRowOfFoundElement;
        private final int indexOfColumnOfFoundElement;
        private final Matrix<TypeOfElement> firstMatrix;
        private final Matrix<TypeOfElement> secondMatrix;

        public CalculatorOfElementOfMultiply(final int indexOfRowOfFoundElement, final int indexOfColumnOfFoundElement,
                                             final Matrix<TypeOfElement> firstMatrix,
                                             final Matrix<TypeOfElement> secondMatrix)
        {
            this.indexOfRowOfFoundElement = indexOfRowOfFoundElement;
            this.indexOfColumnOfFoundElement = indexOfColumnOfFoundElement;
            this.firstMatrix = firstMatrix;
            this.secondMatrix = secondMatrix;
        }

        @Override
        public final Double call()
        {
            double valueOfFoundElement = 0;
            final int amountOfRowsOfSecondMatrix = this.secondMatrix.findAmountOfRows();
            for(int i = 0; i < amountOfRowsOfSecondMatrix; i++)
            {
                valueOfFoundElement += (this.firstMatrix.findElement(this.indexOfRowOfFoundElement, i).doubleValue()
                        * this.secondMatrix.findElement(i, this.indexOfColumnOfFoundElement).doubleValue());
            }
            return valueOfFoundElement;
        }
    }
}
