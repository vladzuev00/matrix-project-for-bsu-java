package by.bsu.zuevvlad.sixthlab.logic.matrixparser;

import by.bsu.zuevvlad.sixthlab.logic.matrixparser.exception.MatrixParsingException;
import by.bsu.zuevvlad.sixthlab.logic.validator.matrix.MatrixValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class MatrixParser
{
    public MatrixParser()
    {
        super();
    }

    public final List<List<String>> parseDescriptionOfMatrixOnDescriptionsOfElements(final String descriptionOfMatrix)
            throws MatrixParsingException
    {
        if(!MatrixParser.MATRIX_VALIDATOR.isValidDescriptionOfMatrix(descriptionOfMatrix))
        {
            throw new MatrixParsingException("Parsing given description of matrix on description of its matrix "
                    + "is impossible. Given description of matrix: " + descriptionOfMatrix + ".");
        }
        final List<String> descriptionsOfRowsOfMatrix = MatrixParser
                .findDescriptionsOfRowsOfMatrix(descriptionOfMatrix);
        return MatrixParser.findDescriptionsOfElementsOfMatrix(descriptionsOfRowsOfMatrix);
    }

    private static final MatrixValidator MATRIX_VALIDATOR = new MatrixValidator();

    private static List<String> findDescriptionsOfRowsOfMatrix(final String descriptionOfMatrix)
    {
        final List<String> descriptionsOfRowsOfMatrix = new ArrayList<String>();
        final StringTokenizer stringTokenizer = new StringTokenizer(descriptionOfMatrix,
                MatrixParser.DELIMITER_OF_DESCRIPTIONS_OF_ROWS);
        String currentDescriptionOfRow;
        while(stringTokenizer.hasMoreTokens())
        {
            currentDescriptionOfRow = stringTokenizer.nextToken();
            descriptionsOfRowsOfMatrix.add(currentDescriptionOfRow);
        }
        return descriptionsOfRowsOfMatrix;
    }

    private static final String DELIMITER_OF_DESCRIPTIONS_OF_ROWS = "\r\n";

    private static List<List<String>> findDescriptionsOfElementsOfMatrix(final List<String> descriptionsOfRowsOfMatrix)
    {
        final List<List<String>> descriptionsOfElementsOfMatrix = new ArrayList<List<String>>();
        List<String> descriptionsOfElementsOfCurrentRow;
        StringTokenizer stringTokenizer;
        for(final String currentDescriptionOfRow : descriptionsOfRowsOfMatrix)
        {
            descriptionsOfElementsOfCurrentRow = new ArrayList<>();
            stringTokenizer = new StringTokenizer(currentDescriptionOfRow,
                    MatrixParser.DELIMITER_OF_DESCRIPTIONS_OF_ELEMENTS);
            while(stringTokenizer.hasMoreElements())
            {
                descriptionsOfElementsOfCurrentRow.add(stringTokenizer.nextToken());
            }
            descriptionsOfElementsOfMatrix.add(descriptionsOfElementsOfCurrentRow);
        }
        return descriptionsOfElementsOfMatrix;
    }

    private static final String DELIMITER_OF_DESCRIPTIONS_OF_ELEMENTS = " ";
}
