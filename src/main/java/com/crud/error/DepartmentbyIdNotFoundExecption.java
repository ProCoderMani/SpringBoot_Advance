package com.crud.error;

// this class extends Throwable and is responsibe for execption handling
public class DepartmentbyIdNotFoundExecption extends Throwable {

    public DepartmentbyIdNotFoundExecption() {
    }

    public DepartmentbyIdNotFoundExecption(String message) {
        super(message);
    }

    public DepartmentbyIdNotFoundExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentbyIdNotFoundExecption(Throwable cause) {
        super(cause);
    }

    public DepartmentbyIdNotFoundExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
