package modules.admin.Communication;

import java.util.ArrayList;
import java.util.List;

import modules.admin.Communication.actions.GetResults;
import modules.admin.domain.Communication;
import modules.admin.domain.Tag;

import org.skyve.CORE;
import org.skyve.EXT;
import org.skyve.domain.messages.Message;
import org.skyve.domain.messages.ValidationException;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Bizlet;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Job;
import org.skyve.metadata.module.Module;
import org.skyve.metadata.user.User;
import org.skyve.persistence.DocumentQuery;
import org.skyve.persistence.Persistence;

public class CommunicationBizlet extends Bizlet<Communication> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7404508611264793559L;

	public static void checkForUnsavedData(Communication communication) throws Exception {
		if (!communication.originalValues().isEmpty()) {
			// find if any field except results
			boolean fieldOtherThanResults = false;
			for (String s : communication.originalValues().keySet()) {
				if (!Communication.resultsPropertyName.equals(s)) {
					fieldOtherThanResults = true;
					break;
				}
			}
			if (fieldOtherThanResults) {
				throw new ValidationException(new Message("You have unsaved changes. The Job cannot be run until data is saved."));
			}
		}
	}

	@Override
	public List<DomainValue> getDynamicDomainValues(String attributeName, Communication bean) throws Exception {

		Persistence pers = CORE.getPersistence();
		List<DomainValue> result = new ArrayList<>();

		Customer customer = pers.getUser().getCustomer();

		if (Communication.documentNamePropertyName.equals(attributeName)) {
			if (bean.getModuleName() != null) {
				Module module = customer.getModule(bean.getModuleName());
				for (String documentName : module.getDocumentRefs().keySet()) {
					Document document = module.getDocument(customer, documentName);
					result.add(new DomainValue(document.getName(), document.getDescription()));
				}
			}
		}
		
		return result;
	}

	@Override
	public List<DomainValue> getVariantDomainValues(String attributeName) throws Exception {

		List<DomainValue> result = new ArrayList<>();
		Persistence pers = CORE.getPersistence();
		
		Customer customer = pers.getUser().getCustomer();
		if (Communication.moduleNamePropertyName.equals(attributeName)) {
			for (Module module : customer.getModules()) {
				result.add(new DomainValue(module.getName(), module.getTitle()));
			}
		}
		
		if (Communication.tagPropertyName.equals(attributeName)) {

			// look for OTHER tags
			DocumentQuery q = pers.newDocumentQuery(Tag.MODULE_NAME, Tag.DOCUMENT_NAME);
			q.addOrdering(Tag.namePropertyName);

			List<Tag> tags = q.beanResults();
			for (Tag t : tags) {
				result.add(new DomainValue(t.getBizId(), t.getName()));
			}
		}
		
		return result;
	}
	
	public static Communication kickOffJob(Communication communication) throws Exception{

		GetResults.getResults(communication);
		
		Persistence persistence = CORE.getPersistence();
		User user = persistence.getUser();
		Customer customer = user.getCustomer();
		Module module = customer.getModule(Communication.MODULE_NAME);
		Job job = module.getJob("jProcessCommunicationsForTag");

		EXT.runOneShotJob(job, communication, user);

		StringBuilder sb = new StringBuilder();
		sb.append(communication.getResults());
		sb.append("\nThe job has been commenced - check Admin->Jobs for the log.");
		communication.setResults(sb.toString());
		
		communication.originalValues().remove(Communication.resultsPropertyName);
		
		return communication;
	}
}