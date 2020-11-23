package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.concurrent.TransferQueue;

public class ImmutableArrayList implements ImmutableList {
//    System.arraycopy
    private Object [] data;
    private int size;
    private int buffer;

    public ImmutableArrayList(Object [] data) {
        this.data = data;
        this.size = this.data.length;
        this.buffer = this.data.length;
    }

    private ImmutableArrayList copyAndIncreaseBuffer() {
        ImmutableArrayList newData = new ImmutableArrayList(null);
        if (this.buffer == this.size) {
            System.arraycopy(this.data, 0, newData.data, 0, this.data.length * 2);
            newData.buffer = this.buffer * 2;
        }
        else {
            System.arraycopy(this.data, 0, newData.data, 0, this.data.length);
            newData.buffer = this.buffer;
        }

        newData.size = this.size;
        return newData;
    }

    private ImmutableArrayList increaseBufferByLen(int len) {
        ImmutableArrayList newData = new ImmutableArrayList(null);
        if (this.buffer < this.size + len) {
            System.arraycopy(this.data, 0, newData.data, 0, this.data.length + len);
            newData.buffer = this.buffer + len;
            newData.size = this.size;
        }
        return newData;
    }

    private boolean isValidIndex(int index) {
        return (index >= 0) && (index < this.size);
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableArrayList newList = copyAndIncreaseBuffer();
        newList.data[this.size] = e;
        this.size++;
        return newList;
    }

    private ImmutableArrayList shiftElements(int index, int shift) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        ImmutableArrayList newList = increaseBufferByLen(shift);
        for (int i = index; i < newList.size; i++) {
            newList.data[i+shift] = newList.data[i];
        }
        return newList;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        ImmutableArrayList newList = shiftElements(index, 1);
        newList.data[index] = e;
        return newList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList newList = increaseBufferByLen(c.length);
        for (int i = 0; i < c.length; i++) {
            newList.data[i+newList.size] = c[i];
        }
        return newList;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        ImmutableArrayList newList = shiftElements(index, c.length);
        for (int i = 0; i < c.length; i++) {
            newList.data[i+index] = c[i];
        }
        return newList;
    }

    @Override
    public Object get(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        return this.data[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        ImmutableArrayList newList = shiftElements(index, -1);
        newList.size -= 1;
        return newList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        ImmutableArrayList newList = copyAndIncreaseBuffer();
        newList.data[index] = e;
        return newList;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == e) {
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
        return newList;
    }

    @Override
    public boolean isEmpty() {
        return this.size > 0;
    }

    @Override
    public Object[] toArray() {
        return this.data;
    }

    @Override
    public String toString() {
        return "ImmutableArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", buffer=" + buffer +
                '}';
    }
}
