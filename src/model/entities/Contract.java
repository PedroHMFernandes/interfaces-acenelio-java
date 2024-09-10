package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private int number;
	private LocalDate date;
	private double totalValue;
	private List<Installment> installments = new ArrayList<Installment>();

	public Contract(int number, LocalDate date, double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public int getNumber() {
		return number;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void addInstallments(Installment installment) {
		installments.add(installment);
	}
}
