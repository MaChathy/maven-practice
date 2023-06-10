package com.fisher.bankmgr.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author fisher
 * @version 1.0.1 2023/6/6 - 15:15
 */
@Data
@NoArgsConstructor
public class BankMgrResource {

    private Integer resourceId;
    private String resourceName;
    private Integer resourceCount;

}
