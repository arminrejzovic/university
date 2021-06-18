package cs305;

public class Test {

    public static void main(String[] args) {
        int[][] areaMatrix = new int[7][4];

        for (int i=0;i<7;i++){
            for (int j=0;j<4;j++){
                areaMatrix[i][j] = 0;
            }
        }

        for (int i=0;i<4;i++){
            areaMatrix[i][2] = 2;
            areaMatrix[3][i] = 3;
        }


        for (int i=0;i<7;i++){
            for (int j=0;j<4;j++){
                System.out.print(areaMatrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(areaMatrix.length);

    }
}
