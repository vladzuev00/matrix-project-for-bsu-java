package by.bsu.zuevvlad.sixthlab.entity.matrix;

import by.bsu.zuevvlad.sixthlab.entity.matrix.exception.MatrixAccessException;
import by.bsu.zuevvlad.sixthlab.entity.matrix.exception.MatrixCreatingException;
import by.bsu.zuevvlad.sixthlab.entity.matrix.exception.MatrixModificationException;
import by.bsu.zuevvlad.sixthlab.logic.validator.matrix.MatrixValidator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Matrix<TypeOfElement> implements Serializable, Iterable<TypeOfElement>
{
    private static final long serialVersionUID = 1L;

    private final Object[][] elements;

    public Matrix(final int amountOfRows, final int amountOfColumns)
    {
        super();
        if(      !(Matrix.MATRIX_VALIDATOR.isValidAmountOfRows(amountOfRows)
                && Matrix.MATRIX_VALIDATOR.isValidAmountOfColumns(amountOfColumns)))
        {
            throw new MatrixCreatingException("Impossible to create matrix with given amount of rows: "
                    + amountOfRows + ", amount of columns: " + amountOfColumns + ".");
        }
        this.elements = new Object[amountOfRows][amountOfColumns];
    }

    private static final MatrixValidator MATRIX_VALIDATOR = new MatrixValidator();

    public Matrix(final TypeOfElement[][] elements)
    {
        super();
        if(!Matrix.MATRIX_VALIDATOR.areValidElements(elements))
        {
            throw new MatrixCreatingException("Impossible to create matrix with given elements: "
                    + Arrays.toString(elements) + ".");
        }
        this.elements = elements;
    }

    public final int findAmountOfRows()
    {
        return this.elements.length;
    }

    public final int findAmountOfColumns()
    {
        return this.elements[0].length;
    }

    public final TypeOfElement findElement(final int indexOfRow, final int indexOfColumn)
    {
        if(      !(Matrix.MATRIX_VALIDATOR.isValidIndexOfRow(indexOfRow, this)
                && Matrix.MATRIX_VALIDATOR.isValidIndexOfColumn(indexOfColumn, this)))
        {
            throw new MatrixAccessException("Impossible to find element with given index of row: " + indexOfRow
                    + ", index of column: " + indexOfColumn + " in matrix: " + this + ".");
        }
        return (TypeOfElement)this.elements[indexOfRow][indexOfColumn];
    }

    public final void updateElement(final TypeOfElement newValue, final int indexOfRow, final int indexOfColumn)
    {
        if(      !(Matrix.MATRIX_VALIDATOR.isValidIndexOfRow(indexOfRow, this)
                && Matrix.MATRIX_VALIDATOR.isValidIndexOfColumn(indexOfColumn, this)))
        {
            throw new MatrixModificationException("Updating element with given index of row: " + indexOfRow
                    + ", index of column: " + indexOfColumn + " in matrix: " + this + " is impossible.");
        }
        this.elements[indexOfRow][indexOfColumn] = newValue;
    }

    @Override
    public final Iterator<TypeOfElement> iterator()
    {
        return this.new MatrixIterator();
    }

    private final class MatrixIterator implements Iterator<TypeOfElement>
    {
        private int indexOfRowOfNextElement;
        private int indexOfColumnOfNextElement;

        public MatrixIterator()
        {
            this.indexOfRowOfNextElement = MatrixIterator.INITIAL_VALUE_OF_INDEX_OF_ROW_OF_NEXT_ELEMENT;
            this.indexOfColumnOfNextElement = MatrixIterator.INITIAL_VALUE_OF_INDEX_OF_COLUMN_OF_NEXT_ELEMENT;
        }

        private static final int INITIAL_VALUE_OF_INDEX_OF_ROW_OF_NEXT_ELEMENT = 0;
        private static final int INITIAL_VALUE_OF_INDEX_OF_COLUMN_OF_NEXT_ELEMENT = 0;

        @Override
        public final boolean hasNext()
        {
            return   !(this.indexOfRowOfNextElement == Matrix.this.elements.length - 1
                    && this.indexOfColumnOfNextElement == Matrix.this.elements[0].length);
        }

        @Override
        public final TypeOfElement next()
        {
            if(this.indexOfColumnOfNextElement == Matrix.this.findAmountOfColumns())
            {
                this.indexOfRowOfNextElement++;
                this.indexOfColumnOfNextElement = 0;
            }
            if(this.indexOfRowOfNextElement == Matrix.this.elements.length)
            {
                throw new NoSuchElementException("Matrix doesn't have more elements.");
            }
            return (TypeOfElement)Matrix.this.elements[this.indexOfRowOfNextElement][this.indexOfColumnOfNextElement++];
        }
    }

    @Override
    public final boolean equals(final Object otherObject)
    {
        if(this == otherObject)
        {
            return true;
        }
        if(otherObject == null)
        {
            return false;
        }
        if(this.getClass() != otherObject.getClass())
        {
            return false;
        }
        final Matrix<TypeOfElement> other = (Matrix<TypeOfElement>)otherObject;
        return Arrays.deepEquals(this.elements, other.elements);
    }

    @Override
    public final int hashCode()
    {
        return Arrays.deepHashCode(this.elements);
    }

    @Override
    public final String toString()
    {
        return this.getClass().getSimpleName() + "[elements = " + Arrays.deepToString(this.elements) + "]";
    }
}
