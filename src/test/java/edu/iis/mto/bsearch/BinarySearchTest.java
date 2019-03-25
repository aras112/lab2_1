package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTest
    {

    @Before
    public void setUp() throws Exception
        {
        }

    @Test
    public void presentInTabWithOneElement()
        {
        int[] tab = {1};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.isFound(), is(true));
        }

    @Test
    public void noPresentInTabWithOneElement()
        {
        int[] tab = {2};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.isFound(), is(false));
        }

    @Test
    public void presentInFirstPositionInTab()
        {
        int[] tab = {1, 2, 3};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(1));
        }

    @Test
    public void presentInLastPositionInTab()
        {
        int[] tab = {1, 2, 4};
        int key = 4;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(3));
        }

    @Test
    public void presentInCentrePositionInTab()
        {
        int[] tab = {1, 2, 4};
        int key = 2;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(2));
        }

    @Test
    public void noPresentInCentrePositionInTab()
        {
        int[] tab = {1, 3, 4};
        int key = 2;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(-1));
        }

    @Test
    public void bigIntegersInTab()
        {
        int[] tab = {Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 2, Integer.MAX_VALUE};
        int key = Integer.MAX_VALUE;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(3));
        }

    @Test
    public void minIntegersInTab()
        {
        int[] tab = {Integer.MIN_VALUE, Integer.MIN_VALUE + 2, Integer.MIN_VALUE + 3};
        int key = Integer.MIN_VALUE;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(1));
        }

    @Test
    public void emptyList()
        {
        int[] tab = {};
        int key = Integer.MAX_VALUE;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertTrue(searchResult.getPosition() == -1 && searchResult.isFound() == false);
        }

    @Test(expected = NullPointerException.class)
    public void nullKeyInTab()
        {
        int[] tab = {};
        Integer key = null;
        SearchResult searchResult = BinarySearch.search(key, tab);
        }

    @Test(expected = NullPointerException.class)
    public void nullTabInTab()
        {
        int[] tab = null;
        int key = Integer.MAX_VALUE;
        SearchResult searchResult = BinarySearch.search(key, tab);
        }

    @Test(expected = NullPointerException.class)
    public void nullKeyAndTabInTab()
        {
        int[] tab = null;
        Integer key = null;
        SearchResult searchResult = BinarySearch.search(key, tab);
        }

    @Test(expected = IllegalArgumentException.class)
    public void noOrderedList()
        {
        int[] tab = {3,2,3};
        Integer key = 2;
        SearchResult searchResult = BinarySearch.search(key, tab);
        }

    @Test(expected = IllegalArgumentException.class)
    public void inverseOrderedList()
        {
        int[] tab = {3, 2, 1};
        Integer key = 2;
        SearchResult searchResult = BinarySearch.search(key, tab);
        }

    }
