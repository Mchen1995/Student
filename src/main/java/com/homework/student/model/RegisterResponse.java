package com.homework.student.model;

public class RegisterResponse {
    boolean isSuccess;

    public RegisterResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
