import java.util.Scanner;

public class ExercicioTreino002 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe primeiro n�mero: ");
		double n1 = sc.nextDouble();
		
		System.out.println("Informe segundo n�mero: ");
		double n2 = sc.nextDouble();
		
		if(n2 != 0) {
			double resultado = n1 / n2;
			System.out.println("Resultado: "+resultado);
		}else {
			System.out.println("Divis�o por zero inv�lida!");
		}
		
		sc.close();
	}
}
