package modules.admin.util;

import modules.admin.domain.Configuration;
import org.skyve.CORE;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;
import org.skyve.util.Util;
import util.AbstractDomainFactory;

public class ConfigurationFactory extends AbstractDomainFactory<Configuration> {

	@Override
	public Configuration getInstance() throws Exception {
		Customer customer = CORE.getUser().getCustomer();
		Module module = customer.getModule(Configuration.MODULE_NAME);
		Document document = module.getDocument(customer, Configuration.DOCUMENT_NAME);

		Configuration configuration = Util.constructRandomInstance(CORE.getPersistence().getUser(), module, document, 1);

		return configuration;
	}
}