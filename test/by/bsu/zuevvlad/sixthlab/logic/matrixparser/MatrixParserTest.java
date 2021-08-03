package by.bsu.zuevvlad.sixthlab.logic.matrixparser;

import by.bsu.zuevvlad.sixthlab.logic.matrixparser.exception.MatrixParsingException;
import by.bsu.zuevvlad.sixthlab.logic.validator.matrix.MatrixValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public final class MatrixParserTest
{
    public MatrixParserTest()
    {
        super();
    }

    @Test
    public final void descriptionOfMatrixShouldBeParsed()
            throws MatrixParsingException
    {
        final String parsedDescriptionOfMatrix = "1 2\r\n"
                                               + "-11 -22\r\n";
        final List<List<String>> expectedDescriptionsOfElementsOfMatrix = new ArrayList<List<String>>()
        {
            {
                this.add(new ArrayList<String>()
                {
                    {
                        this.add("1");
                        this.add("2");
                    }
                });

                this.add(new ArrayList<String>()
                {
                    {
                        this.add("-11");
                        this.add("-22");
                    }
                });
            }
        };
        final MatrixParser matrixParser = new MatrixParser();
        final List<List<String>> actualDescriptionsOfElementsOfMatrix
                = matrixParser.parseDescriptionOfMatrixOnDescriptionsOfElements(parsedDescriptionOfMatrix);
        Assert.assertEquals(actualDescriptionsOfElementsOfMatrix, expectedDescriptionsOfElementsOfMatrix);
    }

    @Test(expectedExceptions = MatrixParsingException.class)
    public final void descriptionOfMatrixShouldNotBeParsed()
            throws MatrixParsingException
    {
        final String parsedDescriptionOfMatrix = "1 2\r\n"
                                               + "-11 -22";
        final MatrixParser matrixParser = new MatrixParser();
        matrixParser.parseDescriptionOfMatrixOnDescriptionsOfElements(parsedDescriptionOfMatrix);
    }
}
