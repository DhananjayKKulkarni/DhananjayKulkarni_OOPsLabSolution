package com.glearning.pg.client;

import java.util.Scanner;

import com.glearning.pg.model.Employee;
import com.glearning.pg.service.CredentialService;

public class CredentialClient {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter employee's first name");
		String empFirstName = scanner.next();
		
		System.out.println("Enter employee's last name");
		String empLastName = scanner.next();
		
		System.out.println("Please Enter the department from the following ");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		
		int selection = scanner.nextInt();
		Employee employee = null;
		
		switch(selection) {
			
			case 1:
				employee = new Employee(empFirstName, empLastName, "tech");
					break;
			case 2:
				employee = new Employee(empFirstName, empLastName, "admin");
				break;
			case 3:
				employee = new Employee(empFirstName, empLastName, "hr");
				break;
			case 4:
				employee = new Employee(empFirstName, empLastName, "legal");
				break;
			default: System.out.println("Invalid Department selection");
		}
		
		
		try{
			
			// Proceed only if department selection is valid
			if(selection > 0 && selection <= 4) {
				int pwdLen =0;
				
				// Request user for valid password length. Proceed only if password length is valid
				do {
					System.out.println("Enter required password length (>8): ");
					pwdLen = scanner.nextInt();
					if (pwdLen < 8 ) {
						System.out.println("Password length must be at least 8 charecter.  ");
						pwdLen=0;
					}
					
				}while(pwdLen == 0);
				
				
				employee.setPassword( CredentialService.generatePassword(pwdLen));
				CredentialService.showCredentials(employee);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
		scanner.close();
	}
}
