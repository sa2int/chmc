package io.bigtreelab.rndbox.api.enums;

import io.bigtreelab.rndbox.api.domain.EnumModel;
import org.apache.ibatis.type.MappedTypes;

public enum QuitType implements CodeEnum, EnumModel {

    QUIT("10", "상품"), QUIT_WAITING("20", "배송비"), QUIT_COMPLETE("30", "마일리지");

    private String code;
    private String codeName;

    QuitType(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @MappedTypes(QuitType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<QuitType> {
        public TypeHandler() {
            super(QuitType.class);
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


    public static QuitType getCodeEnum(String code) {
        for (QuitType element : QuitType.values()) {
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