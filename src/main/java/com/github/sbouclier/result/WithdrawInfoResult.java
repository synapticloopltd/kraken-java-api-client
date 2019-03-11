package com.github.sbouclier.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class WithdrawInfoResult extends ResultWithLastId<Map<String, List<WithdrawInfoResult.WithdrawInfo>>> {

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @JsonPropertyOrder({"method", "limit", "fee"})
    public static class WithdrawInfo {
        public String method;
        public BigDecimal limit;
        public BigDecimal fee;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("method", method)
                    .append("limit", limit)
                    .append("fee", fee)
                    .toString();
        }
    }
}
