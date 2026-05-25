public class contaCantina {

    private tipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;


    public contaCantina(double saldo) {
        this.tipoConta = tipoContaEnum.ALUNO;
        this.saldo = saldo;
        this.saldoMinimo = 10.0;
        this.limite = 0;
}
    public contaCantina(tipoContaEnum tipoConta, double saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.saldoMinimo = 10.0;

        if (tipoConta == tipoContaEnum.PROFESSOR) {
            this.limite = 100.0;
        } else {
            this.limite = 0;
        }
    }


    public void emitirAlertaSaldoBaixo() {

        if (saldo <= saldoMinimo) {
            System.out.println("ALERTA DE SALDO BAIXO: R$ " + saldo);
        } else {
            System.out.println("Saldo: R$ " + saldo);
        }
    }

    public void debitar(double valor) {


        if (tipoConta == tipoContaEnum.DIRETOR) {

            saldo -= valor;
            emitirAlertaSaldoBaixo();
        }


        else if (tipoConta == tipoContaEnum.PROFESSOR) {

            if (valor <= (saldo + limite)) {

                saldo -= valor;
                emitirAlertaSaldoBaixo();

            } else {

                System.out.println("Conta sem saldo suficiente");
            }
        }


        else if (tipoConta == tipoContaEnum.ALUNO) {

            if (valor <= saldo) {

                saldo -= valor;
                emitirAlertaSaldoBaixo();

            } else {

                System.out.println("Conta sem saldo suficiente");
            }
        }
    }


    public void creditar(double valor) {

        saldo += valor;


        if (tipoConta == tipoContaEnum.ALUNO && valor > 100) {
            saldo += 5;
        }

        emitirAlertaSaldoBaixo();
    }


    public tipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(tipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;

        emitirAlertaSaldoBaixo();
    }
}