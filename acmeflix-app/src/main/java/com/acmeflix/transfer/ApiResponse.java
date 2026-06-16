package com.acmeflix.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ApiResponse<T> implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date createdAt = new Date();

    private T data;
    private ApiError apiError;

    public ApiResponse() {
    }

    public ApiResponse(Date createdAt, T data, ApiError apiError) {
        this.createdAt = createdAt;
        this.data = data;
        this.apiError = apiError;
    }

    public ApiResponse(T data, ApiError apiError) {
        this.data = data;
        this.apiError = apiError;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "createdAt=" + createdAt +
                ", data=" + data +
                ", apiError=" + apiError +
                '}';
    }
}
