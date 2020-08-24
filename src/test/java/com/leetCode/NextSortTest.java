package com.leetCode;

import com.leetCode.NextSort;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* NextSort Tester. 
* 
* @author Ying 
* @since <pre>08/14/2020</pre> 
* @version 1.0 
*/ 
public class NextSortTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: nextPermutation(int[] nums) 
* 
*/ 
@Test
public void testNextPermutation() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: sort(int[] nums) 
* 
*/ 
@Test
public void testSort() throws Exception {
    NextSort nextSort = new NextSort();
    nextSort.nextPermutation(new int[]{1,3,5});
    nextSort.nextPermutation(new int[]{5,3,1});
    nextSort.nextPermutation(new int[]{1,1,5});
    nextSort.nextPermutation(new int[]{1,5,1});
    nextSort.nextPermutation(new int[]{1,3,2});
}

} 
