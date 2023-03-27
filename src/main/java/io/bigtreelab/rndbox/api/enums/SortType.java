package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum SortType implements CodeEnum, EnumModel{
	
    LIKE("10", "찜"),
    SELL_START_DATE("20", "판매시작일"),
	SALES_QTY("30", "판매량"),
	LOW_PRICE("40", "낮은가격");

	private String code;
	private String codeName;

	SortType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(SortType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<SortType> {
        public TypeHandler() {
            super(SortType.class);
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
	
	
	public static SortType getCodeEnum(String code) {
        for (SortType element : SortType.values()) {
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
