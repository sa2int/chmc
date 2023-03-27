package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum SellOptionType implements CodeEnum, EnumModel{
	
    PRIZE("10", "상품단위"),
	PACKAGE("20", "세트(통판) 단위"),
	REMAINDER("30", "나머지");

	private String code;
	private String codeName;

	SellOptionType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(SellOptionType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<SellOptionType> {
        public TypeHandler() {
            super(SellOptionType.class);
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
	
	
	public static SellOptionType getCodeEnum(String code) {
        for (SellOptionType element : SellOptionType.values()) {
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
