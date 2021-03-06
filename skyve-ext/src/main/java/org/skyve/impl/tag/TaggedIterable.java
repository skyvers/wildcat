package org.skyve.impl.tag;

import java.util.Iterator;

import org.skyve.domain.Bean;
import org.skyve.impl.bind.BindUtil;
import org.skyve.impl.persistence.AbstractPersistence;
import org.skyve.metadata.customer.Customer;
import org.skyve.metadata.model.document.Document;
import org.skyve.metadata.module.Module;

class TaggedIterable implements Iterable<Bean> {
	private Iterator<Bean> taggedIterator;
	
	TaggedIterable(Iterator<Bean> taggedIterator) {
		this.taggedIterator = taggedIterator;
	}

	private static class TaggedIterator implements Iterator<Bean> {
		private Iterator<Bean> taggedIterator;
		
		private Bean nextBean;
		
		private TaggedIterator(Iterator<Bean> taggedIterator) {
			this.taggedIterator = taggedIterator;
		}
		
		@Override
		public boolean hasNext() {
			boolean result = taggedIterator.hasNext();
			if (result) {

				Bean tagged = taggedIterator.next();
				nextBean = null;

				String taggedModule = null;
				String taggedDocument = null;
				String taggedBizId = null;
				try {
					taggedModule = (String) BindUtil.get(tagged, "taggedModule");
					taggedDocument = (String) BindUtil.get(tagged, "taggedDocument");
					taggedBizId = (String) BindUtil.get(tagged, "taggedBizId");
					AbstractPersistence persistence = AbstractPersistence.get(); // thread local remember
					Customer customer = persistence.getUser().getCustomer();
					Module module = customer.getModule(taggedModule);
					Document document = module.getDocument(customer, taggedDocument);
					nextBean = persistence.retrieve(document, taggedBizId);
					if (nextBean == null) {
						throw new Exception("Tagged item does not exist");
					}
				}
				catch (Exception e) {
					StringBuilder sb = new StringBuilder(256);
					sb.append(taggedModule).append('.').append(taggedDocument);
					sb.append('.').append(taggedBizId).append(" - ").append(e.getLocalizedMessage());
					System.err.println(sb.toString());
					// try the next one
					result = hasNext();
				}
			}
			
			return result;
		}

		@Override
		public Bean next() {
			Bean result = nextBean;
			nextBean = null;
			
			return result;
		}

		@Override
		public void remove() {
			throw new IllegalAccessError("Cannot remove from a TaggedIterator.");
		}
	}
	
	@Override
	public Iterator<Bean> iterator() {
		return new TaggedIterator(taggedIterator);
	}
}
