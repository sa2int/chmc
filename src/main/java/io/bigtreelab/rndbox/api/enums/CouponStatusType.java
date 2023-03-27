package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum CouponStatusType implements CodeEnum, EnumModel {
	// [10]사용가능, [20]사용완료, [30]기간만료
	VALID("10", "可用的"), UESD("20", "已过期"), FINISHED("30", "已过期");

	private String code;
	private String codeName;

	CouponStatusType(String code, String codeName) {
		this.code = code;
		this.codeName = codeName;
	}

	@MappedTypes(CouponStatusType.class)
	public static class TypeHandler extends CodeEnumTypeHandler<CouponStatusType> {
		public TypeHandler() {
			super(CouponStatusType.class);
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

	public static CouponStatusType getCodeEnum(String code) {
		for (CouponStatusType element : CouponStatusType.values()) {
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
