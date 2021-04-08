package com.github.sbouclier.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.sbouclier.result.common.OrderDirection;
import com.github.sbouclier.result.common.OrderType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Result from getTradesHistory
 *
 * @author Stéphane Bouclier
 */
public class TradesHistoryResult extends Result<TradesHistoryResult.TradesHistory> {

    public static class TradesHistory {

        @JsonProperty("trades")
        public Map<String, TradeHistory> trades;

        public Long count;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("trades", trades)
                    .append("count", count)
                    .toString();
        }
    }

    public static class TradeHistory {

        @JsonProperty("ordertxid")
        public String orderTransactionId;

        @JsonProperty("postxid")
        public String postxId;

        @JsonProperty("pair")
        public String assetPair;

        @JsonProperty("time")
        public String tradeTimestamp;

        @JsonProperty("type")
        public OrderDirection orderDirection;

        @JsonProperty("ordertype")
        public OrderType orderType;

        public BigDecimal price;

        public BigDecimal cost;

        public BigDecimal fee;

        @JsonProperty("vol")
        public BigDecimal volume;

        public BigDecimal margin;

        @JsonProperty("misc")
        public String miscellaneous;

        public String tradeId;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("orderTransactionId", orderTransactionId)
                    .append("postxId", postxId)
                    .append("assetPair", assetPair)
                    .append("tradeTimestamp", tradeTimestamp)
                    .append("orderDirection", orderDirection)
                    .append("orderType", orderType)
                    .append("price", price)
                    .append("cost", cost)
                    .append("fee", fee)
                    .append("volume", volume)
                    .append("margin", margin)
                    .append("miscellaneous", miscellaneous)
                    .toString();
        }
    }
}
