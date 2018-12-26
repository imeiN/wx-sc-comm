package com.mtgz.common.service.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Transient;

/**
 * 名称：Tree <br>
 * 描述：<br>
 *
 * @author 李鹏军
 * @version 1.0
 * @since 1.0.0
 */
@Data
public class Tree<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**********iview tree属性**************/
    /**
     * 标题
     */
    @Transient
    private String title;

    /**
     * 是否展开直子节点
     */
    @Transient
    private boolean expand = false;

    /**
     * 禁掉响应
     */
    @Transient
    private boolean disabled = false;
    /**
     * 禁掉 checkbox
     */
    @Transient
    private boolean disableCheckbox = false;
    /**
     * 是否选中子节点
     */
    @Transient
    private boolean selected = false;
    /**
     * 是否勾选(如果勾选，子节点也会全部勾选)
     */
    @Transient
    private boolean checked = false;
    @Transient
    private boolean leaf = false;
    /**
     * ztree属性
     */
    @Transient
    private Boolean open;

    @Transient
    private List<?> list;

    /**
     * 子节点属性数组
     */
    @Transient
    private List<?> children;
    @Transient
    private String value;
    @Transient
    private String label;
}
