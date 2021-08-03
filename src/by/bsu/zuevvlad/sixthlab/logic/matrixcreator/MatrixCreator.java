package by.bsu.zuevvlad.sixthlab.logic.matrixcreator;

import by.bsu.zuevvlad.sixthlab.entity.matrix.Matrix;
import by.bsu.zuevvlad.sixthlab.logic.matrixcreator.exception.MatrixCreatingException;
import by.bsu.zuevvlad.sixthlab.logic.validator.matrix.MatrixValidator;

import java.util.List;

public final class MatrixCreator
{
    public MatrixCreator()
    {
        super();
    }

    public final Matrix<Double> createMatrix(
            final List<List<String>> descriptionsOfElementsOfMatrix)
            throws MatrixCreatingException
    {
        if(!MatrixCreator.MATRIX_VALIDATOR.areValidDescriptionsOfElementsOfMatrix(descriptionsOfElementsOfMatrix))
        {
            throw new MatrixCreatingException("Impossible to create matrix with given not valid descriptions "
                    + "of elements of matrix: " + descriptionsOfElementsOfMatrix + ".");
        }
        final int amountOfRowsOfMatrix = descriptionsOfElementsOfMatrix.size();
        final int amountOfColumnsOfMatrix = descriptionsOfElementsOfMatrix.get(0).size();
        final Double[][] elementsOfMatrix = new Double[amountOfRowsOfMatrix][amountOfColumnsOfMatrix];
        String currentDescriptionOfElement;
        for(int i = 0; i < amountOfRowsOfMatrix; i++)
        {
            for(int j = 0; j < amountOfColumnsOfMatrix; j++)
            {
                currentDescriptionOfElement = descriptionsOfElementsOfMatrix.get(i).get(j);
                elementsOfMatrix[i][j] = Double.valueOf(currentDescriptionOfElement);
            }
        }
        return new Matrix<Double>(elementsOfMatrix);
    }

    private static final MatrixValidator MATRIX_VALIDATOR = new MatrixValidator();
}
