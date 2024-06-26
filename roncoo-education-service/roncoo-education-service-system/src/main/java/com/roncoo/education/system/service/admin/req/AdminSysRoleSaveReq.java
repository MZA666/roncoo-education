package com.roncoo.education.system.service.admin.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 角色信息-添加
 *
 * @author wujing
 */
@Data
@Accessors(chain = true)
public class AdminSysRoleSaveReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", required = true)
    private String roleName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", required = false)
    private String remark;
}
