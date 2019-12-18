package com.palex.Rest.view;

/**
 * Класс передаци состояния ошибки клиенту.
 */
public class ErrorView {

    /**
     * Сообщение об ошибке.
     */
    public final String error;

    /**
     * Конструктор для передачи текста ошибки клиенту.
     * @param error текст ошибки.
     */
    public ErrorView(String error) {
        this.error = error;
    }
}
