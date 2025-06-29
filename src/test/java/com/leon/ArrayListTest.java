package com.leon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest
{
    @Test
    public void whenEmptyThenIsEmptyShouldReturnTrue() {
        List<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void whenNotEmptyThenIsEmptyShouldReturnFalse() {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        list.add("Harper");
        assertFalse(list.isEmpty());
    }

    @Test
    public void whenNotEmptyThenSizeShouldBeNoZero() {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        list.add("Harper");
        assertEquals(2, list.size(), "Size should be 2 if two elements added");
    }

    @Test
    public void whenNotEmptyThenRemoveElementSizeShouldDecreaseToOne() {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        list.add("Harper");
        assertEquals(2, list.size(), "Size should be 2 if two elements added");
        list.remove("Harper");
        assertEquals(1, list.size(), "Size should be 1 if one element removed");
    }

    @Test
    public void whenOneElementThenRemoveElementShouldSetSizeToZero() {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        assertEquals(1, list.size(), "Size should be 1 if one element is added");
        list.remove("Horatio");
        assertEquals(0, list.size(), "Size should be 0 if one element removed");
    }

    @Test
    public void whenOneElementThenRemoveNoExistentElementShouldNotChangeSize() {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        assertEquals(1, list.size(), "Size should be 1 if one element is added");
        list.remove("Harper");
        assertEquals(1, list.size(), "Size should still be 1 if no element is removed");
    }

    @Test
    public void whenSetOneElementThenElementDataShouldChange() {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        assertEquals(1, list.size(), "Size should be 1 if one element is added");
        assertEquals("Horatio", list.get(0));
        list.set(0, "Harper");
        assertEquals(1, list.size(), "Size should still be 1 if one element is set");
        assertEquals("Harper", list.get(0));
    }

    @Test
    public void whenSetOneElementThenElementDataShouldChange2() {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        list.add("Harper");
        list.add("Saori");
        list.add("Leon");
        assertEquals(4, list.size(), "Size should be 4 if 4 elements are added");
        assertEquals("Saori", list.get(2));
        list.set(2, "Harper Adeoye");
        assertEquals(4, list.size(), "Size should still be 4 if one element is set");
        assertEquals("Harper Adeoye", list.get(2));
    }

    @Test
    public void whenElementExistsThenContainsShouldReturnTrue()
    {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        list.add("Harper");
        list.add("Saori");
        list.add("Leon");
        assertTrue(list.contains("Saori"));
    }

    @Test
    public void whenElementDoesNotExistsThenContainsShouldReturnFalse()
    {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        list.add("Harper");
        list.add("Leon");
        assertFalse(list.contains("Saori"));
    }

    @Test
    public void whenClearCalledSizeShouldDecreaseToZero()
    {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        list.add("Harper");
        list.add("Leon");
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void whenClearCalledAndSizeIsZeroThenSizeShouldBeUnchanged()
    {
        List<String> list = new ArrayList<>();
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void whenNotEmptyToStringPrintsNoEmptyContents()
    {
        List<String> list = new ArrayList<>();
        list.add("Horatio");
        list.add("Harper");
        list.add("Leon");
        assertEquals("{Horatio, Harper, Leon}", list.toString());
    }

    @Test
    public void whenEmptyToStringPrintsEmptyContents()
    {
        List<String> list = new ArrayList<>();
        assertEquals("{}", list.toString());
    }

    @Test
    public void whenAddNullElementThenThrowException() {
        List<String> list = new ArrayList<>();
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    public void whenSetWithNullElementThenThrowException() {
        List<String> list = new ArrayList<>();
        list.add("Harper");
        assertThrows(NullPointerException.class, () -> list.set(0, null));
    }

    @Test
    public void whenContainsWithNullElementThenThrowException() {
        List<String> list = new ArrayList<>();
        list.add("Harper");
        assertThrows(NullPointerException.class, () -> list.contains(null));
    }

    @Test
    public void whenGetFromEmptyListThenThrowException() {
        List<String> list = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> list.get(0));
    }

}