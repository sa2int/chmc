package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;


public enum InqueryType implements CodeEnum, EnumModel{
	
	// SHIPPING("10", "배송관련"), EVENT("20", "EVENT"), ERROR("30", "오류", )
	// , COMPLAIN("40", "고객응대불만"), PRODUCT_SUGGEST("50", "제품건의"), ETC("60", "기타의견");
	SHIPPING("10", "航运"), EVENT("20", "事件"), ERROR("30", "错误相关"), COMPLAIN("40", "客服投诉"),
	PRODUCT_SUGGEST("50", "产品建议"), ETC("60", "其他意见");

	private String code;
	private String codeName;

	InqueryType(String code, String codeName) {
		this.code = code;
		this.codeName = codeName;
	}

    @MappedTypes(InqueryType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<InqueryType> {
        public TypeHandler() {
            super(InqueryType.class);
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
	
	
	public static InqueryType getCodeEnum(String code) {
        for (InqueryType element : InqueryType.values()) {
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