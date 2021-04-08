package com.github.sbouclier.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.github.sbouclier.result.common.OrderDirection;
import com.github.sbouclier.result.common.OrderType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Result from getClosedOrders
 *
 * @author Stéphane Bouclier
 */
public class ClosedOrdersResult extends Result<ClosedOrdersResult.ClosedOrders> {

    public static class ClosedOrders {

        @JsonProperty("closed")
        public Map<String, ClosedOrder> closed;

        public Long count;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("closed", closed)
                    .toString();
        }
    }

    public static class ClosedOrder {

        public enum Status {
            PENDING("pending"),
            OPEN("open"),
            CLOSED("closed"),
            CANCELED("canceled"),
            EXPIRED("expired");

            private String value;

            Status(String value) {
                this.value = value;
            }

            @JsonValue
            public String getValue() {
                return value;
            }
        }

        @JsonProperty("limitprice")
        public BigDecimal limitPrice;

        @JsonProperty("refid")
        public String referralOrderTransactionId;

        @JsonProperty("userref")
        public String userReferenceId;

        public Status status;

        @JsonProperty("opentm")
        public Long openTimestamp;

        @JsonProperty("starttm")
        public Long orderStartTimestamp;

        @JsonProperty("expiretm")
        public Long orderEndTimestamp;

        @JsonProperty("descr")
        public Description description;

        @JsonProperty("vol")
        public BigDecimal volumeOrder;

        @JsonProperty("vol_exec")
        public BigDecimal volumeExecuted;

        public BigDecimal cost;

        public BigDecimal fee;

        @JsonProperty("price")
        public BigDecimal averagePrice;

        @JsonProperty("stopprice")
        public BigDecimal stopPrice;

        public static class Description {

            @JsonProperty("pair")
            public String assetPair;

            @JsonProperty("type")
            public OrderDirection orderDirection;

            @JsonProperty("ordertype")
            public OrderType orderType;

            public BigDecimal price;

            @JsonProperty("price2")
            public BigDecimal secondaryPrice;

            public String leverage;

            public String order;

            public String close;

            @Override
            public String toString() {
                return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                        .append("assetPair", assetPair)
                        .append("orderDirection", orderDirection)
                        .append("orderType", orderType)
                        .append("price", price)
                        .append("secondaryPrice", secondaryPrice)
                        .append("leverage", leverage)
                        .append("order", order)
                        .append("close", close)
                        .toString();
            }
        }

        @JsonProperty("misc")
        public String miscellaneous;

        @JsonProperty("oflags")
        public String orderFlags;

        public String reason;

        @JsonProperty("closetm")
        public Long orderClosedTimestamp;

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("referralOrderTransactionId", referralOrderTransactionId)
                    .append("userReferenceId", userReferenceId)
                    .append("status", status)
                    .append("openTimestamp", openTimestamp)
                    .append("orderStartTimestamp", orderStartTimestamp)
                    .append("orderEndTimestamp", orderEndTimestamp)
                    .append("description", description)
                    .append("volumeOrder", volumeOrder)
                    .append("volumeExecuted", volumeExecuted)
                    .append("cost", cost)
                    .append("fee", fee)
                    .append("averagePrice", averagePrice)
                    .append("stopPrice", stopPrice)
                    .append("miscellaneous", miscellaneous)
                    .append("orderFlags", orderFlags)
                    .append("reason", reason)
                    .append("orderClosedTimestamp", orderClosedTimestamp)
                    .toString();
        }
    }
}