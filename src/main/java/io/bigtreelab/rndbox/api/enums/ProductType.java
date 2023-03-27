package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum ProductType implements CodeEnum, EnumModel{
	
	BLIND_BOX("B", "블라인드박스"),
	CHEIL_LOTTERY("T", "제일복권"),
	CAPSULE_TOY("C", "캡슐토이"),
	SALE("S", "특가상품"), INVENTORY("I", "재고상품");

	private String code;
	private String codeName;

	ProductType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(ProductType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<ProductType> {
        public TypeHandler() {
            super(ProductType.class);
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
	
	
	public static ProductType getCodeEnum(String code) {
        for (ProductType element : ProductType.values()) {
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
