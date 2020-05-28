package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String email;
	private String password;
	private int pwdLength;
	private int mailboxCap;
	private String alterEmail;
	private String companySuffix = ".company.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created: "+this.firstName+" "+this.lastName);
		
		// Call a method to ask for the department
		this.department = setDepartment();
		System.out.println("Department: "+this.department);
		
		// Generate the email
		generateEmail(this.firstName, this.lastName, this.department);
		System.out.println("Your Email: "+this.email);
		
		// Generate random password
		this.pwdLength = 8;
		this.password = randomPassword(this.pwdLength);
		System.out.println("Your password: "+this.password);
	}
	
	public String setDepartment() {
		System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		switch (depChoice) {
		case 1: return "sales";
		case 2: return "devs";
		case 3: return "acct";
		default: return "";
		}
		
	}
	
	private String randomPassword(int length) {
		String passwordChars = "abcdefghijklmnopqrstuvwxyz";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rnd = (int) (Math.random() * passwordChars.length());
			password[i] = passwordChars.charAt(rnd);
		}
		return new String(password);
	}
	
	public void generateEmail(String firstName, String lastName, String department) {
		this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() 
					+ "@" + this.department + companySuffix;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public void setAlternateEmail(String alterEmail) {
		this.alterEmail = alterEmail;
	}

	public void setMailboxCap(int mailboxCap) {
		this.mailboxCap = mailboxCap;
	}
	
	public String toString() {
		return "Name: "+this.firstName+" "+this.lastName+"\n"
				+"Email: "+this.email+"\n"
				+"Mailbox Capacity: "+this.mailboxCap;
	}
	
}
