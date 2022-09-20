package com.velocity.queez.result;

import java.util.Scanner;

public class MainOptions {
	public void mainOptions() {
		MainOptions op1 = new MainOptions();
		ShowAllResults r = new ShowAllResults();
		StudentRegistration sr = new StudentRegistration();
		ShowResult al = new ShowResult();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welocme\n ");
		
		System.out.println("1. Student Registration");
		System.out.println("2. See Results\n");
		System.out.println("Select Option:\n");
		int option = sc.nextInt();
		
		
				switch (option) {
				case 1: {
					System.out.println("\n1. New Registation");
					System.out.println("2. Already Registered");
					System.out.println("Select Option:\n");
					int op = sc.nextInt();
					
							switch (op) {
							case 1: {
								sr.getData();
								break;
							}
							case 2:{
								System.out.println("Enter Student ID:");
								int id = sc.nextInt();
								r.displayStudResult(id);
								break;
							}
							default:
								{
									System.out.println("Please select Right Option\n");
									break;
								}
							}
						break;
					}
					case 2:{
						al.showOption();
						break;
					}
					default:{
						System.out.println("Please select Right Option\n");
						op1.mainOptions();
						break;
					}
				}
			sc.close();
	}
}
