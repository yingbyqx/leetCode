package com.leetCode;

import com.leetCode.IntReverse;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* IntReverse Tester. 
* 
* @author Ying 
* @since <pre>08/14/2020</pre> 
* @version 1.0 
*/ 
public class IntReverseTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: reverse(int x) 
* 
*/ 
@Test
public void testReverse() throws Exception {
    IntReverse intReverse = new IntReverse();
    System.out.println(intReverse.reverse(123));
    System.out.println(intReverse.reverse(-123));
    System.out.println(intReverse.reverse(120));
    System.out.println(intReverse.reverse(1534236469));
    System.out.println(intReverse.reverse(-2147483412));
    System.out.println(intReverse.reverse1(-2147483648));
}


} 
