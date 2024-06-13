package com.homework.student.model;

public class LoginResponse {
    private boolean isSuccess;

    public LoginResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
