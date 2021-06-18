package com.company;

public class InvocationCounter
{
    //static variable belongs to the class
    //as awhole not just to one object.
    private static int numberOfInvocations = 0;

    public void demoMethod( )
    {
        numberOfInvocations++;
        //In a real example, more code would go here.
    }

    public void outPutCount( )
    {
        numberOfInvocations++;
        System.out.println("Number of invocations so far = "
                + numberOfInvocations);
    }

    public static int numberSoFar( )
    {
        numberOfInvocations++;
        return numberOfInvocations;
    }


}
