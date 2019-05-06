package org.skyve.impl.metadata.model.document.field.validator;

import static org.junit.Assert.fail;

import java.util.Locale;

import org.junit.Test;
import org.skyve.domain.messages.ValidationException;
import org.skyve.impl.metadata.model.document.field.validator.TextValidator.ValidatorType;
import org.skyve.impl.metadata.user.SuperUser;

public class TextValidatorTest {

	@Test
	@SuppressWarnings("static-method")
	public void testValidateEmailInvalid() throws Exception {
		// setup the test data
		TextValidator v = new TextValidator();
		v.setType(ValidatorType.email);

		String[] testEmails = new String[] {
				"plainaddress", // Missing @ sign and domain
				"#@%^%#$@#$@#.com", // Garbage
				"@domain.com", // Missing username
				"email.domain.com", // Missing @
				"email@domain@domain.com", // Two @ sign
		};

		// call the method under test
		for (String email : testEmails) {
			ValidationException e = new ValidationException();
			SuperUser u = new SuperUser();
			u.setWebLocale(Locale.getDefault());
			v.validate(u, email, "binding", "Binding", null, e);

			// verify the result
			if (e.getMessages().isEmpty()) {
				fail("Email " + email + " should not have passed validation.");
			}
		}
	}

	@Test
	@SuppressWarnings("static-method")
	public void testValidateEmailValid() throws Exception {
		// setup the test data
		TextValidator v = new TextValidator();
		v.setType(ValidatorType.email);

		String[] testEmails = new String[] {
				"email@domain.com", // Valid email
				"firstname.lastname@domain.com", // Email contains dot in the address field
				"email@subdomain.domain.com", // Email contains dot with subdomain
				"firstname+lastname@domain.com", // Plus sign is considered valid character
				"email@123.123.123.123", // Domain is valid IP address
				"email@[123.123.123.123]", // Square bracket around IP address is considered valid
				"\"email\"@domain.com", // Quotes around email is considered valid
				"1234567890@domain.com", // Digits in address are valid
				"email@domain-one.com", // Dash in domain name is valid
				"_______@domain.com", // Underscore in the address field is valid
				"email@domain.name", // .name is valid Top Level Domain name
				"email@domain.co.jp", // Dot in Top Level Domain name also considered valid (use co.jp as example here)
				"firstname-lastname@domain.com", // Dash in address field is valid
				"email@domain", // Missing top level domain (.com/.net/.org/etc)
				"email@domain.fabricatedfortest", // custom tld
		};

		// call the method under test
		for (String email : testEmails) {
			ValidationException e = new ValidationException();
			SuperUser u = new SuperUser();
			u.setWebLocale(Locale.getDefault());
			v.validate(u, email, "binding", "Binding", null, e);

			if (!e.getMessages().isEmpty()) {
				fail("Email " + email + " should have passed validation.");
			}
		}
	}

}
