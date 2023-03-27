package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum UserInventoryStatusType implements CodeEnum, EnumModel{
	
	ORDER_WAITING("00", "주문대기"), WAITING("10", "대기"), SHIPPING("20", "출고"), P2P("30", "판매"), REFUND("40", "반환"),
	WITHDRAW("50", "회수"), ADMIN_CONFIRM("60", "회수완료"), PAY_CANCEL("70", "결제취소");

	private String code;
	private String codeName;

	UserInventoryStatusType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(UserInventoryStatusType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<UserInventoryStatusType> {
        public TypeHandler() {
            super(UserInventoryStatusType.class);
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
	
	
	public static UserInventoryStatusType getCodeEnum(String code) {
        for (UserInventoryStatusType element : UserInventoryStatusType.values()) {
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
