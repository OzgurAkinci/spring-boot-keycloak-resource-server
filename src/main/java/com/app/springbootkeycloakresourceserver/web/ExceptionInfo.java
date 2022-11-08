package com.app.springbootkeycloakresourceserver.web;

public class ExceptionInfo {
    private String errorCode;
    private String message;
    private String messageType;
    private String detailedMessage;
    private String errorPage;
    private String type;
    private String sourceSystem;
    public ExceptionInfo() {
    }

    public ExceptionInfo(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailedMessage() {
        return this.detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    public String getErrorPage() {
        return this.errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceSystem() {
        return this.sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String toString() {
        return "ExceptionInfo{errorCode='" + this.errorCode + "', message='" + this.message + "', messageType='" + this.messageType + "', detailedMessage='" + this.detailedMessage + "', errorPage='" + this.errorPage + "', type='" + this.type + "', sourceSystem='" + this.sourceSystem + "'}";
    }
}