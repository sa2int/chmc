package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum CouponBaseType implements CodeEnum, EnumModel{
	
	PUBLISH("10", "발행일기준"), DOWNLOAD("20", "다운로드기준"),;

	private String code;
	private String codeName;

	CouponBaseType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(CouponBaseType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<CouponBaseType> {
        public TypeHandler() {
            super(CouponBaseType.class);
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
	
	
	public static CouponBaseType getCodeEnum(String code) {
        for (CouponBaseType element : CouponBaseType.values()) {
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
