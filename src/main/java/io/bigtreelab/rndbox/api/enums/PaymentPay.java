package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum PaymentPay implements CodeEnum, EnumModel{
//    WECHAT_PAY("20", "위챗페이"),
//    ALI_PAY("30", "알리페이");
	WECHAT_PAY("20", "微信支付"),
	ALI_PAY("30", "支付宝");

	private String code;
	private String codeName;

	PaymentPay(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(PaymentPay.class)
    public static class TypeHandler extends CodeEnumTypeHandler<PaymentPay> {
        public TypeHandler() {
            super(PaymentPay.class);
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
	
	
	public static PaymentPay getCodeEnum(String code) {
        for (PaymentPay element : PaymentPay.values()) {
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
