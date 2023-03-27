package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum GiftRewardType implements CodeEnum, EnumModel{

	// COUPON("10", "쿠폰"), MILEAGE("20", "마일리지 里程"), ITEM("30", "아이템");
	COUPON("10", "优惠券"), MILEAGE("20", "星币支付"), ITEM("30", "物品");

	private String code;
	private String codeName;

	GiftRewardType(String code, String codeName) {
		this.code = code;
		this.codeName = codeName;
	}

    @MappedTypes(GiftRewardType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<GiftRewardType> {
        public TypeHandler() {
            super(GiftRewardType.class);
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
	
	
	public static GiftRewardType getCodeEnum(String code) {
        for (GiftRewardType element : GiftRewardType.values()) {
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
