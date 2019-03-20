package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Before public void setUp() throws Exception {
    }

    @Test public void presentInTabWithOneElement() {
        int[] tab = {1};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.isFound(), is(true));
    }

    @Test public void noPresentInTabWithOneElement() {
        int[] tab = {2};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.isFound(), is(false));
    }

    @Test public void presentInFirstPositionInTab() {
        int[] tab = {1, 2, 3};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(1));
    }

    @Test public void presentInLastPositionInTab() {
        int[] tab = {1, 2, 4};
        int key = 4;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(3));
    }

    @Test public void presentInCentrePositionInTab() {
        int[] tab = {1, 2, 4};
        int key = 2;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(2));
    }

    @Test public void noPresentInCentrePositionInTab() {
        int[] tab = {1, 3, 4};
        int key = 2;
        SearchResult searchResult = BinarySearch.search(key, tab);
        assertThat(searchResult.getPosition(), is(-1));
    }
}
