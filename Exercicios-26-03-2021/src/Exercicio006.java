import java.util.Scanner;

public class Exercicio006 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nome:");
		String nome = sc.nextLine();
		
		System.out.println("N�mero de horas trabalhadas:");
		int numHoras = sc.nextInt();
		
		System.out.println("N�mero de depend�ncias:");
		int dependencias = sc.nextInt();
		
		final double VALOR_HORA = 32.00;
		final double VALOR_DEPENDENTE = 40.00;
	
		//Calcula o sal�rio bruto
		double salarioBruto = ((numHoras * VALOR_HORA) + (dependencias * VALOR_DEPENDENTE));
		
		//Calcula o INSS
		double inss = salarioBruto * (8.5/100);
		
		//Calcula o IR
		double ir = salarioBruto * (5.0/100);
		
		//Sal�rio l�quido 
		double liquido = (salarioBruto - inss - ir);
		
		System.out.println("------------------------------------");
		System.out.println("-----------Ficha-de-dados-----------");
		System.out.println("------------------------------------");
		System.out.println("-> Nome: "+nome);
		System.out.println("-> N�mero de horas trabalhadas: "+numHoras);
		System.out.println("-> N�emro de depend�ncias: "+dependencias);
		System.out.println("------------------------------------");
		System.out.println("-> Sal�rio Bruto: "+salarioBruto);
		System.out.println("-> INSS: "+inss);
		System.out.println("-> IR: "+ir);
		System.out.println("-> Sal�rio L�quido: "+liquido);
		System.out.println("------------------------------------");
		
		sc.close();
	}

}
