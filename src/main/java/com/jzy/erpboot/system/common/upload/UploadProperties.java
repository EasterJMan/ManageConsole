package com.jzy.erpboot.system.common.upload;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @program: 0812erp
 * @author: shuke
 * @create: 2020-01-10 17:33
 **/
@ConfigurationProperties(prefix = "upload")
@Data
public class UploadProperties {

        private String baseUrl;

        private List<String> allowTypes;
}
