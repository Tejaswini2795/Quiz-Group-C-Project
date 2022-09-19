package com.min_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Give_Test {
	Map<Integer, Map<Integer, String>> access()
	{
		
		Students Students=new Students();
		int no = Students.verify();
		Map<Integer,Map<Integer,String>> result=new HashMap<Integer,Map<Integer,String>>();
		if(no==0)
		{
			System.out.println("please signup first");
			System.out.println(result);
			return result;
			
		}
		else
		{
			Map<Integer, String> ans = questionM();
			result.put(no, ans);
			return result;
			
			
		}
	}
	
	Map<Integer,String> questionM() 
	{
	  Questions questions=new Questions();
	  Map<Integer, String> test = questions.test();
	  Set<Integer> keys = test.keySet();
	  List<Integer> l=new ArrayList<Integer>();
	  l.addAll(keys);
	  Collections.shuffle(l );
	  System.out.println(l);
	 
	  
	  Options options=new Options();
	  Map<Integer, Object> op = options.set();
	  Map<Integer,String> answers=new HashMap<Integer,String>();
	  Scanner sc=new Scanner(System.in);
	  
	  
	  
	  
	  for(int i=0;i<10;i++)
	  {

		  int no=l.get(i);
		  System.out.println(i+1+")"+test.get(no)+"\n");
		  System.out.println("   "+op.get(no)+"\n");
		  System.out.println("select correct answer:");
		  String ans=sc.nextLine();
		 answers.put(no, ans);
	  }
	  sc.close();
	  return answers;
	  
	}
	
	
	
	

}

