package com.github.sbouclier.result;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class AddStandardOrderResult extends Result<AddStandardOrderResult.StandardOrder> {

	public static class StandardOrderDescr {
		public String order;

		@Override
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
					.append("order", order)
					.toString();
		}
	}

	@JsonPropertyOrder({"descr", "txid"})
	public static class StandardOrder {
		public StandardOrderDescr descr;
		public List<String> txid;

		@Override
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
					.append("descr", descr)
					.append("txid", txid)
					.toString();
		}
	}
}
