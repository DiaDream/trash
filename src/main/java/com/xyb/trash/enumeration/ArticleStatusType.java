
/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.enumeration;

/**
 * 文章状态 发布状态
 */

public enum ArticleStatusType {
	/**
	 * 正常: 0
	 */
	NORMAL("正常", "0"),
	/**
	 * 已删除:1
	 */
	DELETE("已删除", "1"),
	/**
	 * 新建立：0
	 */
	CREATE("新建立", "0"),
	/**
	 * 已提交：0
	 */
	SUBMIT("已提交", "1"),
	/**
	 * 已审核：2
	 */
	EXAMINE("已审核", "2"),
	/**
	 * 审核不通过：2
	 */
	FAIL("审核不通过", "3"),
	
	
	/**
	 * 普通：0
	 */
	UNRECOMMEND("已审核", "0"),
	/**
	 * 已审核：2
	 */
	RECOMMEND("已审核", "1");
	
	

	private String name;
	private String value;

	private ArticleStatusType(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	/**
	 * 根据枚举值取得枚举对象
	 * 
	 * @param typeValue
	 * @return
	 * 
	 */
	public static ArticleStatusType findByValue(String typeValue) {
		for (ArticleStatusType articlestatustype : values()) {
			if (articlestatustype.getValue().equals(typeValue)) {
				return articlestatustype;
			}
		}
		return null;
	}

	/**
	 * 根据枚举值取得枚举名称
	 * 
	 * @param typeValue
	 * @return
	 * 
	 */
	public static String getNameByValue(String typeValue) {
		for (ArticleStatusType articlestatustype : values()) {
			if (articlestatustype.getValue().equals(typeValue)) {
				return articlestatustype.getName();
			}
		}
		return null;
	}

}
