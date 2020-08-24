package com.leetCode; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* CountSubstrings Tester. 
* 
* @author Ying 
* @since <pre>08/19/2020</pre> 
* @version 1.0 
*/ 
public class CountSubstringsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: countSubstrings(String s) 
* 
*/ 
@Test
public void testCountSubstrings() throws Exception {
    CountSubstrings countSubstrings = new CountSubstrings();
//    System.out.println(countSubstrings.countSubstrings("abc"));
//    System.out.println(countSubstrings.countSubstrings("aaa"));
    System.out.println(countSubstrings.countSubstrings("abdffdsgdsg"));
    System.out.println(countSubstrings.countSubstrings("abdffdsgdfdgwdsgdsfgsdffgdhgsg"));
}


} 
