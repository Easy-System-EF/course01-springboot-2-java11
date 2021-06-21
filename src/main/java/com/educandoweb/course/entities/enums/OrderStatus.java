package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITTING_PAYMENT(1), 
	PAID(2),
	SHIPPED(3), 
	DELIVERED(4),  
	CANECELED(5);
	
// codigo do tipo enumerado	
	private int code;
	
// construtor especial recebendo o code
	private OrderStatus(int code) {
		this.code = code;
	}
	
// metodo  retornando code	
	public int getCode() {
		return code;
	}
	
// metodo para converter o valor numerico para tipo enumerado- static nao precisa instanciar
// percorrendo OS	
	public static OrderStatus valueOff(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderS tatus code");
	}
}
 