package com.palex.Rest.view;

public class ErrorView {

    public final String error;

    public ErrorView() {
        this.error = "Error occurred";
    }

    public ErrorView(String error) {
        this.error = error;
    }
}
