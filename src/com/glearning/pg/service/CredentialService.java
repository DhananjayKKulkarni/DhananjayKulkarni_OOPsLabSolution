package com.glearning.pg.service;

import java.util.Random;

import com.glearning.pg.model.Employee;

public class CredentialService {

	// This method generates an email address using First name , Last name and Department 
	public static String  generateEmailAddress (String firstName, String lastName, String department){ 
		
		return firstName + lastName + '@' +department + ".company.com";
		
	}
	
	
	// This method generates an email address using First name , Last name and Department
	// method is declared as Final so that it can not be extended and password values will not be tampered  
	public final static String generatePassword(int pwdLength) {

		String strNumber ="0123456789";
		String strCapLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String strSmallLetters = "abcdefghijklmnopqrstuvwxyz";
		String strSpecialChars ="!@#$%^&*()<>?/\':,{}[]_-.";
		
		String pwdSource = strNumber + strCapLetters + strSmallLetters + strSpecialChars;
		Random random = new Random();
	
		
		char[] password =  new char[pwdLength];
		
		for (int index =0; index < pwdLength; index++) { 
			int randomNumber =
			random.nextInt(pwdSource.length()); password[index]=
			pwdSource.charAt(randomNumber); 
		}
		return String.copyValueOf(password);
		
	}
	
	
	public static void showCredentials(Employee employee)
	{
		System.out.println("Dear "+ employee.getFirstName() + " your generated credentials are as follows");
		System.out.println("Email ---> " +generateEmailAddress(employee.getFirstName(), employee.getLastName(), employee.getDepartment()));
		System.out.println("Password ---> " +employee.getPassword());
		
	}
}
