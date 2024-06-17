package com.rasyidcode.quoters;

import java.util.Objects;

public class QuoteResource {

	private String type;

	private Quote value;

	public QuoteResource(String type, Quote value) {
		super();
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Quote getValue() {
		return value;
	}

	public void setValue(Quote value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuoteResource other = (QuoteResource) obj;
		return Objects.equals(value, other.value) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "QuoteResource [type=" + type + ", value=" + value + "]";
	}

}
