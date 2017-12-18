package org.skyve.impl.metadata.view.container.form;

import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.skyve.impl.metadata.repository.PropertyMapAdapter;
import org.skyve.impl.util.XMLMetaData;
import org.skyve.metadata.DecoratedMetaData;

@XmlType(namespace = XMLMetaData.VIEW_NAMESPACE)
public class FormColumn implements DecoratedMetaData {
	private static final long serialVersionUID = -2927913876248576162L;

	private Integer pixelWidth;
	private Integer responsiveWidth;
	private Integer percentageWidth;

	@XmlElement(namespace = XMLMetaData.VIEW_NAMESPACE)
	@XmlJavaTypeAdapter(PropertyMapAdapter.class)
	private Map<String, String> properties = new TreeMap<>();

	public Integer getPercentageWidth() {
		return percentageWidth;
	}

	@XmlAttribute(required = false)
	public void setPercentageWidth(Integer percentageWidth) {
		this.percentageWidth = percentageWidth;
	}

	public Integer getPixelWidth() {
		return pixelWidth;
	}

	@XmlAttribute(required = false)
	public void setPixelWidth(Integer pixelWidth) {
		this.pixelWidth = pixelWidth;
	}

	public Integer getResponsiveWidth() {
		return responsiveWidth;
	}

	@XmlAttribute(required = false)
	public void setResponsiveWidth(Integer responsiveWidth) {
		this.responsiveWidth = responsiveWidth;
	}

	@Override
	public Map<String, String> getProperties() {
		return properties;
	}
}