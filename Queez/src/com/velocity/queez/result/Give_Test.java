package com.velocity.queez.result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Give_Test {
	int stud_id;
	
	
	public Give_Test(int stud_id) {
		super();
		this.stud_id = stud_id;
	}
	Map<Integer,Map<Integer,String>> questionM() 
	{
	  
	  Questions questions=new Questions();
	  Map<Integer, String> test = questions.test();
	  Set<Integer> keys = test.keySet();
	  List<Integer> l=new ArrayList<Integer>();
	  l.addAll(keys);
	  Collections.shuffle(l );
	  //System.out.println(l);
	 
	  
	  Options options=new Options();
	  Map<Integer, Object> op = options.set();
	  Map<Integer,String> answers=new HashMap<Integer,String>();
	  Map<Integer,Map<Integer,String>> hm=new HashMap<Integer,Map<Integer,String>>();
	  Scanner sc1=new Scanner(System.in);
	  
	  
	  
	  
	  for(int i=0;i<10;i++)
	  {

		  int no=l.get(i);
		  System.out.println(i+1+")"+test.get(no)+"\n");
		  System.out.println("   "+op.get(no)+"\n");
		  System.out.println(" select correct answer:");
		  String ans= sc1.nextLine();
		 answers.put(no, ans);
	  }
	 
	  hm.put(stud_id, answers);
	  
	  sc1.close();
	  return hm;
	  
	  
	}
	
	
	
	

}

