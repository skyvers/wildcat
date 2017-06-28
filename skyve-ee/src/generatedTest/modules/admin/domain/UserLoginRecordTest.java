package modules.admin.domain;

import modules.admin.util.UserLoginRecordFactory;
import util.AbstractDomainTest;
import util.AbstractH2Test;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractH2Test} to create your own tests for this document.
 */
public class UserLoginRecordTest extends AbstractDomainTest<UserLoginRecord> {

	private UserLoginRecordFactory factory;

	@Override
	public void setUp() throws Exception {
		factory = new UserLoginRecordFactory();
	}

	@Override
	protected UserLoginRecord getBean() throws Exception {
		return factory.getInstance();
	}
}