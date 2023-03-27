package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum PaymentMethod implements CodeEnum, EnumModel{
	// MILEAGE("10", "마일리지 里程", "N"), WECHAT_PAY("20", "위챗페이", "Y"), ALI_PAY("30", "알리페이", "Y");
	MILEAGE("10", "星币支付", "N"), WECHAT_PAY("20", "微信支付", "Y"), ALI_PAY("30", "支付宝", "Y");

	private String code;
	private String codeName;
	private String onlyPay; // 페이인 경우만 Y

	PaymentMethod(String code, String codeName, String onlyPay) {
        this.code = code;
        this.codeName = codeName;
		this.onlyPay = onlyPay;
    }

    @MappedTypes(PaymentMethod.class)
    public static class TypeHandler extends CodeEnumTypeHandler<PaymentMethod> {
        public TypeHandler() {
            super(PaymentMethod.class);
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
	
	
	public static PaymentMethod getCodeEnum(String code) {
        for (PaymentMethod element : PaymentMethod.values()) {
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
