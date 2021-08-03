package by.bsu.zuevvlad.sixthlab.logic.matrixcreator;

import by.bsu.zuevvlad.sixthlab.entity.matrix.Matrix;
import by.bsu.zuevvlad.sixthlab.logic.matrixcreator.exception.MatrixCreatingException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public final class MatrixCreatorTest
{
    public MatrixCreatorTest()
    {
        super();
    }

    @Test
    public final void matrixShouldBeCreatedByGivenDescriptionsOfElements()
            throws MatrixCreatingException
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
        final MatrixCreator matrixCreator = new MatrixCreator();
        final Matrix<Double> actualCreatedMatrix = matrixCreator.createMatrix(descriptionsOfElementsOfMatrix);
        final Double[][] elementsOfExpectedCreatedMatrix = new Double[][]{
                {1., 11., 111.},
                {-1., -11., -111.}
        };
        final Matrix<Double> expectedCreatedMatrix = new Matrix<Double>(elementsOfExpectedCreatedMatrix);
        Assert.assertEquals(actualCreatedMatrix, expectedCreatedMatrix);
    }

    @Test(expectedExceptions = MatrixCreatingException.class)
    public final void matrixShouldNotBeCreatedByGivenDescriptionsOfElements()
            throws MatrixCreatingException
    {
        final List<List<String>> descriptionsOfElementsOfMatrix = new ArrayList<List<String>>()
        {
            {
                this.add(new ArrayList<String>()
                {
                    {
                        this.add("1");
                        this.add("11a");
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
        final MatrixCreator matrixCreator = new MatrixCreator();
        matrixCreator.createMatrix(descriptionsOfElementsOfMatrix);
    }
}
