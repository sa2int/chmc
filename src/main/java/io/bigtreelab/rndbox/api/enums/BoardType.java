package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum BoardType implements CodeEnum, EnumModel{
	NOTICE("10", "공지사항"), FAQ("20", "FAQ"), INQUERY("30", "1:1문의");

	private String code;
	private String codeName;

	BoardType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(BoardType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<BoardType> {
        public TypeHandler() {
            super(BoardType.class);
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
	
	
	public static BoardType getCodeEnum(String code) {
        for (BoardType element : BoardType.values()) {
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