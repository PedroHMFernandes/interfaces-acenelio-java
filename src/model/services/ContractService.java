package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService paymentService;

	
	
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public OnlinePaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, int months) {
		LocalDate contractDate = contract.getDate();
		double amountToPay;
		for (int i = 1; i <= months; i++) {
			amountToPay = contract.getTotalValue();
			amountToPay += paymentService.interest(amountToPay, i);
			amountToPay += paymentService.paymentFee(amountToPay);
			amountToPay /= months;
			contract.addInstallments(new Installment(contractDate.plusMonths(i), amountToPay));
		}
	}
}
