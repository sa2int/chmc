package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum ShippingStatusType implements CodeEnum, EnumModel{
	ORDER_WAITING("A0", "주문대기"), SHIPPING_REQUEST("A1", "출고요청"), SHIPPING_READY("A2", "출고대기"),
	SHIPPING_CANCEL("A3", "출고취소"),
	SHIPPING_COMPLATE("A4", "출고완료"), SHIPPING_FINISHED("A5", "배송완료"), CHANGE_WAREHOUSING_READY("B1", "교환입고대기"),
	CHANGE_WAREHOUSING_REJECT("B2", "교환입고철회"), CHANGE_WAREHOUSING_COMPLATE("B3", "교환입고완료");

	private String code;
	private String codeName;

	ShippingStatusType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(ShippingStatusType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<ShippingStatusType> {
        public TypeHandler() {
            super(ShippingStatusType.class);
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
	
	
	public static ShippingStatusType getCodeEnum(String code) {
        for (ShippingStatusType element : ShippingStatusType.values()) {
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