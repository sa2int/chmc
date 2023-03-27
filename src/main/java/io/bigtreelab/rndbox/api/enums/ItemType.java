package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum ItemType implements CodeEnum, EnumModel {

	// SHAKE("10", "흔들기"), HINT("20", "힌트카드"), SEE("30", "투시카드");
	SHAKE("10", "摇"), HINT("20", "暗示"), SEE("30", "看");

	private String code;
	private String codeName;

	ItemType(String code, String codeName) {
		this.code = code;
		this.codeName = codeName;
	}

	@MappedTypes(ItemType.class)
	public static class TypeHandler extends CodeEnumTypeHandler<ItemType> {
		public TypeHandler() {
			super(ItemType.class);
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

	public static ItemType getCodeEnum(String code) {
		for (ItemType element : ItemType.values()) {
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
