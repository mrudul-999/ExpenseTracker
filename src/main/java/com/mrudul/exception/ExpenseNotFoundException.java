package com.mrudul.exception;

public class ExpenseNotFoundException extends Exception{

    public ExpenseNotFoundException()
    {
        super("No such expense was found lol :) hehe try adding pooks");
    }

    public ExpenseNotFoundException(String message)
    {
        super(message);
    }

}
