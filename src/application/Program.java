package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
			
		System.out.print("Quantos contribuintes você vai digitar? ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			System.out.printf("Digite os dados do %do contribuinte: %n", (i+1));
			System.out.println();
			
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			System.out.println();
			
			list.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));			
		}
		
		
		
		for (int i=0; i<N; i++) {
			list.get(i).grossTax();
		}
		
		
		for (int i=0; i<N; i++) {
			System.out.printf("Resumo do %do contribuinte: %n", (i+1));
			System.out.printf("Imposto bruto total: %.2f%n" );
			System.out.printf("Abatimento: %.2f%n" );
			System.out.printf("Imposto devido: %.2f%n" );
		}

		sc.close();
	}

}
