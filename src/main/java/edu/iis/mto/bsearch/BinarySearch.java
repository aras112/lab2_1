/**
 *
 */
package edu.iis.mto.bsearch;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility Class dla wyszukiwania binarnego
 *
 */
public class BinarySearch
    {

    private BinarySearch()
        {
        }

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq)
        {

        /*Guava needed*/
        checkIsOrdered(seq);

        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end)
            {
            center = (start + end) / 2;
            if (seq[center] == key)
                {
                result.setPosition(center + 1);
                break;
                }
            else
                {
                if (seq[center] < key)
                    {
                    start = center + 1;
                    }
                else
                    {
                    end = center - 1;
                    }
                }

            }
        return result;
        }

    private static void checkIsOrdered(int[] seq)
        {

        List<Integer> list = Arrays.stream(seq).boxed().collect(Collectors.toList());


        if (!Ordering.natural().isOrdered(list))
            {
            throw new IllegalArgumentException("List must be sorted");
            }
        }

    }
