package Ungraded;

public class Manager extends Employee{
    public Manager(int id, String name, double salary, String department, String designation) {
        super(id, name, salary, department, designation);
    }

    public Manager() {
        super();
    }

    @Override
    public double addBonus(){
        int bonus = 300;
        return this.getSalary()+bonus;
    }

}
