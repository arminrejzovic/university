package SE221;

/*
Armin Rejzović 190302077
Veldin Salčinović 190302158
 */

public class CoronaTest {
    public static void main(String[] args) {
        Coronavirus c1 = new Coronavirus();
        Coronavirus c2 = new Coronavirus("ATATATATAT");

        System.out.println("Genome of C1 before mutation: ");
        c1.printGenome();

        if (c1.same(c2)){
            System.out.println("C1 and C2 are identical");
        }
        else {
            System.out.println("C1 and C2 are different");
        }

        c1.mutate();
        c2.mutate();

        System.out.println("Genome of C1 after mutation: ");
        c1.printGenome();
        System.out.println("Genome of C2 after mutation: ");
        c2.printGenome();

        Coronavirus c3 = new Coronavirus("GAGA");
        Coronavirus c4 = new Coronavirus("AAGG");
        Coronavirus c5 = new Coronavirus("ATCG");

        if (c3.functionallySimilar(c4)){
            System.out.println("C3 and c4 are functionally similar");
        }
        else {
            System.out.println("C3 and c5 are not similar");
        }

        System.out.println("The edit distance between c4 and c5 is "+ c4.editDistance(c5));
    }
}
