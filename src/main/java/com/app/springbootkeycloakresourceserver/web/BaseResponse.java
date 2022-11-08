package com.app.springbootkeycloakresourceserver.web;

import java.util.List;
public class BaseResponse<T> {
    private T data;
    private boolean success = true;
    private ExceptionInfo error;
    private List<ValidationInfo> validations;
    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public BaseResponse() {
    }

    public BaseResponse(boolean success, ExceptionInfo error) {
        this.success = success;
        this.error = error;
    }

    public BaseResponse(boolean success, ExceptionInfo error, T data) {
        this.data = data;
        this.success = success;
        this.error = error;
    }

    public ExceptionInfo getError() {
        return this.error;
    }

    public void setError(ExceptionInfo error) {
        this.error = error;
    }

    public List<ValidationInfo> getValidations() {
        return this.validations;
    }

    public void setValidations(List<ValidationInfo> validations) {
        this.validations = validations;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "BaseResponse{data=" + this.data + ", success=" + this.success + ", error=" + this.error + ", validations=" + this.validations + "}";
    }
}