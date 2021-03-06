package org.skyve.domain.types.converters.timestamp;

import org.skyve.CORE;
import org.skyve.domain.types.Timestamp;
import org.skyve.domain.types.converters.Converter;
import org.skyve.domain.types.converters.Format;
import org.skyve.domain.types.converters.Validator;
import org.skyve.metadata.model.Attribute.AttributeType;

public abstract class AbstractTimestampConverter implements Converter<Timestamp> {
	@Override
	public final AttributeType getAttributeType() {
		return AttributeType.timestamp;
	}

	@Override
	public Format<Timestamp> getFormat() {
		return null;
	}

	@Override
	public Validator<Timestamp> getValidator() {
		return null;
	}

	/**
	 * The pattern for this Timestamp converter
	 * 
	 * @return Timestamp format String pattern
	 */
	protected abstract String getPattern();

	@Override
	public Timestamp fromDisplayValue(String displayValue) throws Exception {
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern(), Locale.ENGLISH);
		LocalDateTime localDateTime = LocalDateTime.parse(displayValue, formatter);
		return new Timestamp(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));*/
		return new Timestamp(CORE.getDateFormat(getPattern()).parse(displayValue).getTime());
	}

	@Override
	public String toDisplayValue(Timestamp value) throws Exception {
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern(), Locale.ENGLISH);
		LocalDateTime localTime = Instant.ofEpochMilli(value.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
		return formatter.format(localTime);*/
		return CORE.getDateFormat(getPattern()).format(value);
	}
}
