package com.palex.Rest.view;

/**
 * Класс передаци состояния ошибки клиенту.
 */
public class ErrorResponseView {

    /**
     * Сообщение об ошибке.
     */

    public final String error;

    /**
     * Конструкор поумолчанию.
     */
    public ErrorResponseView() {
        this.error = "Error occurred";
    }

    /**
     * Конструктор для передачи текста ошибки клиенту.
     * @param error текст ошибки.
     */
    public ErrorResponseView(String error) {
        this.error = error;
    }
}
