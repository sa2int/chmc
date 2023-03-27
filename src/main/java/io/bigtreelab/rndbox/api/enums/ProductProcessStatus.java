package io.bigtreelab.rndbox.api.enums;

import org.apache.ibatis.type.MappedTypes;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public enum ProductProcessStatus implements CodeEnum, EnumModel{
	
	/*
	 * ORDER_WAITING("A0", "주문대기"), SELLING_WAITING("A1", "판매대기"), SELLING("A2", "판매중"),
	 * STOP_SELLING("A3", "일시중지"), SOLD_OUT("A4", "품절"), SELLING_COMPLETED("A5", "판매완료"),
	 * ELLING_REJECT("A6", "판매철회"), EXCHANGE("A7", "반품교환판매"), PERIOD_FINISHED("A8", "기간종료"),
	 * PAY_CANCEL("A9", "결제취소"), WAITING("B1", "대기"), SHIPPING_REQUEST("B2", "배송요청"),
	 * SHIPPING_WAITING("B3", "배송대기"), SHIPPING("B4", "배송중"), SHIPPING_COMPLETED("B5", "발송완료"),
	 * SHIPPING_REJECT("B6", "배송철회") ;
	 */
	ORDER_WAITING("A0", "等待订单"), SELLING_WAITING("A1", "待售"), SELLING("A2", "销售"), STOP_SELLING("A3", "暂停"),
	SOLD_OUT("A4", "售罄"),
	SELLING_COMPLETED("A5", "售罄"), SELLING_REJECT("A6", "撤回销售"), EXCHANGE("A7", "退货换货销售"), PERIOD_FINISHED("A8", "期末"),
	PAY_CANCEL("A9", "取消付款"),
	WAITING("B1", "等待"), SHIPPING_REQUEST("B2", "交货请求"), SHIPPING_WAITING("B3", "等待发货"),
	SHIPPING("B4", "航运"), SHIPPING_COMPLETED("B5", "发送完成"), SHIPPING_REJECT("B6", "提货");

	private String code;
	private String codeName;

	ProductProcessStatus(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(ProductProcessStatus.class)
    public static class TypeHandler extends CodeEnumTypeHandler<ProductProcessStatus> {
        public TypeHandler() {
            super(ProductProcessStatus.class);
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
	
	
	public static ProductProcessStatus getCodeEnum(String code) {
        for (ProductProcessStatus element : ProductProcessStatus.values()) {
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
