package org.skyve.domain;

import org.skyve.domain.types.OptimisticLock;

/**
 * 
 */
public interface PersistentBean extends Bean {
	/**
	 * 
	 */
	public static final String LOCK_NAME = "bizLock";
	
	/**
	 * 
	 */
	public static final String VERSION_NAME = "bizVersion";
	
	/**
	 * 
	 */
	public static final String FLAG_COMMENT_NAME = "bizFlagComment";
	
	/**
	 * 
	 */
	public static final String TAGGED_NAME = "bizTagged";

	/**
	 * 
	 */
	public static final String DISCRIMINATOR_NAME = "bizDiscriminator";

	/**
	 * 
	 */
	public static final String OWNER_COLUMN_NAME = "owner_id";
	
	/**
	 * 
	 */
	public static final String ELEMENT_COLUMN_NAME = "element_id";
	
	/**
	 * 
	 * @return
	 */
	public Integer getBizVersion();
	
	/**
	 * 
	 * @param bizVersion
	 */
	public void setBizVersion(Integer bizVersion);

	/**
	 * 
	 * @return
	 */
	public OptimisticLock getBizLock();
	
	/**
	 * 
	 * @param bizLock
	 */
	public void setBizLock(OptimisticLock bizLock);

	/**
	 * 
	 * @param bizKey
	 */
	public void setBizKey(String bizKey);
	
	/**
	 * 
	 * @return
	 */
	public String getBizFlagComment();
	
	/**
	 * 
	 * @param bizFlagComment
	 */
	public void setBizFlagComment(String bizFlagComment);
	
	/**
	 * 
	 * @return
	 */
	public Boolean getBizTagged();

	/**
	 * 
	 * @param bizTagged
	 */
	public void setBizTagged(Boolean bizTagged);
}
