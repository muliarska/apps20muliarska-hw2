package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
//    System.arraycopy
    private Object [] data;
    private int size;
    private int buffer;

    public ImmutableArrayList(Object [] data) {
        if (data == null) {
            this.data = null;
            this.size = 0;
            this.buffer = 0;
        }
        else {
            this.data = data.clone();
            this.size = this.data.length;
            this.buffer = this.data.length;
        }
    }

    private ImmutableArrayList copyAndIncreaseBuffer() {
        int len;

        if (this.buffer == this.size) {
            len = this.data.length * 2;
        }
        else {
            len = this.data.length;
        }

        Object[] newArray = new Object[len];
        ImmutableArrayList newData = new ImmutableArrayList(newArray);
        System.arraycopy(this.data, 0, newData.data, 0, this.size);

        newData.buffer = len;
        newData.size = this.size;

        return newData;
    }

    private ImmutableArrayList increaseBufferByLen(int len) {
        Object[] newArray = new Object[this.size + len];
        ImmutableArrayList newData = new ImmutableArrayList(newArray);
        System.arraycopy(this.data, 0, newData.data, 0, this.size);

        newData.buffer = this.size + len;
        newData.size = this.size;

        return newData;
    }

    private void isValidIndex(int index) {
        if ((index < 0) || (index >= this.size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableArrayList newList = copyAndIncreaseBuffer();
        newList.data[this.size] = e;
        newList.size++;
        return newList;
    }

    private ImmutableArrayList shiftElements(int index, int shift) {
        isValidIndex(index);

        int newIndex = index;
        ImmutableArrayList newList = copyAndIncreaseBuffer();
        if (shift < 0) {
            newIndex = index + 1;
        }

        for (int i = newIndex; i < newList.size; i++) {
            newList.data[i+shift] = this.data[i];
        }
        return newList;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        isValidIndex(index);

        ImmutableArrayList newList = shiftElements(index, 1);
        newList.data[index] = e;
        newList.size++;
        return newList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList newList = increaseBufferByLen(c.length);
        for (int i = 0; i < c.length; i++) {
            newList.data[i+newList.size] = c[i];
        }
        newList.size += c.length;
        return newList;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        isValidIndex(index);

        ImmutableArrayList newList = shiftElements(index, c.length);
        for (int i = 0; i < c.length; i++) {
            newList.data[i+index] = c[i];
        }
        newList.size += c.length;
        return newList;
    }

    @Override
    public Object get(int index) {
        isValidIndex(index);

        return this.data[index];
    }

    @Override
    public ImmutableList remove(int index) {
        isValidIndex(index);

        ImmutableArrayList newList = shiftElements(index, -1);
        newList.size -= 1;
        return newList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        isValidIndex(index);

        ImmutableArrayList newList = copyAndIncreaseBuffer();
        newList.data[index] = e;
        return newList;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        ImmutableArrayList newList = copyAndIncreaseBuffer();
        newList.data = null;
        newList.size = 0;
        newList.buffer = 0;
        return newList;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            array[i] = this.data[i];
        }
        return array;
    }

    @Override
    public String toString() {
        return "ImmutableArrayList{"
                + "data=" + Arrays.toString(this.toArray())
                + ", size=" + this.size
                + '}';
    }
}
