package com.jzy.erpboot.system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: 0812erp
 * @author: shuke
 * @create: 2020-01-04 17:40
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView implements Serializable {

    private Integer code=0;
    private String msg="";
    private Long count=0L;
    private Object data;

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public DataGridView(Object data) {
        this.data = data;
    }
}
