package Ungraded;

public class Driver {
    public static void main(String[] args) {
        Employee employee = new Employee(1111,"John",1000,"IT","Junior developer");
        Manager manager1 = new Manager(2222,"Adam",2000,"IT","Senior developer");
        Manager manager2  = new Manager(3333,"Bob",3000,"IT","Project Manager");

        Clerk clerk = new Clerk(4444,"Steve",800,"Retail","Clerk");

        System.out.println(clerk.addBonus());
        System.out.println(manager1.addBonus());
        System.out.println(employee.addBonus());

        manager2.displayEmployee();
    }
}
