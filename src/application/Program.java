package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.client;




public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path:");
		String patch = sc.next();
		System.out.print("Enter salary: ");
		Double salary = sc.nextDouble();
		
		try( BufferedReader br =new  BufferedReader(new FileReader(patch))){
			
			String line = br.readLine();
			List<client> list = new ArrayList<>();
			while(line != null) {
				String [] positions = line.split(",");
				list.add(new client(positions[0], positions[1], Double.parseDouble(positions[2])));
				line = br.readLine();
			}
			
			List<String> email = list.stream().filter(x -> x.getSalary() > salary)
			.map(x -> x.getEmail()).sorted((s1,s2)->s1.toUpperCase().compareTo(s2.toUpperCase()))
			.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than "+ salary.toString() + ":");
			email.forEach(System.out::println);
			
			 Double somatorio = 0.0;
			Double sum = list.stream().filter(x -> x.getName().charAt(0)=='M')
					.map(x -> x.getSalary() + somatorio)
					.reduce(0.0, (x,y) -> x + y);
					
					
					
			
			
			System.out.print("Sum of salary of people whose name starts with 'M': " + sum);
			;
		}	
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
			
		sc.close();
		

	}

}
