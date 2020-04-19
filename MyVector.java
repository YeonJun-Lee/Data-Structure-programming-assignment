/**
 *  Midterm2
 *  Data structure that behaves like a dynamically allocated vector
 *  CS108-4
 *  4/18/20
 *  @author  YeonJun Lee
 */

public class MyVector<E> extends MyAbstractList<E> {

    private E array[];
    private int capacity = 10;
    private int increment = 5;


    //Default constructor
    @SuppressWarnings("unchecked")
    public MyVector() {
        array = (E[]) new Object[capacity];
        size = 0;
        increment= 5;
    }

    //Constructor getting inital capacity of vector from parameter
    @SuppressWarnings("unchecked")
    public MyVector(int inicapacity) {
        inicapacity = capacity;
        array = (E[]) new Object[inicapacity];
        size = 0;

    }


    @SuppressWarnings("unchecked")
    public MyVector(int iniCapacity, int CapacityInc) {
        CapacityInc = increment;
        iniCapacity = capacity;
        array = (E[]) new Object[iniCapacity];
        size = 0;
    }


    public int getCapacity() {
        return this.capacity;
    }

    public int getIncrement() {
        return this.increment;
    }


    /**
     * Appends the specified element to the end of this list,
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     *
     * @param data
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(E data) {
        if (capacity == size) {
            copyArray();
        }
        array[size] = data;
        size++;
        return true;
    }


    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements by adding one to their indices.
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     *
     * @param index - index at which the specified element is to be inserted
     * @param data  - element to be inserted
     * @return boolean
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */

    @Override
    public boolean add(int index, E data) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index out of bound");
        }

        if (size == capacity) {
            copyArray();
        }


        if (index != size) {
            for (int i = size-1; i > index; i--) {
                array[i+1] = array[i];
            }
        }
        array[index] = data;
        size++;
        return true;
    }


    /**
     * Removes all of the elements from this list
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        capacity = 7;
    }

    /**
     * Returns the element at the specified position in this list
     *
     * @param index
     * @return E
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (size == 0){
            throw new IndexOutOfBoundsException("Empty Array");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        return array[index];
    }


        /**
         * Removes the  element at the specified position in this list.
         * Shifts any subsequent elements by subtracting one from their indices.
         *
         * @param index - index of the element to be removed
         * @return E - the element that was removed from the list
         * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
         */

    @Override
    public E remove(int index) {
        if (size == 0){
            throw new IndexOutOfBoundsException("Empty Array");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
            E e = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return e;
        }

    /**
     * Trims the capacity of this MyVector instance to be the list's current size. An application
     * can use this operation to minimize the storage of a MyVector instance.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void trimToSize() {
        for (int i = size; i < capacity; i++){
            array[i] = null;
        }
        capacity = size();

    }



    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append("[");
        for (int index = 0; index < size - 1; index++) {
            line.append(this.array[index]).append(", ");
        }
        line.append(this.array[size - 1]);
        line.append("]");
        return line.toString();
    }



    @SuppressWarnings("unchecked")
    private void copyArray() {
        capacity = capacity + increment;
         //copy the old array to new array
        E[] cArray = (E[]) new Object[capacity];

        if (cArray.length < array.length) {
            for(int i = 0; i < cArray.length; i++){
                array[i] = cArray[i];
            }
        }
        else {
            for (int i = 0; i < cArray.length; i++) {
                array[i] = cArray[i];
            }
        }
    }
}




