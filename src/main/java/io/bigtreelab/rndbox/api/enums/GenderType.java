package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum GenderType implements CodeEnum, EnumModel{
	FEMALE("F", "여자", "2"), MALE("M", "남자", "1");

	private String code;
	private String codeName;
	private String genderGubun;

	GenderType(String code, String codeName, String genderGubun) {
        this.code = code;
        this.codeName = codeName;
		this.genderGubun = genderGubun;
    }

    @MappedTypes(GenderType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<GenderType> {
        public TypeHandler() {
            super(GenderType.class);
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
	
	
	public static GenderType getCodeEnum(String code) {
        for (GenderType element : GenderType.values()) {
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

	public String getGenderGubun() {
		return genderGubun;
	}

}