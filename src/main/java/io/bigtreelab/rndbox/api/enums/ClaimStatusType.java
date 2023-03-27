package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum ClaimStatusType implements CodeEnum, EnumModel{
	WAIT("10", "접수"), PROCESS("20", "처리중"), COMPLETE("30", "처리완료");

	private String code;
	private String codeName;

	ClaimStatusType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(ClaimStatusType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<ClaimStatusType> {
        public TypeHandler() {
            super(ClaimStatusType.class);
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
	
	
	public static ClaimStatusType getCodeEnum(String code) {
        for (ClaimStatusType element : ClaimStatusType.values()) {
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