import java.util.Scanner;

public class Exercicio002 {
	
	public static void main(String[] args) {
		
		double V1, V2, V3;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o n�mero 1:");
		V1 = sc.nextDouble();
		
		System.out.println("Digite o n�mero 2:");
		V2 = sc.nextDouble();
		
		System.out.println("Digite o n�mero 3:");
		V3 = sc.nextDouble();
		
		System.out.println("Opera��o 1: "+(V1 + V2));
		System.out.println("Opera��o 2: "+(V2 - V1));
		System.out.println("Opera��o 3: "+(V3 * V1));
		System.out.println("Opera��o 4: "+(V3 + V2));
		System.out.println("Opera��o 5: "+(V3 - V2));
		System.out.println("Opera��o 6: "+(V1 + V2 + V3));
		
		sc.close();
	}
}
