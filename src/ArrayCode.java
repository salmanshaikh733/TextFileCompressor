public class ArrayCode {
    //define the instance variables for this class
    private CodePair[] newArray;
    private int numElements;

    // declare constructor with parameter as size initialize the instance variables
    public ArrayCode(int size) {
        this.newArray = new CodePair[size];
        this.numElements = 0;
    }

    // method to add to an array
    public int add(CodePair pair) {
        // as long as the array is full and number of elements is less than 100 than
        // double the size of the array than add
        if (this.newArray.length == numElements && numElements <= 100) {
            expandCapacity();

            this.newArray[getNumPairs()] = pair;
            this.numElements++;

        }
        // if array is full and the number of elements is greater than 100 than expand
        // by twenty than add
        else if (this.newArray.length == numElements && numElements > 100) {
            expandCapacitybyTwenty();
            this.newArray[getNumPairs()] = pair;
            this.numElements++;
        }
        // if not full than add to last place
        else {

            this.newArray[getNumPairs()] = pair;
            this.numElements++;
        }
        // return the size of the array
        return getSize();
    }

    // get the number of elements stored in the list, not the actual designated size
    // of the list
    public int getNumPairs() {
        return this.numElements;

    }

    // get the designated size of the list, for use by public classes
    public int getSize() {
        return this.newArray.length;
    }

    // remove element from array and reduce size by half if number of elments is
    // shorter than length of array
    public void remove(CodePair pairToRemove) {
        // final int not_Found = -1;
        int targetPosition = 0;
        // int i = 0;

        // find value we are looking for
        for (int i = 0; i <= numElements - 1; i++) {

            if (this.newArray[i].equals(pairToRemove)) {
                targetPosition = i;

                // OVERWRITE TARGET POSITION WITH LAST ELEMENT....
                this.newArray[targetPosition] = this.newArray[numElements - 1];
                this.newArray[numElements - 1] = null;
                // DECREASE NUM ELEMENTS BY 1
                numElements--;

            }
        }

        // IF SIZE NUMBER OF ELEMENTS IN AN ARRAY ARE LESS THAN 0.25 OF TOTAL ARRAY SIZE
        if ((numElements) * 100 / this.newArray.length < 25.0) {
            CodePair smallerList[] = new CodePair[(this.newArray.length) / 2];
            for (int i = 0; i < (this.newArray.length / 2); i++) {
                smallerList[i] = this.newArray[i];

            }
            this.newArray = smallerList;
        }
    }

    // find the specififed element index of the array
    public int findCode(String code) {
        final int not_found = -1;
        int output = not_found;
        for (int i = 0; i < numElements && output == not_found; i++) {
            if (code.equals(this.newArray[i].getCode())) {
                output = i;
            }
        }

        return output;
    }

    // find where the character index at char c is
    public int findCharacter(char c) {
        final int not_found = -1;
        int output = not_found;
        for (int i = 0; i < numElements && output == not_found; i++) {
            if (this.newArray[i].getCharacter() == c) {
                output = i;
            }
        }
        return output;
    }

    // get the corresponding code at the index postion i
    public String getCode(int i) {

        if (i < 0 || i > this.numElements) {
            return null;
        } else {
            return this.newArray[i].getCode();
        }
    }

    // @SuppressWarnings("null")
    // get the character at the index position it sent
    public char getCharacter(int i) {

        if (i < 0 || i > this.numElements) {
            return 0;
        } else {
            return this.newArray[i].getCharacter();
        }

    }

    // expand the capacity by dooublin the size
    private void expandCapacity() {
        CodePair largerList[] = new CodePair[this.newArray.length * 2];

        for (int i = 0; i < this.newArray.length; i++) {
            largerList[i] = this.newArray[i];
        }
        this.newArray = largerList;

    }

    // expand the capacity by increasing the size by twenty, if size is already over
    // 100
    private void expandCapacitybyTwenty() {
        CodePair largerList[] = new CodePair[this.newArray.length + 20];

        for (int i = 0; i < this.newArray.length; i++) {
            largerList[i] = this.newArray[i];
        }
        this.newArray = largerList;
    }

}
