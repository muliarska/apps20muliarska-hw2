package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class ImmutableLinkedListTest {
    ImmutableLinkedList testList;
    ImmutableLinkedList testEmptyList;

    public ImmutableLinkedListTest() {
        Object[] data = {1, 2, 3, 4, 5};
        this.testList = new ImmutableLinkedList(data);

        this.testEmptyList = new ImmutableLinkedList(null);
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList listAddFirst = testList.addFirst(0);
        Object[] expListAddFirst = {0, 1, 2, 3, 4, 5};
        assertArrayEquals(listAddFirst.toArray(), expListAddFirst);

        ImmutableLinkedList listAddLast = testList.addLast(0);
        Object[] expListAddLast = {1, 2, 3, 4, 5, 0};
        assertArrayEquals(listAddLast.toArray(), expListAddLast);

        ImmutableList listAdd = testList.add(0);
        Object[] expListAdd = {1, 2, 3, 4, 5, 0};
        assertArrayEquals(listAdd.toArray(), expListAdd);

        ImmutableList listAddWithIndex = testList.add(3, 0);
        Object[] expListAddWithIndex = {1, 2, 3, 0, 4, 5};
        assertArrayEquals(listAddWithIndex.toArray(), expListAddWithIndex);

        ImmutableList listAddWithIndexZero = testList.add(0, 0);
        Object[] expListAddWithIndexZero = {0, 1, 2, 3, 4, 5};
        assertArrayEquals(listAddWithIndexZero.toArray(), expListAddWithIndexZero);

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

        ImmutableList listAddAllFirst = testList.addAll(0, listToAdd);
        Object[] expListAddAllFirst = {6, 7, 8, 1, 2, 3, 4, 5};
        assertArrayEquals(listAddAllFirst.toArray(), expListAddAllFirst);
    }

    @Test
    public void testGet() {
        assertEquals(testList.getFirst(), 1);

        assertEquals(testList.getLast(), 5);

        assertEquals(testList.get(3), 4);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList listRemoveFirst = testList.removeFirst();
        Object[] expListRemoveFirst = {2, 3, 4, 5};
        assertArrayEquals(listRemoveFirst.toArray(), expListRemoveFirst);

        ImmutableLinkedList listRemoveLast = testList.removeLast();
        Object[] expListRemoveLast = {1, 2, 3, 4};
        assertArrayEquals(listRemoveLast.toArray(), expListRemoveLast);


        ImmutableList listRemove = testList.remove(2);
        Object[] expListRemove = {1, 2, 4, 5};
        assertArrayEquals(listRemove.toArray(), expListRemove);

    }

    @Test
    public void testSet() {
        ImmutableList listSet = testList.set(1, 10);
        Object[] expListSet = {1, 10, 3, 4, 5};
        assertArrayEquals(listSet.toArray(), expListSet);

        ImmutableList listSetFirst = testList.set(0, 10);
        Object[] expListSetFirst = {10, 2, 3, 4, 5};
        assertArrayEquals(listSetFirst.toArray(), expListSetFirst);

        ImmutableList listSetLast = testList.set(4, 10);
        Object[] expListSetLast = {1, 2, 3, 4, 10};
        assertArrayEquals(listSetLast.toArray(), expListSetLast);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        testList.add(10, 0);

        Object[] listToAdd = {6, 7, 8};
        testList.addAll(-3, listToAdd);

        testList.get(10);

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
                "ImmutableLinkedList{ 1 2 3 4 5 }");

    }

    @Test
    public void testNode() {
        assertEquals(testList.getHead().getData(), 1);
        assertEquals(testList.getHead().getNext().getData(), 2);
        assertEquals(testList.getTail().getNext(), null);
    }
}
