package com.company;

public class ArrayVectorImpl implements ArrayVector {

    private double[] arrayVector;

    public ArrayVectorImpl() {
    }

    @Override
    public void set(double... elements) {
        this.arrayVector = elements;
    }

    @Override
    public double[] get() {
        return arrayVector;
    }

    @Override
    public ArrayVector clone() {
        ArrayVector arrayVectorClone = new ArrayVectorImpl();
        arrayVectorClone.set(arrayVector.clone());
        return arrayVectorClone;
    }

    public int getSize() {
        return arrayVector.length;
    }

    public void set(int index, double value) {
        double[] arrayVectorNew;
        if (index > arrayVector.length) {
            arrayVectorNew = new double[index + 1];
            arrayVectorNew[index] = value;
            System.arraycopy(arrayVector, 0, arrayVectorNew, 0, arrayVector.length);
            arrayVector = arrayVectorNew;
        } else {
            for (int i = 0; i < arrayVector.length; i++) {
                if (i == index) {
                    arrayVector[i] = value;
                }
            }
        }
    }

    public double get(int index) throws ArrayIndexOutOfBoundsException {
        double temp = 0;
        if (index > arrayVector.length) {
            throw new ArrayIndexOutOfBoundsException("index is greater than expected");
        } else {
            for (int i = 0; i < arrayVector.length; i++) {
                if (i == index) {
                    temp = arrayVector[i];
                }
            }
        }
        return temp;
    }

    public double getMax() {
        double max = 0;
        for (int i = 1; i < arrayVector.length; i++) {
            if (arrayVector[i] > max) {
                max = arrayVector[i];
            }
        }
        return max;
    }

    public double getMin() {
        double min = 0;
        for (int i = 1; i < arrayVector.length; i++) {
            if (arrayVector[i] < min) {
                min = arrayVector[i];
            }
        }
        return min;
    }

    public void sortAscending() {
        double temp = 0;
        for (int i = 0; i < arrayVector.length; i++) {
            for (int j = 0; j < arrayVector.length - 1; j++) {
                if (arrayVector[j] > arrayVector[j + 1]) {
                    temp = arrayVector[j + 1];
                    arrayVector[j + 1] = arrayVector[j];
                    arrayVector[j] = temp;
                }
            }
        }
    }

    public void mult(double factor) {
        for (int i = 0; i < arrayVector.length; i++) {
            arrayVector[i] = arrayVector[i] * factor;
        }
    }

    public ArrayVector sum(ArrayVector anotherVector) {
        ArrayVector temp;
        temp = new ArrayVectorImpl();
        temp.set(arrayVector);
        for (int i = 0; i < arrayVector.length; i++) {
            temp.set(i, anotherVector.get(i) + arrayVector[i]);
        }
        anotherVector = temp;
        return anotherVector;
    }

    public double scalarMult(ArrayVector anotherVector) {
        double result = 0;
        for (int i = 0; i < arrayVector.length; i++) {
            result += arrayVector[i] * anotherVector.get(i);
        }
        return result;
    }

    public double getNorm() {
        double result = 0;
        for (int i = 0; i < arrayVector.length; i++) {
            result += Math.pow(arrayVector[i], 2);
        }
        return Math.sqrt(result);
    }
}
