package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum ClaimType implements CodeEnum, EnumModel{
	CHANGE("10", "교환클레임"), REFUND("20", "반환"), WITHDRAW("30", "회수"), PAY_MILEAGE_REFUND("40", "구매마일리지환불"),
	P2P_MILEAGE_REFUND("50", "P2P마일리지환불");

	private String code;
	private String codeName;

	ClaimType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(ClaimType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<ClaimType> {
        public TypeHandler() {
            super(ClaimType.class);
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
	
	
	public static ClaimType getCodeEnum(String code) {
        for (ClaimType element : ClaimType.values()) {
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