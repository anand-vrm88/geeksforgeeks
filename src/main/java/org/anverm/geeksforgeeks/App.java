package org.anverm.geeksforgeeks;

import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Integer> list = new LinkedList<Integer>();
    	test(list);
    	list.add(new Integer(50));
    }
    
    private static void test(List<Integer> list){
    	list.add(new Integer(23));
    }
}
