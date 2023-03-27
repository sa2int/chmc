package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum OrderStatus implements CodeEnum, EnumModel{
	
	ORDER_WAITING("10", "주문대기"), COMPLETE("20", "주문완료"), PAY_CANCEL("30", "결제취소");

	private String code;
	private String codeName;

	OrderStatus(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(OrderStatus.class)
    public static class TypeHandler extends CodeEnumTypeHandler<OrderStatus> {
        public TypeHandler() {
            super(OrderStatus.class);
        }
    }

    @Override
    public String getCode() {
        return code;
    }

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return name();
	}
	
	
	public static OrderStatus getCodeEnum(String code) {
        for (OrderStatus element : OrderStatus.values()) {
            if (element.code.equalsIgnoreCase(code)) {
                return element;
            }
        }
        return null;
    }

	@Override
	public String getCodeName() {
		// TODO Auto-generated method stub
		return codeName;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return code;
	}

	
}	
