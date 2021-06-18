package com.company;

public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public void setCount(int count) {
        if (count>0)
            this.count = count;
        else
            this.count = 0;
    }

    public void setToZero(){
        count=0;
    }

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
        if (count<0){
            count=0;
        }
    }

    public int getCount() {
        return count;
    }

    public void consolePrint(){
        System.out.println("Value of counter is: "+count);
    }

    @Override
    public String toString() {
        return "Value of counter is: "+count;
    }
}
