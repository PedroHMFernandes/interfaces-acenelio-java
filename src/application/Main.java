package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Main {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Contract data
		System.out.println("Enter the contract data:");
		System.out.print("Contract number: ");
		int contractNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();
		Contract ctc = new Contract(contractNumber, contractDate, contractValue);

		// Setting installments
		System.out.print("Enter the number of installments: ");
		int installmentsNumber = sc.nextInt();
		ContractService ctcService = new ContractService(new PaypalService());
		ctcService.processContract(ctc, installmentsNumber);

		// Showing results
		System.out.println("Installments: ");
		for (Installment i : ctc.getInstallments()) {
			System.out.println(i);
		}
		
		sc.close();
	}
}
