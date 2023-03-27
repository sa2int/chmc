package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum OrderMockupType implements CodeEnum, EnumModel{
	
	MILEAGE("10", "마일리지"), PRODUCT("20", "상품"), SHIPPING_FEE("30", "배송비"),;

	private String code;
	private String codeName;

	OrderMockupType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

	@MappedTypes(OrderMockupType.class)
	public static class TypeHandler extends CodeEnumTypeHandler<OrderMockupType> {
        public TypeHandler() {
			super(OrderMockupType.class);
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
	
	
	public static OrderMockupType getCodeEnum(String code) {
		for (OrderMockupType element : OrderMockupType.values()) {
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
