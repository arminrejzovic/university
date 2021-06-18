package SE221;

/*
Armin Rejzović 190302077
Veldin Salčinović 190302158
 */

import java.util.Random;

public class Coronavirus implements Viral {
    private String genome;


    public Coronavirus(String genome) {
        for (int i=0;i<genome.length();i++){
            if (genome.length()>30000){
                System.out.println("Error: The coronavirus genome contains no more than 30 thousand aminoacids");
                System.exit(0);
            }
            if (!(genome.charAt(i)=='A' || genome.charAt(i)=='T'|| genome.charAt(i)=='C'|| genome.charAt(i)=='G')){
                System.out.println("Error: Genome can only contain A,T,G or C");
                System.exit(0);
            }

        }
        this.genome = genome;
    }

    public Coronavirus(){
        this.genome = "ATCGAGCTAAAG";
    }

    /*public int genomeLength(){
        return genome.length();
    }*/

    public void printGenome(){
        System.out.println(genome);
    }


    @Override
    public void mutate() {
        Random random = new Random();
        int position = random.nextInt(genome.length());
        StringBuilder genomeBuilder = new StringBuilder(genome);
        char character = genomeBuilder.charAt(position);
        switch (character){
            case 'A':{
                char replacement = randomGenome('T','C','G');
                genomeBuilder.setCharAt(position,replacement);
                break;
            }
            case 'T':{
                char replacement = randomGenome('A','C','G');
                genomeBuilder.setCharAt(position,replacement);
                break;
            }
            case 'C':{
                char replacement = randomGenome('T','A','G');
                genomeBuilder.setCharAt(position,replacement);
                break;
            }
            case 'G':{
                char replacement = randomGenome('T','C','A');
                genomeBuilder.setCharAt(position,replacement);
                break;
            }
        }
        genome = genomeBuilder.toString();

    }

    @Override
    public boolean same(Coronavirus c) {
        if (c==null) return false;
        return this.genome.equals(c.genome);
    }

    @Override
    public boolean functionallySimilar(Coronavirus c) {
        int adenineCountOriginal = 0;
        int thymineCountOriginal = 0;
        int cytosineCountOriginal = 0;
        int guanineCountOriginal = 0;

        for (int i=0;i<this.genome.length();i++){
            if (this.genome.charAt(i)=='A')
                adenineCountOriginal++;
            else  if (this.genome.charAt(i)=='T')
                thymineCountOriginal++;
            else  if (this.genome.charAt(i)=='C')
                cytosineCountOriginal++;
            else  if (this.genome.charAt(i)=='G')
                guanineCountOriginal++;
        }

        int adenineCountOther = 0;
        int thymineCountOther = 0;
        int cytosineCountOther = 0;
        int guanineCountOther = 0;

        for (int i=0;i<c.genome.length();i++){
            if (c.genome.charAt(i)=='A')
                adenineCountOther++;
            else  if (c.genome.charAt(i)=='T')
                thymineCountOther++;
            else  if (c.genome.charAt(i)=='C')
                cytosineCountOther++;
            else  if (c.genome.charAt(i)=='G')
                guanineCountOther++;
        }

        return adenineCountOriginal == adenineCountOther && thymineCountOriginal == thymineCountOther
                && cytosineCountOriginal == cytosineCountOther && guanineCountOriginal == guanineCountOther;

    }

    @Override
    public int editDistance(Coronavirus c) {
        int len1 = this.genome.length();
        int len2 = c.genome.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < len1; i++) {
            char c1 = this.genome.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = c.genome.charAt(j);

                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = Math.min(replace, insert);
                    min = Math.min(delete, min);
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];
    }

    private static char randomGenome(char a, char b, char c){
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice){
            case 0: return a;
            case 1: return b;
            case 2: return c;
            default: return 'e';
        }
    }

    /*public Coronavirus (){
        this.genome = "AAAATTTTCCCCGGGG";  //creator
    }

    public void setGenome(String genome){
        this.genome = genome;  //mutator
    }

    public long genomeLength(){
        return genome.length();  //observer
    }

    public Coronavirus fuse(Coronavirus c1, Coronavirus c2){
        this.genome = c1.genome.concat(c2.genome); //producer
    }*/
}
