package modules.admin.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import modules.admin.Configuration.ConfigurationExtension;
import modules.admin.Group.GroupExtension;
import modules.admin.Startup.StartupExtension;
import modules.admin.UserProxy.UserProxyExtension;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * Setup
 * 
 * @navhas n publicUser 0..1 UserProxy
 * @navhas n emailToContact 0..1 Contact
 * @navhas n startup 0..1 Startup
 * @navhas n userSelfRegistrationGroup 0..1 Group
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public abstract class Configuration extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "admin";
	/** @hidden */
	public static final String DOCUMENT_NAME = "Configuration";

	/** @hidden */
	public static final String passwordMinLengthPropertyName = "passwordMinLength";
	/** @hidden */
	public static final String passwordRequireLowercasePropertyName = "passwordRequireLowercase";
	/** @hidden */
	public static final String passwordRequireUppercasePropertyName = "passwordRequireUppercase";
	/** @hidden */
	public static final String passwordRequireNumericPropertyName = "passwordRequireNumeric";
	/** @hidden */
	public static final String passwordRequireSpecialPropertyName = "passwordRequireSpecial";
	/** @hidden */
	public static final String passwordRuleDescriptionPropertyName = "passwordRuleDescription";
	/** @hidden */
	public static final String fromEmailPropertyName = "fromEmail";
	/** @hidden */
	public static final String passwordResetEmailSubjectPropertyName = "passwordResetEmailSubject";
	/** @hidden */
	public static final String passwordResetEmailBodyPropertyName = "passwordResetEmailBody";
	/** @hidden */
	public static final String userSelfRegistrationGroupPropertyName = "userSelfRegistrationGroup";
	/** @hidden */
	public static final String allowUserSelfRegistrationPropertyName = "allowUserSelfRegistration";
	/** @hidden */
	public static final String selfRegistrationActivationExpiryHoursPropertyName = "selfRegistrationActivationExpiryHours";
	/** @hidden */
	public static final String publicUserPropertyName = "publicUser";
	/** @hidden */
	public static final String emailFromPropertyName = "emailFrom";
	/** @hidden */
	public static final String emailToPropertyName = "emailTo";
	/** @hidden */
	public static final String emailSubjectPropertyName = "emailSubject";
	/** @hidden */
	public static final String emailContentPropertyName = "emailContent";
	/** @hidden */
	public static final String passwordExpiryDaysPropertyName = "passwordExpiryDays";
	/** @hidden */
	public static final String passwordHistoryRetentionPropertyName = "passwordHistoryRetention";
	/** @hidden */
	public static final String passwordAccountLockoutThresholdPropertyName = "passwordAccountLockoutThreshold";
	/** @hidden */
	public static final String passwordAccountLockoutDurationPropertyName = "passwordAccountLockoutDuration";
	/** @hidden */
	public static final String emailToContactPropertyName = "emailToContact";
	/** @hidden */
	public static final String startupPropertyName = "startup";

	/**
	 * admin.configuration.passwordMinLength.displayName
	 * <br/>
	 * admin.configuration.passwordMinLength.description
	 **/
	private Integer passwordMinLength = new Integer(10);
	/**
	 * admin.configuration.passwordRequireLowercase.displayName
	 * <br/>
	 * admin.configuration.passwordRequireLowercase.description
	 **/
	private Boolean passwordRequireLowercase;
	/**
	 * admin.configuration.passwordRequireUppercase.displayName
	 * <br/>
	 * admin.configuration.passwordRequireUppercase.description
	 **/
	private Boolean passwordRequireUppercase;
	/**
	 * admin.configuration.passwordRequireNumeric.displayName
	 * <br/>
	 * admin.configuration.passwordRequireNumeric.description
	 **/
	private Boolean passwordRequireNumeric;
	/**
	 * admin.configuration.passwordRequireSpecial.displayName
	 * <br/>
	 * admin.configuration.passwordRequireSpecial.description
	 **/
	private Boolean passwordRequireSpecial;
	/**
	 * admin.configuration.passwordRuleDescription
	 * <br/>
	 * A text description which can be shown to the user if their password does not comply
				with the system password complexity settings. This is a calculated field, see ConfigurationExtension.
	 **/
	private String passwordRuleDescription;
	/**
	 * admin.configuration.fromEmail.displayName
	 * <br/>
	 * admin.configuration.fromEmail.description
	 **/
	private String fromEmail;
	/**
	 * admin.configuration.passwordResetEmailSubject.displayName
	 * <br/>
	 * admin.configuration.passwordResetEmailSubject.description
	 **/
	private String passwordResetEmailSubject;
	/**
	 * admin.configuration.passwordResetEmailBody.displayName
	 * <br/>
	 * admin.configuration.passwordResetEmailBody.description
	 **/
	private String passwordResetEmailBody;
	/**
	 * admin.configuration.userSelfResgistrationGroup.displayName
	 * <br/>
	 * The user group which specifies role-access for self-registering users.
			<br/>
			To disable self-registration, leave this group unselected, or select a group with minimal access permissions.
	 **/
	private GroupExtension userSelfRegistrationGroup = null;
	/**
	 * admin.configuration.allowUserSelfRegistration.displayName
	 * <br/>
	 * admin.configuration.allowUserSelfRegistration.description
	 **/
	private Boolean allowUserSelfRegistration;
	/**
	 * admin.configuration.selfRegistrationActivationExpiryHours.displayName
	 * <br/>
	 * admin.configuration.selfRegistrationActivationExpiryHours.description
	 **/
	private Integer selfRegistrationActivationExpiryHours;
	/**
	 * admin.configuration.association.publicUser.displayName
	 * <br/>
	 * admin.configuration.association.publicUser.description
	 **/
	private UserProxyExtension publicUser = null;
	/**
	 * admin.configuration.emailFrom.displayName
	 **/
	private String emailFrom;
	/**
	 * admin.configuration.emailTo.displayName
	 **/
	private String emailTo;
	/**
	 * admin.configuration.emailSubject.displayName
	 **/
	private String emailSubject;
	/**
	 * admin.configuration.emailContent.displayName
	 **/
	private String emailContent;
	/**
	 * admin.configuration.passwordExpiryDays.displayName
	 * <br/>
	 * admin.configuration.passwordExpiryDays.description
	 * <br/>
	 * Read from the application JSON file set at system startup.
	 **/
	private String passwordExpiryDays;
	/**
	 * admin.configuration.passwordHistoryRetention.displayName
	 * <br/>
	 * admin.configuration.passwordHistoryRetention.description
	 * <br/>
	 * Read from the application JSON file set at system startup.
	 **/
	private String passwordHistoryRetention;
	/**
	 * admin.configuration.passwordAccountLockoutThreshold.displayName
	 * <br/>
	 * admin.configuration.passwordAccountLockoutThreshold.description
	 * <br/>
	 * Read from the application JSON file set at system startup.
	 **/
	private String passwordAccountLockoutThreshold;
	/**
	 * admin.configuration.passwordAccountLockoutDuration.displayName
	 * <br/>
	 * admin.configuration.passwordAccoutnLockoutDuration.description
	 * <br/>
	 * Read from the application JSON file set at system startup.
	 **/
	private String passwordAccountLockoutDuration;
	/**
	 * admin.configuration.association.emailToContact.displayName
	 **/
	private Contact emailToContact = null;
	/**
	 * admin.configuration.association.startup.displayName
	 **/
	private StartupExtension startup = null;

	@Override
	@XmlTransient
	public String getBizModule() {
		return Configuration.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return Configuration.DOCUMENT_NAME;
	}

	public static ConfigurationExtension newInstance() {
		try {
			return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new DomainException(e);
		}
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage(org.skyve.CORE.getUser().getCustomer(),
														"Admin Setup",
														this);
		}
		catch (@SuppressWarnings("unused") Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Configuration) && 
					this.getBizId().equals(((Configuration) o).getBizId()));
	}

	/**
	 * {@link #passwordMinLength} accessor.
	 * @return	The value.
	 **/
	public Integer getPasswordMinLength() {
		return passwordMinLength;
	}

	/**
	 * {@link #passwordMinLength} mutator.
	 * @param passwordMinLength	The new value.
	 **/
	@XmlElement
	public void setPasswordMinLength(Integer passwordMinLength) {
		preset(passwordMinLengthPropertyName, passwordMinLength);
		this.passwordMinLength = passwordMinLength;
	}

	/**
	 * {@link #passwordRequireLowercase} accessor.
	 * @return	The value.
	 **/
	public Boolean getPasswordRequireLowercase() {
		return passwordRequireLowercase;
	}

	/**
	 * {@link #passwordRequireLowercase} mutator.
	 * @param passwordRequireLowercase	The new value.
	 **/
	@XmlElement
	public void setPasswordRequireLowercase(Boolean passwordRequireLowercase) {
		preset(passwordRequireLowercasePropertyName, passwordRequireLowercase);
		this.passwordRequireLowercase = passwordRequireLowercase;
	}

	/**
	 * {@link #passwordRequireUppercase} accessor.
	 * @return	The value.
	 **/
	public Boolean getPasswordRequireUppercase() {
		return passwordRequireUppercase;
	}

	/**
	 * {@link #passwordRequireUppercase} mutator.
	 * @param passwordRequireUppercase	The new value.
	 **/
	@XmlElement
	public void setPasswordRequireUppercase(Boolean passwordRequireUppercase) {
		preset(passwordRequireUppercasePropertyName, passwordRequireUppercase);
		this.passwordRequireUppercase = passwordRequireUppercase;
	}

	/**
	 * {@link #passwordRequireNumeric} accessor.
	 * @return	The value.
	 **/
	public Boolean getPasswordRequireNumeric() {
		return passwordRequireNumeric;
	}

	/**
	 * {@link #passwordRequireNumeric} mutator.
	 * @param passwordRequireNumeric	The new value.
	 **/
	@XmlElement
	public void setPasswordRequireNumeric(Boolean passwordRequireNumeric) {
		preset(passwordRequireNumericPropertyName, passwordRequireNumeric);
		this.passwordRequireNumeric = passwordRequireNumeric;
	}

	/**
	 * {@link #passwordRequireSpecial} accessor.
	 * @return	The value.
	 **/
	public Boolean getPasswordRequireSpecial() {
		return passwordRequireSpecial;
	}

	/**
	 * {@link #passwordRequireSpecial} mutator.
	 * @param passwordRequireSpecial	The new value.
	 **/
	@XmlElement
	public void setPasswordRequireSpecial(Boolean passwordRequireSpecial) {
		preset(passwordRequireSpecialPropertyName, passwordRequireSpecial);
		this.passwordRequireSpecial = passwordRequireSpecial;
	}

	/**
	 * {@link #passwordRuleDescription} accessor.
	 * @return	The value.
	 **/
	public String getPasswordRuleDescription() {
		return passwordRuleDescription;
	}

	/**
	 * {@link #passwordRuleDescription} mutator.
	 * @param passwordRuleDescription	The new value.
	 **/
	@XmlElement
	public void setPasswordRuleDescription(String passwordRuleDescription) {
		this.passwordRuleDescription = passwordRuleDescription;
	}

	/**
	 * {@link #fromEmail} accessor.
	 * @return	The value.
	 **/
	public String getFromEmail() {
		return fromEmail;
	}

	/**
	 * {@link #fromEmail} mutator.
	 * @param fromEmail	The new value.
	 **/
	@XmlElement
	public void setFromEmail(String fromEmail) {
		preset(fromEmailPropertyName, fromEmail);
		this.fromEmail = fromEmail;
	}

	/**
	 * {@link #passwordResetEmailSubject} accessor.
	 * @return	The value.
	 **/
	public String getPasswordResetEmailSubject() {
		return passwordResetEmailSubject;
	}

	/**
	 * {@link #passwordResetEmailSubject} mutator.
	 * @param passwordResetEmailSubject	The new value.
	 **/
	@XmlElement
	public void setPasswordResetEmailSubject(String passwordResetEmailSubject) {
		preset(passwordResetEmailSubjectPropertyName, passwordResetEmailSubject);
		this.passwordResetEmailSubject = passwordResetEmailSubject;
	}

	/**
	 * {@link #passwordResetEmailBody} accessor.
	 * @return	The value.
	 **/
	public String getPasswordResetEmailBody() {
		return passwordResetEmailBody;
	}

	/**
	 * {@link #passwordResetEmailBody} mutator.
	 * @param passwordResetEmailBody	The new value.
	 **/
	@XmlElement
	public void setPasswordResetEmailBody(String passwordResetEmailBody) {
		preset(passwordResetEmailBodyPropertyName, passwordResetEmailBody);
		this.passwordResetEmailBody = passwordResetEmailBody;
	}

	/**
	 * {@link #userSelfRegistrationGroup} accessor.
	 * @return	The value.
	 **/
	public GroupExtension getUserSelfRegistrationGroup() {
		return userSelfRegistrationGroup;
	}

	/**
	 * {@link #userSelfRegistrationGroup} mutator.
	 * @param userSelfRegistrationGroup	The new value.
	 **/
	@XmlElement
	public void setUserSelfRegistrationGroup(GroupExtension userSelfRegistrationGroup) {
		if (this.userSelfRegistrationGroup != userSelfRegistrationGroup) {
			preset(userSelfRegistrationGroupPropertyName, userSelfRegistrationGroup);
			this.userSelfRegistrationGroup = userSelfRegistrationGroup;
		}
	}

	/**
	 * {@link #allowUserSelfRegistration} accessor.
	 * @return	The value.
	 **/
	public Boolean getAllowUserSelfRegistration() {
		return allowUserSelfRegistration;
	}

	/**
	 * {@link #allowUserSelfRegistration} mutator.
	 * @param allowUserSelfRegistration	The new value.
	 **/
	@XmlElement
	public void setAllowUserSelfRegistration(Boolean allowUserSelfRegistration) {
		preset(allowUserSelfRegistrationPropertyName, allowUserSelfRegistration);
		this.allowUserSelfRegistration = allowUserSelfRegistration;
	}

	/**
	 * {@link #selfRegistrationActivationExpiryHours} accessor.
	 * @return	The value.
	 **/
	public Integer getSelfRegistrationActivationExpiryHours() {
		return selfRegistrationActivationExpiryHours;
	}

	/**
	 * {@link #selfRegistrationActivationExpiryHours} mutator.
	 * @param selfRegistrationActivationExpiryHours	The new value.
	 **/
	@XmlElement
	public void setSelfRegistrationActivationExpiryHours(Integer selfRegistrationActivationExpiryHours) {
		preset(selfRegistrationActivationExpiryHoursPropertyName, selfRegistrationActivationExpiryHours);
		this.selfRegistrationActivationExpiryHours = selfRegistrationActivationExpiryHours;
	}

	/**
	 * {@link #publicUser} accessor.
	 * @return	The value.
	 **/
	public UserProxyExtension getPublicUser() {
		return publicUser;
	}

	/**
	 * {@link #publicUser} mutator.
	 * @param publicUser	The new value.
	 **/
	@XmlElement
	public void setPublicUser(UserProxyExtension publicUser) {
		if (this.publicUser != publicUser) {
			preset(publicUserPropertyName, publicUser);
			this.publicUser = publicUser;
		}
	}

	/**
	 * {@link #emailFrom} accessor.
	 * @return	The value.
	 **/
	public String getEmailFrom() {
		return emailFrom;
	}

	/**
	 * {@link #emailFrom} mutator.
	 * @param emailFrom	The new value.
	 **/
	@XmlElement
	public void setEmailFrom(String emailFrom) {
		preset(emailFromPropertyName, emailFrom);
		this.emailFrom = emailFrom;
	}

	/**
	 * {@link #emailTo} accessor.
	 * @return	The value.
	 **/
	public String getEmailTo() {
		return emailTo;
	}

	/**
	 * {@link #emailTo} mutator.
	 * @param emailTo	The new value.
	 **/
	@XmlElement
	public void setEmailTo(String emailTo) {
		preset(emailToPropertyName, emailTo);
		this.emailTo = emailTo;
	}

	/**
	 * {@link #emailSubject} accessor.
	 * @return	The value.
	 **/
	public String getEmailSubject() {
		return emailSubject;
	}

	/**
	 * {@link #emailSubject} mutator.
	 * @param emailSubject	The new value.
	 **/
	@XmlElement
	public void setEmailSubject(String emailSubject) {
		preset(emailSubjectPropertyName, emailSubject);
		this.emailSubject = emailSubject;
	}

	/**
	 * {@link #emailContent} accessor.
	 * @return	The value.
	 **/
	public String getEmailContent() {
		return emailContent;
	}

	/**
	 * {@link #emailContent} mutator.
	 * @param emailContent	The new value.
	 **/
	@XmlElement
	public void setEmailContent(String emailContent) {
		preset(emailContentPropertyName, emailContent);
		this.emailContent = emailContent;
	}

	/**
	 * {@link #passwordExpiryDays} accessor.
	 * @return	The value.
	 **/
	public String getPasswordExpiryDays() {
		return passwordExpiryDays;
	}

	/**
	 * {@link #passwordExpiryDays} mutator.
	 * @param passwordExpiryDays	The new value.
	 **/
	@XmlElement
	public void setPasswordExpiryDays(String passwordExpiryDays) {
		this.passwordExpiryDays = passwordExpiryDays;
	}

	/**
	 * {@link #passwordHistoryRetention} accessor.
	 * @return	The value.
	 **/
	public String getPasswordHistoryRetention() {
		return passwordHistoryRetention;
	}

	/**
	 * {@link #passwordHistoryRetention} mutator.
	 * @param passwordHistoryRetention	The new value.
	 **/
	@XmlElement
	public void setPasswordHistoryRetention(String passwordHistoryRetention) {
		this.passwordHistoryRetention = passwordHistoryRetention;
	}

	/**
	 * {@link #passwordAccountLockoutThreshold} accessor.
	 * @return	The value.
	 **/
	public String getPasswordAccountLockoutThreshold() {
		return passwordAccountLockoutThreshold;
	}

	/**
	 * {@link #passwordAccountLockoutThreshold} mutator.
	 * @param passwordAccountLockoutThreshold	The new value.
	 **/
	@XmlElement
	public void setPasswordAccountLockoutThreshold(String passwordAccountLockoutThreshold) {
		this.passwordAccountLockoutThreshold = passwordAccountLockoutThreshold;
	}

	/**
	 * {@link #passwordAccountLockoutDuration} accessor.
	 * @return	The value.
	 **/
	public String getPasswordAccountLockoutDuration() {
		return passwordAccountLockoutDuration;
	}

	/**
	 * {@link #passwordAccountLockoutDuration} mutator.
	 * @param passwordAccountLockoutDuration	The new value.
	 **/
	@XmlElement
	public void setPasswordAccountLockoutDuration(String passwordAccountLockoutDuration) {
		this.passwordAccountLockoutDuration = passwordAccountLockoutDuration;
	}

	/**
	 * {@link #emailToContact} accessor.
	 * @return	The value.
	 **/
	public Contact getEmailToContact() {
		return emailToContact;
	}

	/**
	 * {@link #emailToContact} mutator.
	 * @param emailToContact	The new value.
	 **/
	@XmlElement
	public void setEmailToContact(Contact emailToContact) {
		if (this.emailToContact != emailToContact) {
			preset(emailToContactPropertyName, emailToContact);
			this.emailToContact = emailToContact;
		}
	}

	/**
	 * {@link #startup} accessor.
	 * @return	The value.
	 **/
	public StartupExtension getStartup() {
		return startup;
	}

	/**
	 * {@link #startup} mutator.
	 * @param startup	The new value.
	 **/
	@XmlElement
	public void setStartup(StartupExtension startup) {
		if (this.startup != startup) {
			preset(startupPropertyName, startup);
			this.startup = startup;
		}
	}

	/**
	 * backupsConfigured
	 *
	 * @return The condition
	 */
	@XmlTransient
	public boolean isBackupsConfigured() {
		return (modules.admin.Configuration.ConfigurationExtension.validBackupConfiguration());
	}

	/**
	 * {@link #isBackupsConfigured} negation.
	 *
	 * @return The negated condition
	 */
	public boolean isNotBackupsConfigured() {
		return (! isBackupsConfigured());
	}

	/**
	 * emailConfigured
	 *
	 * @return The condition
	 */
	@XmlTransient
	public boolean isEmailConfigured() {
		return (modules.admin.Configuration.ConfigurationExtension.validSMTPHost());
	}

	/**
	 * {@link #isEmailConfigured} negation.
	 *
	 * @return The negated condition
	 */
	public boolean isNotEmailConfigured() {
		return (! isEmailConfigured());
	}

	/**
	 * True when the selected startup map type is Google Maps
	 *
	 * @return The condition
	 */
	@XmlTransient
	public boolean isMapTypeGmap() {
		return (getStartup() != null && Startup.MapType.gmap == getStartup().getMapType());
	}

	/**
	 * {@link #isMapTypeGmap} negation.
	 *
	 * @return The negated condition
	 */
	public boolean isNotMapTypeGmap() {
		return (! isMapTypeGmap());
	}
}
