public class Funcionario {
        private String nome;
        private double salarioMensal;
        private final boolean pj;
        
        public Funcionario(String nome, double salarioMensal) {
            this(nome, salarioMensal, false);
        }
        protected Funcionario(String nome, double salarioMensal, boolean pj) {
            if (nome == null || nome.isBlank() || salarioMensal < 0) {
                throw new IllegalArgumentException("Nome e salário inválidos.");
            }
            this.nome = nome;
            this.salarioMensal = salarioMensal;
            this.pj = pj;
        }
        public boolean isPJ() {
            
            return pj;
        }
        public double CalcularBruto() {
            return this.salarioMensal;
        }
        public double calcularINSS() {
            double salarioBruto = CalcularBruto();
            double inss = 0.0;
            if (salarioBruto > 8475.55) {
                inss += (8475.55 - 4354.86) * 0.14; 
                salarioBruto = 4354.86;
            }else if (salarioBruto > 2902.84) {
                inss += (salarioBruto - 2902.84) * 0.12; 
                salarioBruto = 2902.84;
            } else if (salarioBruto > 1621.00) {
                inss += (salarioBruto - 1621.00) * 0.09; 
                salarioBruto = 1621.00;
            }
            inss += salarioBruto * 0.075; 
            return inss;
        }
        public double calcularIRRF() {
            double salarioBruto = CalcularBruto();
            double inss = calcularINSS();
            double deducao = Math.max(inss, 607.20);
            double baseIR = Math.max(0, salarioBruto - deducao);
        
            
            double impostoInicial = 0.0;
            if (baseIR > 4664.68) {
                impostoInicial = baseIR * 0.275 - 869.36; 
            } else if (baseIR > 3751.05) {
                impostoInicial = baseIR * 0.225 - 636.13; 
            } else if (baseIR > 2826.65) {
                impostoInicial = baseIR * 0.15 - 354.80; 
            } else if (baseIR > 1903.98) {
                impostoInicial = baseIR * 0.075 - 142.80; 
            }
            impostoInicial = Math.max(0, Math.round(impostoInicial)); 
            
            double reducao = 0.0;
            if (salarioBruto > 5000.00 && salarioBruto <= 7350.00) {
                reducao = 978.62 - 0.133145 * salarioBruto;
                reducao = Math.max(0, Math.round(reducao)); 
            } else if (salarioBruto <= 5000.00) {
                reducao = impostoInicial; 
            }
        
            double irrfFinal = Math.max(0, impostoInicial - reducao);
            return irrfFinal;
        }
 // Complete os métodos e acessos necessários.
}


