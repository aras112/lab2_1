package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Before public void setUp() throws Exception {
    }

    @Test public void presentOneElementInTab() {
        int[] tab={1};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(1,tab);
        assertThat(searchResult.isFound(),is(true));
    }
}
