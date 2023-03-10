package com.jzy.erpboot.system.common;

import com.jzy.erpboot.system.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: 0812erp
 * @author: shuke
 * @create: 2020-01-04 09:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveUser implements Serializable {

    private User user;
    private List<String> roles;
    private List<String> permissions;

}
