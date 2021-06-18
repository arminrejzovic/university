package Ungraded;

public class Clerk extends Employee {
    public Clerk(int id, String name, double salary, String department, String designation) {
        super(id, name, salary, department, designation);
    }

    public Clerk() {
        super();
    }

    @Override
    public double addBonus(){
        int bonus = 100;
        return this.getSalary()+bonus;
    }
}
