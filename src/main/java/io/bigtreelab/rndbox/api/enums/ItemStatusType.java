package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum ItemStatusType implements CodeEnum, EnumModel {

	// VALID("10", "사용가능"), UESD("20", "사용완료"), FINISHED("30", "기간만료");
	VALID("10", "可用的"), UESD("20", "已使用"), FINISHED("30", "已过期");

	private String code;
	private String codeName;

	ItemStatusType(String code, String codeName) {
		this.code = code;
		this.codeName = codeName;
	}

	@MappedTypes(ItemStatusType.class)
	public static class TypeHandler extends CodeEnumTypeHandler<ItemStatusType> {
		public TypeHandler() {
			super(ItemStatusType.class);
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

	public static ItemStatusType getCodeEnum(String code) {
		for (ItemStatusType element : ItemStatusType.values()) {
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
