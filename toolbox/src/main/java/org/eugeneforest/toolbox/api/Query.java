package org.eugeneforest.toolbox.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Eugene-Forest
 */
@ApiModel("分页查询条件")
public class Query {
    @ApiModelProperty("当前页")
    private Integer current;
    @ApiModelProperty("每页的数量")
    private Integer size;
    @ApiModelProperty("总页数")
    private Integer pages;
    @ApiModelProperty("总条数")
    private Integer total;

    public Query(Integer current, Integer size, Integer pages, Integer total) {
        this.current = current;
        this.size = size;
        this.pages = pages;
        this.total = total;
    }

    public Query() {
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
