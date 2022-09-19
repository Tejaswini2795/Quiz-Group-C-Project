package com.min_project;

import java.util.HashMap;
import java.util.Map;

public class Options {
	String A;
	String B;
	String C;
	String D;
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	}
	public String getB() {
		return B;
	}
	public void setB(String b) {
		B = b;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getD() {
		return D;
	}
	public void setD(String d) {
		D = d;
	}
	public Options(String a, String b, String c, String d) {
		super();
		A = a;
		B = b;
		C = c;
		D = d;
	}
	@Override
	public String toString() {
		return "A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + "";
	}
	Map<Integer,Object> set()
	{
		Options obj1=new Options("6", "7", "8", "9");
		Options obj2=new Options("32 and 64", "32 and 32", "64 and 64", "64 and 32");
		Options obj3=new Options("Byte to int", "int to long", "Long to int", "short to int");
		Options obj4=new Options("The reference of the Array", "A copy of The array", "Length of array", "Copy of first element");
		Options obj5=new Options("Object reference", "Objects", "Primitive data type", "None");
		Options obj6=new Options("At Run Time", "At Compile Time", "Depends On Code", "None");
		Options obj7=new Options("A Package is a Collection Of editing tool", "a package is a collection of classes", "A package is collection classes and intefaces", "A package is collection of interfaces");
		Options obj8=new Options("Static", "Final", "volatile", "abstract");
		Options obj9=new Options("java.lang.object", "java.lang.String", "java.lang.util", "None");
		Options obj10=new Options("True", "False", "An int value", "None");
		Map<Integer,Object> mp=new HashMap<Integer,Object>();
		mp.put(1, obj1);
		mp.put(2, obj2);
		mp.put(3, obj3);
		mp.put(4, obj4);
		mp.put(5, obj5);
		mp.put(6, obj6);
		mp.put(7, obj7);
		mp.put(8, obj8);
		mp.put(9, obj9);
		mp.put(10, obj10);
		return mp;
		
	}
	
	public Options() {
		
	}
	
	
	

}
