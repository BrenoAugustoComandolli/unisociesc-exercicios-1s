import java.util.Scanner;

public class Exercicio001 {

	public static void main(String[] args) {
		
		double n1;
		double n2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o primeiro n�mero:");
		n1 = sc.nextDouble();
		
		System.out.println("Digite o segundo n�mero:");
		n2 = sc.nextDouble();
		
		if(n2 != 0) {
			System.out.println("Adi��o: "+(n1+n2));
			System.out.println("Subtra��o: "+(n1-n2));
			System.out.println("Mutiplica��o: "+(n1*n2));
			System.out.println("Divis�o: "+(n1/n2));
		}else {
			System.out.println("Divis�o por zero inv�lida!");
		}
		sc.close();
	}

}
