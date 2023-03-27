package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum MileageAddUseType implements CodeEnum, EnumModel{

	ADD_WECHAT_PAY("A1", "위챗페이 충전", "微信充值"), ADD_RETURN("A2", "반환적립", "恢复补偿"), ADD_WITHDRAW("A3", "회수 보상", "回收奖励"),
	ADD_SHIPPING("A4", "배송비반환", "退货运费"), ADD_P2P("A5", "P2P적립", "P2P积累"), ADD_EVENT("A6", "이벤트 보상", "活动奖励"),
	ADD_ALI_PAY("A7", "알리페이 충전", "支付宝充值"), ADD_ETC("A8", "기타 증정", "其他礼物"), USE_ORDER("B1", "구매", "购买"),
	USE_SHIPPING("B2", "배송비 결제", "邮寄费用"), USE_REFUND("B3", "고객센터 차감", "客服扣除"), USE_P2P("B4", "P2P구매차감", "P2P购买扣除");


	private String code;
	private String codeName;
	private String codeName4User; // 마이페이지 마일리지 페이지에 사용되는 값.

	MileageAddUseType(String code, String codeName, String codeName4User) {
		this.code = code;
		this.codeName = codeName;
		this.codeName4User = codeName4User;
	}

    @MappedTypes(MileageAddUseType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<MileageAddUseType> {
        public TypeHandler() {
            super(MileageAddUseType.class);
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
	
	
	public static MileageAddUseType getCodeEnum(String code) {
        for (MileageAddUseType element : MileageAddUseType.values()) {
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

	public static String getCodeEnumName4user(String code) {
		for (MileageAddUseType element : MileageAddUseType.values()) {
			if (element.code.equalsIgnoreCase(code)) {
				return element.getCodeName4User();
			}
		}
		return null;
	}

	public String getCodeName4User() {
		// TODO Auto-generated method stub
		return codeName4User;
	}

	
}	
