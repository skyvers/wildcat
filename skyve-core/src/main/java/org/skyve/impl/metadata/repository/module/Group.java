package org.skyve.impl.metadata.repository.module;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.skyve.impl.util.XMLMetaData;

@XmlType(namespace = XMLMetaData.MODULE_NAMESPACE)
@XmlRootElement(namespace = XMLMetaData.MODULE_NAMESPACE)
public class Group extends Action {
	private static final long serialVersionUID = -8705078693132357242L;

	private List<Action> actions = new ArrayList<>();

	@XmlElementRefs({@XmlElementRef(type = EditItem.class),
						@XmlElementRef(type = ListItem.class),
						@XmlElementRef(type = MapItem.class),
						@XmlElementRef(type = CalendarItem.class),
						@XmlElementRef(type = TreeItem.class),
						@XmlElementRef(type = LinkItem.class),
						@XmlElementRef(type = Group.class)})
	public List<Action> getActions() {
		return actions;
	}
}
