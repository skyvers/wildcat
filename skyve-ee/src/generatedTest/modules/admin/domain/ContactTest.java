package modules.admin.domain;

import modules.admin.util.ContactFactory;
import util.AbstractDomainTest;
import util.AbstractH2Test;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractH2Test} to create your own tests for this document.
 */
public class ContactTest extends AbstractDomainTest<Contact> {

	private ContactFactory factory;

	@Override
	public void setUp() throws Exception {
		factory = new ContactFactory();
	}

	@Override
	protected Contact getBean() throws Exception {
		return factory.getInstance();
	}
}