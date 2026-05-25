public class Main {

    public static void main(String[] args) {

        contaCantina conta1 = new contaCantina(100);

        conta1.debitar(95);

        conta1.creditar(150);

        contaCantina conta2 =
                new contaCantina(tipoContaEnum.PROFESSOR, 50);

        conta2.debitar(120);

        contaCantina conta3 =
                new contaCantina(tipoContaEnum.DIRETOR, 20);

        conta3.debitar(200);
    }
}