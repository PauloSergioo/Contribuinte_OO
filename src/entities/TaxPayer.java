package entities;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double monthlySalary = this.salaryIncome / 12;

		if (monthlySalary < 3000) {
			return 0;
		} else {
			if (monthlySalary < 5000) {
				return this.salaryIncome * 0.1;
			} else {
				return this.salaryIncome * 0.2;
			}
		}
	}

	public double servicesTax() {
		return this.servicesIncome * 0.15;
	}

	public double capitalTax() {
		return this.capitalIncome * 0.2;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double deductibleSpending, deductibleMax; 
		deductibleSpending = this.healthSpending + this.educationSpending;
		deductibleMax = 0.3 * grossTax();
		
		if (deductibleSpending > deductibleMax) {
			return deductibleMax;
		} else {
			return deductibleSpending;
		}
	}

	public double netTax() {
		return grossTax()  - taxRebate();
	}

	public String statusGrossTax() {
		return "Imposto bruto total: %.2f%n" + grossTax(); 
	}
	
	public String statusTaxRebate() {
		return "Imposto bruto total: %.2f%n" + taxRebate();
	}
	
	public String statusNetTax() {
		return "Imposto bruto total: %.2f%n" + netTax();
	}
}