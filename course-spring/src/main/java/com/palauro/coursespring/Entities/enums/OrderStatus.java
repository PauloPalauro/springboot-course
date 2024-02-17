package com.palauro.coursespring.Entities.enums;

public enum OrderStatus {

    // Sem os codes = problema de manuteção. Com codes = Explicito.
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    // Codigo do enum
    private int code;

    // Construtor do enum "private"
    private OrderStatus(int code) {
        this.code = code;
    }

    // Code ficar acessivel
    public int getCode() {
        return code;
    }

    // Metodo estatico para converter um valor númerico para um tipo enum. Sem
    // instanciação.
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) { // Percorrer todos os valores possiveis do "OrderStatus".
            if (value.getCode() == code) { // Testa se o codigo é correspondente.
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code"); //Caso o OrderStatus code não exista.
    }
}
