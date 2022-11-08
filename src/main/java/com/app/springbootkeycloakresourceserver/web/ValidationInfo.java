package com.app.springbootkeycloakresourceserver.web;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
@JsonDeserialize(
        builder = ValidationInfo.ValidationInfoBuilder.class
)
public class ValidationInfo {
    private String type;
    private String message;
    public String toString() {
        return "ValidationInfo{type='" + this.type + "', message='" + this.message + "'}";
    }

    ValidationInfo(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public static ValidationInfoBuilder builder() {
        return new ValidationInfoBuilder();
    }

    public ValidationInfoBuilder toBuilder() {
        return (new ValidationInfoBuilder()).type(this.type).message(this.message);
    }

    public String getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonPOJOBuilder(
            withPrefix = ""
    )
    public static class ValidationInfoBuilder {
        private String type;
        private String message;
        ValidationInfoBuilder() {
        }

        public ValidationInfoBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ValidationInfoBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ValidationInfo build() {
            return new ValidationInfo(this.type, this.message);
        }

        public String toString() {
            return "ValidationInfo.ValidationInfoBuilder(type=" + this.type + ", message=" + this.message + ")";
        }
    }
}