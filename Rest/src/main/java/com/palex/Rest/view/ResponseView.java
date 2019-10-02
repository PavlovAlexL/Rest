package com.palex.Rest.view;

/**
 * Класс ответа клиенту.
 */
public class ResponseView {

    /**
     * Тело ответа.
     */
    public Object data;

    /**
     * Конструктор, для передачи данных клиенту.
     * @param data
     */
    public ResponseView(Object data) {
        this.data = data;
    }

    /**
     * Конструктор для передачи статуста успешной операции.
     */
    public ResponseView() {
        this.data = "Success";
    }
}
