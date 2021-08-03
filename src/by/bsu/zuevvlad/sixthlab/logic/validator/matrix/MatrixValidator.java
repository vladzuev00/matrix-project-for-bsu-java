package by.bsu.zuevvlad.sixthlab.logic.validator.matrix;

import by.bsu.zuevvlad.sixthlab.entity.matrix.Matrix;

import java.util.List;

public final class MatrixValidator
{
    public MatrixValidator()
    {
        super();
    }

    public final boolean isValidAmountOfRows(final int researchAmountOfRows)
    {
        return     MatrixValidator.MINIMAL_ALLOWABLE_AMOUNT_OF_ROWS <= researchAmountOfRows
                && researchAmountOfRows <= MatrixValidator.MAXIMAL_ALLOWABLE_AMOUNT_OF_ROWS;
    }

    public static final int MINIMAL_ALLOWABLE_AMOUNT_OF_ROWS = 1;
    public static final int MAXIMAL_ALLOWABLE_AMOUNT_OF_ROWS = 9999;

    public final boolean isValidAmountOfColumns(final int researchAmountOfColumns)
    {
        return     MatrixValidator.MINIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS <= researchAmountOfColumns
                && researchAmountOfColumns <= MatrixValidator.MAXIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS;
    }

    public static final int MINIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS = 1;
    public static final int MAXIMAL_ALLOWABLE_AMOUNT_OF_COLUMNS = 9999;

    public final <TypeOfElement> boolean areValidElements(final TypeOfElement[][] researchElements)
    {
        if(      !(this.isValidAmountOfRows(researchElements.length)
                && this.isValidAmountOfColumns(researchElements[0].length)))
        {
            return false;
        }
        return this.<TypeOfElement>areAllRowsContainSameAmountOfElements(researchElements);
    }

    private final <TypeOfElement> boolean areAllRowsContainSameAmountOfElements(
            final TypeOfElement[][] researchElements)
    {
        final int amountOfElementsInFirstRow = researchElements[0].length;
        for(int i = 1; i < researchElements.length; i++)
        {
            if(researchElements[i].length != amountOfElementsInFirstRow)
            {
                return false;
            }
        }
        return true;
    }

    public final <TypeOfElement> boolean isValidIndexOfRow(final int researchIndexOfRow,
                                                           final Matrix<TypeOfElement> matrix)
    {
        return     MatrixValidator.MINIMAL_ALLOWABLE_INDEX_OF_ROW <= researchIndexOfRow
                && researchIndexOfRow < matrix.findAmountOfRows();
    }

    private static final int MINIMAL_ALLOWABLE_INDEX_OF_ROW = 0;

    public final <TypeOfElement> boolean isValidIndexOfColumn(final int researchIndexOfColumn,
                                                              final Matrix<TypeOfElement> matrix)
    {
        return     MatrixValidator.MINIMAL_ALLOWABLE_INDEX_OF_COLUMN <= researchIndexOfColumn
                && researchIndexOfColumn < matrix.findAmountOfColumns();
    }

    private static final int MINIMAL_ALLOWABLE_INDEX_OF_COLUMN = 0;

    public final <TypeOfElement> boolean areValidMatricesToMultiply(final Matrix<TypeOfElement> firstMatrix,
                                                                    final Matrix<TypeOfElement> secondMatrix)
    {
        return firstMatrix.findAmountOfColumns() == secondMatrix.findAmountOfRows();
    }

    public final boolean isValidDescriptionOfMatrix(final String researchDescriptionOfMatrix)
    {
        return researchDescriptionOfMatrix.matches(MatrixValidator.REGULAR_EXPRESSION_FOR_DESCRIPTION_OF_MATRIX);
    }

    private static final String REGULAR_EXPRESSION_FOR_DESCRIPTION_OF_MATRIX = "("
            + MatrixValidator.REGULAR_EXPRESSION_FOR_ELEMENT_OF_MATRIX + "\\s+)+";

    public final boolean areValidDescriptionsOfElementsOfMatrix(final List<List<String>> researchDescriptions)
    {
        if(!MatrixValidator.areAllRowsHaveEqualAmountsOfDescriptionsElements(researchDescriptions))
        {
            return false;
        }
        for(final List<String> currentRowOfDescriptions : researchDescriptions)
        {
            for(final String currentResearchElement : currentRowOfDescriptions)
            {
                if(!currentResearchElement.matches(MatrixValidator.REGULAR_EXPRESSION_FOR_ELEMENT_OF_MATRIX))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean areAllRowsHaveEqualAmountsOfDescriptionsElements(final List<List<String>> researchRows)
    {
        final int amountOfDescriptionsInFirstRow = researchRows.get(0).size();
        List<String> currentRow;
        for(int i = 1; i < researchRows.size(); i++)
        {
            currentRow = researchRows.get(i);
            if(currentRow.size() != amountOfDescriptionsInFirstRow)
            {
                return false;
            }
        }
        return true;
    }

    private static final String REGULAR_EXPRESSION_FOR_ELEMENT_OF_MATRIX = "-?\\d+";
}
