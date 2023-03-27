package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum JoinType implements CodeEnum, EnumModel{
	CELLPHONE("10", "휴대폰"), WECHAT("20", "위챗");

	private String code;
	private String codeName;

	JoinType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(JoinType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<JoinType> {
        public TypeHandler() {
            super(JoinType.class);
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
	
	
	public static JoinType getCodeEnum(String code) {
        for (JoinType element : JoinType.values()) {
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