package modules.test.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.types.Enumeration;
import org.skyve.impl.domain.AbstractPersistentBean;
import org.skyve.metadata.model.document.Bizlet.DomainValue;

/**
 * All Unique Constraint Non-nullable
 * <br/>
 * All unique constraint attributes are required.
 * 
 * @depend - - - Enum3
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class UniqueConstraintNonNullable extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "test";
	/** @hidden */
	public static final String DOCUMENT_NAME = "UniqueConstraintNonNullable";

	/** @hidden */
	public static final String booleanFlagPropertyName = "booleanFlag";
	/** @hidden */
	public static final String enum3PropertyName = "enum3";
	/** @hidden */
	public static final String textPropertyName = "text";

	/**
	 * Enum 3
	 **/
	@XmlEnum
	public static enum Enum3 implements Enumeration {
		one("one", "one"),
		two("two", "two"),
		three("three", "three");

		private String code;
		private String description;

		/** @hidden */
		private DomainValue domainValue;

		/** @hidden */
		private static List<DomainValue> domainValues;

		private Enum3(String code, String description) {
			this.code = code;
			this.description = description;
			this.domainValue = new DomainValue(code, description);
		}

		@Override
		public String toCode() {
			return code;
		}

		@Override
		public String toDescription() {
			return description;
		}

		@Override
		public DomainValue toDomainValue() {
			return domainValue;
		}

		public static Enum3 fromCode(String code) {
			Enum3 result = null;

			for (Enum3 value : values()) {
				if (value.code.equals(code)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static Enum3 fromDescription(String description) {
			Enum3 result = null;

			for (Enum3 value : values()) {
				if (value.description.equals(description)) {
					result = value;
					break;
				}
			}

			return result;
		}

		public static List<DomainValue> toDomainValues() {
			if (domainValues == null) {
				Enum3[] values = values();
				domainValues = new ArrayList<>(values.length);
				for (Enum3 value : values) {
					domainValues.add(value.domainValue);
				}
			}

			return domainValues;
		}
	}

	/**
	 * Boolean Flag
	 **/
	private Boolean booleanFlag;
	/**
	 * Enum 3
	 **/
	private Enum3 enum3;
	/**
	 * Text
	 **/
	private String text;

	@Override
	@XmlTransient
	public String getBizModule() {
		return UniqueConstraintNonNullable.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return UniqueConstraintNonNullable.DOCUMENT_NAME;
	}

	public static UniqueConstraintNonNullable newInstance() throws Exception {
		return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage(org.skyve.CORE.getUser().getCustomer(),
														"{text}",
														this);
		}
		catch (Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof UniqueConstraintNonNullable) && 
					this.getBizId().equals(((UniqueConstraintNonNullable) o).getBizId()));
	}

	/**
	 * {@link #booleanFlag} accessor.
	 * @return	The value.
	 **/
	public Boolean getBooleanFlag() {
		return booleanFlag;
	}

	/**
	 * {@link #booleanFlag} mutator.
	 * @param booleanFlag	The new value.
	 **/
	@XmlElement
	public void setBooleanFlag(Boolean booleanFlag) {
		preset(booleanFlagPropertyName, booleanFlag);
		this.booleanFlag = booleanFlag;
	}

	/**
	 * {@link #enum3} accessor.
	 * @return	The value.
	 **/
	public Enum3 getEnum3() {
		return enum3;
	}

	/**
	 * {@link #enum3} mutator.
	 * @param enum3	The new value.
	 **/
	@XmlElement
	public void setEnum3(Enum3 enum3) {
		preset(enum3PropertyName, enum3);
		this.enum3 = enum3;
	}

	/**
	 * {@link #text} accessor.
	 * @return	The value.
	 **/
	public String getText() {
		return text;
	}

	/**
	 * {@link #text} mutator.
	 * @param text	The new value.
	 **/
	@XmlElement
	public void setText(String text) {
		preset(textPropertyName, text);
		this.text = text;
	}
}
