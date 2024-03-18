package com.test.markdown.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.InvalidRelationTypeException;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private List records;
    private Integer total;
    Integer size;
    Integer current;
    Boolean searchCount;
    Integer pages;
}
