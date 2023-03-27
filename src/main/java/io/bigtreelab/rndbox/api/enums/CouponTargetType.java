package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum CouponTargetType implements CodeEnum, EnumModel {

	PRODUCT("10", "단품쿠폰"), MULTI_PRODUCT("20", "다품쿠폰"), SHIPPING_FEE("30", "배송비쿠폰");

	private String code;
	private String codeName;

	CouponTargetType(String code, String codeName) {
		this.code = code;
		this.codeName = codeName;
	}

	@MappedTypes(CouponTargetType.class)
	public static class TypeHandler extends CodeEnumTypeHandler<CouponTargetType> {
		public TypeHandler() {
			super(CouponTargetType.class);
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

	public static CouponTargetType getCodeEnum(String code) {
		for (CouponTargetType element : CouponTargetType.values()) {
			if (element.code.equalsIgnoreCase(code)) {
				return element;
			}
		}
		return null;
	}

	public static String getCodeEnumName(String code) {
		for (CouponTargetType element : CouponTargetType.values()) {
			if (element.code.equalsIgnoreCase(code)) {
				return element.getCodeName();
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
