import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        System.out.print("Digite o salário mensal do funcionário: ");
        String nome = ler.nextLine();
        double salarioMensal = ler.nextDouble();    

        Funcionario funcionario = new Funcionario(nome, salarioMensal);

        double salarioBruto = funcionario.CalcularBruto();
        System.out.println("Salário Bruto: " + salarioBruto);

        double inss = funcionario.calcularINSS();
        System.out.println("INSS: " + inss);

        double irrf = funcionario.calcularIRRF();
        System.out.println("IRRF: " + irrf);

        double salarioLiquido = salarioBruto - inss - irrf;
        System.out.println("Salário Líquido: " + salarioLiquido);

        ler.close();
    }
}
