package datastructures.arrays;

public class MyArray {

    // Properties of the Array
    private int length;
    private Object[] data;

    // New instances of MyArray initializes an empty array
    public MyArray(){
        this.length = 0;
        this.data = new Object[length];
    }

    // Returns the size of the array
    public int size(){
        return this.length;
    }

    // Adds new data at the end of the current array. Dynamic arrays do not allow reallocation of memory,
    // New memory must be allocated for the new data to be added into the array.
    // Size of array increments by 1 and new memory is allocated for the new array,
    // the elements of the old array is copied into the new array with our new data.
    // Java's Garbage Collection will take care of unallocating the old memory space that we no longer need
    public void add(Object data){
        if(this.length == 0){
            this.length++;
            this.data = new Object[this.length];
            this.data[this.length-1] = data;
        } else{
            this.length++;
            Object[] temp = new Object[this.length];
            for(int i = 0; i<this.length-1; i++){
                temp[i] = this.data[i];
            }
            temp[this.length-1] = data;
            this.data = temp;
        }
    }

    // Removes data at specified index. Again new array is created to reallocate the memory of the new array.
    // Array size decrements by 1 and all the data excluding the one we want to remove is copied into the new array.
    public void remove(int index){
        if(index == this.length-1){
            this.length--;
            Object[] temp = new Object[this.length];
            for(int i = 0; i<this.length; i++){
                temp[i] = this.data[i];
            }
            this.data = temp;
        } else if(index == 0){
            this.length--;
            Object[] temp = new Object[this.length];
            for(int i = 0; i<this.length; i++){
                temp[i] = this.data[i+1];
            }
            this.data = temp;
        } else{
            int removeAtIndex = index;
            this.length--;
            Object[] temp = new Object[this.length];
            for(int i = 0; i<removeAtIndex; i++){
                temp[i] = this.data[i];
            }
            for(int i = removeAtIndex; i<this.length; i++){
                temp[i] = this.data[i+1];
            }
            this.data = temp;
        }
    }

    // Returns the element at specified index
    public Object get(int index){
        return data[index];
    }

    // Replaces the data at the specified index
    public void set(Object data, int index){
        this.data[index] = data;
    }

    // Prints all the elements of the array
    public void traverse(){
        for(Object obj : this.data){
            System.out.print(obj + "\t");
        }
        System.out.println();
    }
}