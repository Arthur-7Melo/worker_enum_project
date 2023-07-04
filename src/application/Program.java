package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker?");
		int n = sc.nextInt();
		for (int i = 0; i <n ; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String date1 = sc.next();
			LocalDate contractDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			HourContract contracts = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contracts);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String date2 = sc.next();
		int month = Integer.parseInt(date2.substring(0, 2));
		int year = Integer.parseInt(date2.substring(3));
		System.out.println("Name: " + workerName);
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + date2 + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
