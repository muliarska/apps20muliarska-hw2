package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    ImmutableArrayList testList;
    ImmutableArrayList testEmptyList;

    public ImmutableArrayListTest() {
        Object[] data = {1, 2, 3, 4, 5};
        this.testList = new ImmutableArrayList(data);

        this.testEmptyList = new ImmutableArrayList(null);
    }

    @Test
    public void testAdd() {

        ImmutableList listAdd = testList.add(0);
        Object[] expListAdd = {1, 2, 3, 4, 5, 0};
        assertArrayEquals(listAdd.toArray(), expListAdd);

        ImmutableList listAddWithIndex = testList.add(3, 0);
        Object[] expListAddWithIndex = {1, 2, 3, 0, 4, 5};
        System.out.println(listAddWithIndex.toString());
        assertArrayEquals(listAddWithIndex.toArray(), expListAddWithIndex);

    }


    @Test
    public void testAddAll() {
        Object[] listToAdd = {6, 7, 8};

        ImmutableList listAddAll = testList.addAll(listToAdd);
        Object[] expListAddAll = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(listAddAll.toArray(), expListAddAll);

        ImmutableList listAddAllWithIndex = testList.addAll(2, listToAdd);
        Object[] expListAddAllWithIndex = {1, 2, 6, 7, 8, 3, 4, 5};
        assertArrayEquals(listAddAllWithIndex.toArray(), expListAddAllWithIndex);

    }

    @Test
    public void testGet() {
        assertEquals(testList.get(3), 4);
    }

    @Test
    public void testRemove() {

        ImmutableList listRemove = testList.remove(2);
        Object[] expListRemove = {1, 2, 4, 5};
        assertArrayEquals(listRemove.toArray(), expListRemove);

    }

    @Test
    public void testSet() {
        ImmutableList listSet = testList.set(1, 10);
        Object[] expListSet = {1, 10, 3, 4, 5};
        assertArrayEquals(listSet.toArray(), expListSet);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        testList.add(10, 0);

        Object[] listToAdd = {6, 7, 8};
        testList.addAll(-3, listToAdd);

        testList.get(7);

        testList.remove(7);

        testList.set(7, 56);
    }

    @Test
    public void testIndexOf() {
        assertEquals(testList.indexOf(3), 2);

        // not found
        assertEquals(testList.indexOf(8), -1);
    }

    @Test
    public void testSize() {
        assertEquals(testList.size(), 5);
        assertEquals(testEmptyList.size(), 0);
    }

    @Test
    public void testClear() {
        ImmutableList listClear = testList.clear();
        Object[] expListClear = {};
        assertArrayEquals(listClear.toArray(), expListClear);
    }

    @Test
    public void testIsEmpty() {
        assertEquals(testList.isEmpty(), false);

        assertEquals(testEmptyList.isEmpty(), true);
    }

    @Test
    public void testToArray() {
        Object[] expListToArray = {1, 2, 3, 4, 5};
        assertArrayEquals(testList.toArray(), expListToArray);
    }

    @Test
    public void testToString() {
        assertEquals(testList.toString(),
                "ImmutableArrayList{data=[1, 2, 3, 4, 5], size=5}");

    }
    
}
