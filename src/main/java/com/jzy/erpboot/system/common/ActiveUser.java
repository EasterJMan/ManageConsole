package com.jzy.erpboot.system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: 0812erp
 * @author: 雷哥
 * @create: 2020-01-04 09:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveUser implements Serializable {

//    private User user;
    private List<String> roles;
    private List<String> permissions;

}
