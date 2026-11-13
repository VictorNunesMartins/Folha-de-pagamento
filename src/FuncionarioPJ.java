public class FuncionarioPJ extends Funcionario {
    private boolean pj;

    public FuncionarioPJ(String nome, double salarioMensal, boolean pj) {
        super(nome, salarioMensal);
        this.pj = pj;
    }

    public boolean isPJ() {
        return pj;
    }

    @Override
    public double calcularINSS() {
        // Funcionários PJ não contribuem para o INSS
        return 0.0;
    }

    @Override
    public double calcularIRRF() {
        // Funcionários PJ não têm IRRF retido na fonte
        return 0.0;
    }
    
}
