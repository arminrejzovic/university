package FinalExam;

public class Roundabout {

    private Point first;
    private Point last;
    private int length;

    public Roundabout() {
        first = null;
        last = null;
    }

    //helper method to find current point
    public Point at(int index) {
        Point current = first;
        int count = 0;
        while (current != null) {
            if (count == index){
                return current;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    public Point nextBlue(int position){
        if (position>length){
            throw new IndexOutOfBoundsException("Point doesn't exist");
        }
        Point point = this.at(position).next;
        while (!point.color.equals("blue")){
            point = point.next;
        }
        return point;
    }
}
