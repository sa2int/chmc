package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum ShippingType implements CodeEnum, EnumModel{
	SHIPPING("10", "정상출고"), CHANGE_SHIPPING("20", "교환출고"), CHANGE_WAREHOUSING("30", "교환입고");

	private String code;
	private String codeName;

	ShippingType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(ShippingType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<ShippingType> {
        public TypeHandler() {
            super(ShippingType.class);
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
	
	
	public static ShippingType getCodeEnum(String code) {
        for (ShippingType element : ShippingType.values()) {
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