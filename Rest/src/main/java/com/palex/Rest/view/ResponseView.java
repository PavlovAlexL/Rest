package com.palex.Rest.view;

public class ResponseView {

    public Object data;

    public ResponseView(Object data) {
        this.data = data;
    }

    public ResponseView() {
        this.data = "Success";
    }
}
