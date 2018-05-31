/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.pojo.cms;

public class CmsMenu {
    private Long resourceId;

    private Long parentId;

    private String resourceUrl;

    private String resourceName;

    private Integer resourceStatu;

    private String resourceOrdinal;
    /**
     * 是否被选中状态
     */
    private int ischeck;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getResourceStatu() {
        return resourceStatu;
    }

    public void setResourceStatu(Integer resourceStatu) {
        this.resourceStatu = resourceStatu;
    }

    public String getResourceOrdinal() {
        return resourceOrdinal;
    }

    public void setResourceOrdinal(String resourceOrdinal) {
        this.resourceOrdinal = resourceOrdinal;
    }

    public int getIscheck() {
        return ischeck;
    }

    public void setIscheck(int ischeck) {
        this.ischeck = ischeck;
    }
}