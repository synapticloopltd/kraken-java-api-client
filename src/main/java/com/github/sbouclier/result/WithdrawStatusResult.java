package com.github.sbouclier.result;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

public class WithdrawStatusResult extends Result<List<WithdrawStatusResult.WithdrawStatus>> {

    @JsonPropertyOrder({"method", "aclass", "asset", "refid", "txid", "info", "amount", "fee", "time", "status"})
    public static class WithdrawStatus {
        public String method;
        public String aclass;
        public String asset;
        public String refid;
        public String txid;
        public String info;
        public BigDecimal amount;
        public BigDecimal fee;
        public String time;
        public String status;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("method", method)
                    .append("aclass", aclass)
                    .append("asset", asset)
                    .append("refid", refid)
                    .append("txid", txid)
                    .append("info", info)
                    .append("amount", amount)
                    .append("fee", fee)
                    .append("time", time)
                    .append("status", status)
                    .toString();
        }
    }
}
