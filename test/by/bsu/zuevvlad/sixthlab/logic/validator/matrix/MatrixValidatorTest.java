package by.bsu.zuevvlad.sixthlab.logic.validator.matrix;

import by.bsu.zuevvlad.sixthlab.entity.matrix.Matrix;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MatrixValidatorTest
{
    @Test
    public final void amountOfRowsShouldBeValid()
    {
        final int researchAmountOfRows = MatrixValidator.MAXIMAL_ALLOWABLE_AMOUNT_OF_ROWS;
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertTrue(matrixValidator.isValidAmountOfRows(researchAmountOfRows));
    }

    @Test
    public final void amountOfRowsShouldNotBeValid()
    {
        final int researchAmountOfRows = MatrixValidator.MINIMAL_ALLOWABLE_AMOUNT_OF_ROWS - 1;
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertFalse(matrixValidator.isValidAmountOfRows(researchAmountOfRows));
    }

    @Test
    public final void amountOfColumnsShouldBeValid()
    {
        final int researchAmountOfColumns = MatrixValidator.MINIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS;
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertTrue(matrixValidator.isValidAmountOfColumns(researchAmountOfColumns));
    }

    @Test
    public final void amountOfColumnsShouldNotBeValid()
    {
        final int researchAmountOfColumns = MatrixValidator.MINIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS - 1;
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertFalse(matrixValidator.isValidAmountOfColumns(researchAmountOfColumns));
    }

    @Test
    public final void elementsShouldBeValid()
    {
        final int amountOfRows = 4;
        final int amountOfColumns = 5;
        final Integer[][] researchElements = new Integer[amountOfRows][amountOfColumns];
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertTrue(matrixValidator.areValidElements(researchElements));
    }

    @Test
    public final void elementsShouldNotBeValid()
    {
        final int amountOfRows = 4;
        final Integer[][] researchElements = new Integer[amountOfRows][];
        for(int i = 0; i < amountOfRows; i++)
        {
            researchElements[i] = new Integer[i + 1];
        }
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertFalse(matrixValidator.areValidElements(researchElements));
    }

    @Test
    public final void indexOfRowShouldBeValid()
    {
        final int amountOfRows = 3;
        final int amountOfColumns = 4;
        final Object[][] elements = new Object[amountOfRows][amountOfColumns];
        final Matrix<Object> matrix = new Matrix<Object>(elements);
        final MatrixValidator matrixValidator = new MatrixValidator();
        final int researchIndexOfRow = amountOfRows - 1;
        Assert.assertTrue(matrixValidator.isValidIndexOfRow(researchIndexOfRow, matrix));
    }

    @Test
    public final void indexOfRowShouldNotBeValid()
    {
        final int amountOfRows = 3;
        final int amountOfColumns = 4;
        final Object[][] elements = new Object[amountOfRows][amountOfColumns];
        final Matrix<Object> matrix = new Matrix<Object>(elements);
        final MatrixValidator matrixValidator = new MatrixValidator();
        final int researchIndexOfRow = amountOfRows;
        Assert.assertFalse(matrixValidator.isValidIndexOfRow(researchIndexOfRow, matrix));
    }

    @Test
    public final void indexOfColumnShouldBeValid()
    {
        final int amountOfRows = 3;
        final int amountOfColumns = 4;
        final Object[][] elements = new Object[amountOfRows][amountOfColumns];
        final Matrix<Object> matrix = new Matrix<Object>(elements);
        final MatrixValidator matrixValidator = new MatrixValidator();
        final int researchIndexOfColumn = amountOfColumns - 1;
        Assert.assertTrue(matrixValidator.isValidIndexOfColumn(researchIndexOfColumn, matrix));
    }

    @Test
    public final void indexOfColumnShouldNotBeValid()
    {
        final int amountOfRows = 3;
        final int amountOfColumns = 4;
        final Object[][] elements = new Object[amountOfRows][amountOfColumns];
        final Matrix<Object> matrix = new Matrix<Object>(elements);
        final MatrixValidator matrixValidator = new MatrixValidator();
        final int researchIndexOfColumn = amountOfColumns;
        Assert.assertFalse(matrixValidator.isValidIndexOfColumn(researchIndexOfColumn, matrix));
    }

    @Test
    public final void matricesShouldBeValidToMultiply()
    {
        final int amountOfRowsOfFirstMatrix = 3;
        final int amountOfColumnsOfFirstMatrix = 4;
        final Matrix<Object> firstMatrix = new Matrix<Object>(amountOfRowsOfFirstMatrix, amountOfColumnsOfFirstMatrix);

        final int amountOfRowsOfSecondMatrix = 4;
        final int amountOfColumnsOfSecondMatrix = 5;
        final Matrix<Object> secondMatrix = new Matrix<Object>(
                amountOfRowsOfSecondMatrix, amountOfColumnsOfSecondMatrix);

        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertTrue(matrixValidator.areValidMatricesToMultiply(firstMatrix, secondMatrix));
    }

    @Test
    public final void matricesShouldNotBeValidToMultiply()
    {
        final int amountOfRowsOfFirstMatrix = 3;
        final int amountOfColumnsOfFirstMatrix = 4;
        final Matrix<Object> firstMatrix = new Matrix<Object>(amountOfRowsOfFirstMatrix, amountOfColumnsOfFirstMatrix);

        final int amountOfRowsOfSecondMatrix = 5;
        final int amountOfColumnsOfSecondMatrix = 5;
        final Matrix<Object> secondMatrix = new Matrix<Object>(
                amountOfRowsOfSecondMatrix, amountOfColumnsOfSecondMatrix);

        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertFalse(matrixValidator.areValidMatricesToMultiply(firstMatrix, secondMatrix));
    }

    @Test
    public final void descriptionOfMatrixShouldBeValid()
    {
        final String descriptionOfMatrix = "1 2 3 4 5\r\n"
                                         + "-1 -2 -3 -4 -5\r\n"
                                         + "11 22 -33 44 -121\r\n";
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertTrue(matrixValidator.isValidDescriptionOfMatrix(descriptionOfMatrix));
    }

    @Test
    public final void descriptionOfMatrixShouldNotBeValid()
    {
        final String descriptionOfMatrix = "1 2 3 4 5\r\n"
                + "-1-2 -3 -4 -5\r\n"
                + "11 22 -33 44 -121\r\n";
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertFalse(matrixValidator.isValidDescriptionOfMatrix(descriptionOfMatrix));
    }

    @Test
    public final void descriptionsOfElementsOfMatrixShouldBeValid()
    {
        final List<List<String>> descriptionsOfElementsOfMatrix = new ArrayList<List<String>>()
        {
            {
                this.add(new ArrayList<String>()
                {
                    {
                        this.add("1");
                        this.add("11");
                        this.add("111");
                    }
                });

                this.add(new ArrayList<String>()
                {
                    {
                        this.add("-1");
                        this.add("-11");
                        this.add("-111");
                    }
                });
            }
        };
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertTrue(matrixValidator.areValidDescriptionsOfElementsOfMatrix(descriptionsOfElementsOfMatrix));
    }

    @Test
    public final void descriptionsOfElementsOfMatrixShouldNotBeValid()
    {
        final List<List<String>> descriptionsOfElementsOfMatrix = new ArrayList<List<String>>()
        {
            {
                this.add(new ArrayList<String>()
                {
                    {
                        this.add("1");
                        this.add("11");
                    }
                });

                this.add(new ArrayList<String>()
                {
                    {
                        this.add("-1");
                        this.add("-11");
                        this.add("-111a");
                    }
                });
            }
        };
        final MatrixValidator matrixValidator = new MatrixValidator();
        Assert.assertFalse(matrixValidator.areValidDescriptionsOfElementsOfMatrix(descriptionsOfElementsOfMatrix));
    }
}
