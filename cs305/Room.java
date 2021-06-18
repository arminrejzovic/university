package cs305;

public class Room {
   private double length;
   private double width;
   private double height;

    private int[][] areaMatrix;

    public Room(double length, double width, double height) {
       setLength(length);
       setWidth(width);
       setHeight(height);

       initializeAreaMatrix();

    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length>0) this.length = length;
        else System.out.println("ERROR");
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width>0) this.width = width;
        else System.out.println("ERROR");
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height>0)this.height = height;
        else System.out.println("ERROR");
    }


    private void initializeAreaMatrix(){
        areaMatrix = new int[(int)length*4][(int)width*4];
        for (int i=0;i<length*4;i++){
            for (int j=0;j<width*4;j++){
                areaMatrix[i][j] = 0;
            }
        }
    }

    public void printRoomLayout(){
        for (int i=0;i<length*4;i++){
            for (int j=0;j<width*4;j++){
                System.out.print(this.areaMatrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public boolean canFurnitureFit(Furniture furniture){
        if (furniture.getHeight()>height) return false;
        if(!tryOnce(furniture)) return tryRotated(furniture);
        return tryOnce(furniture);
    }

    private boolean tryOnce(Furniture furniture){
        if(furniture.getWidth()>this.width) return false;
        else {
            int freeSlotsInRow = 0;
            for (int i=0;i<length*4;i++){
                for (int j=0;j<width*4;j++){
                    System.out.print(this.areaMatrix[i][j]+" ");
                }
                System.out.println("");
            }
        }
        return false;
    }

    private boolean tryRotated(Furniture furniture){
        return false;
    }
}
