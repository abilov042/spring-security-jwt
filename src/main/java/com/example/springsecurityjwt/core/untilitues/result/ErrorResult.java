package com.example.springsecurityjwt.core.untilitues.result;

public class ErrorResult extends Result{
    public ErrorResult(String message) {
        super(true, message);
    }

    public ErrorResult(){
        super(true);
    }
}
