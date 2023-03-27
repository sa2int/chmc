package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum BannerType implements CodeEnum, EnumModel{
	MAIN_BANNER("10", "메인배너"), SUB_BANNER("20", "서브배너");

	private String code;
	private String codeName;

	BannerType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(BannerType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<BannerType> {
        public TypeHandler() {
            super(BannerType.class);
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
	
	
	public static BannerType getCodeEnum(String code) {
        for (BannerType element : BannerType.values()) {
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