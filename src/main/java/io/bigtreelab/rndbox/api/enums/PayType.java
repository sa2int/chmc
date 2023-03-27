package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum PayType implements CodeEnum, EnumModel{

	PRODUCT("10", "상품"), SHIPPING_FEE("20", "배송비"), MILEAGE("30", "마일리지");

	private String code;
	private String codeName;

	PayType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(PayType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<PayType> {
        public TypeHandler() {
            super(PayType.class);
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
	
	
	public static PayType getCodeEnum(String code) {
        for (PayType element : PayType.values()) {
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
