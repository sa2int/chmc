package io.bigtreelab.rndbox.api.handlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import io.bigtreelab.rndbox.api.enums.BannerType;

public class JoinTypeHandler extends BaseTypeHandler<BannerType> {

	public void setNonNullParameter(PreparedStatement ps, int i, BannerType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public BannerType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return BannerType.getCodeEnum(columnName);
    }

    @Override
    public BannerType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return BannerType.valueOf(rs.getString(columnIndex));
    }

    @Override
    public BannerType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return BannerType.valueOf(cs.getString(columnIndex));
    }
}