package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum MileageType implements CodeEnum, EnumModel{
	
	BUY("10", "적립마일리지"), P2P("20", "P2P거래마일리지"), EVENT("30", "이벤트마일리지"), TOTAL("40", "마일리지 합계");

	private String code;
	private String codeName;

	MileageType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(MileageType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<MileageType> {
        public TypeHandler() {
            super(MileageType.class);
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
	
	
	public static MileageType getCodeEnum(String code) {
        for (MileageType element : MileageType.values()) {
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
