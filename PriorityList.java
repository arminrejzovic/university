public class PriorityList {
    private Link head;
    private int count;

    public PriorityList() {
        head = null;
        count = 0;
    }

    public void insert(int x){
        var newLink = new Link(x);

        //Empty list, priority doesn't matter
        if(head == null){
            head = newLink;
        }
        //Higher priority than existing head
        else if(x < head.data){
            newLink.next = head;
            head = newLink;
        }
        //Lower priority than head, we must search for appropriate slot
        else {
            var current = head;
            var previous = head;

            while (x > current.data && current.next != null){
                previous = current;
                current = current.next;
            }

            previous.next = newLink;
            newLink.next = current;
        }

        count++;
    }

    public void printAll(){
        var current = head;
        var i = 0;
        StringBuilder sb = new StringBuilder();
        while (i<count){
            sb.append(current.data).append(" ≡ ");
            current = current.next;
            i++;
        }
        sb.append("\b\b\b");
        System.out.println(sb);
    }


    public static void main(String[] args) {
        var list = new PriorityList();
        list.insert(7);
        list.insert(12);
        list.insert(11);
        list.insert(5);
        list.insert(2);
        list.insert(1);
        list.insert(10);
        list.printAll();
    }
}
