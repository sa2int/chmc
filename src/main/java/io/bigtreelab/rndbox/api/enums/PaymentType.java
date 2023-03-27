package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum PaymentType implements CodeEnum, EnumModel{
	CONFIRM("10", "승인"), 
	CONFIRM_CANCEL("20", "승인취소");

	private String code;
	private String codeName;

	PaymentType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(PaymentType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<PaymentType> {
        public TypeHandler() {
            super(PaymentType.class);
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
	
	
	public static PaymentType getCodeEnum(String code) {
        for (PaymentType element : PaymentType.values()) {
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
