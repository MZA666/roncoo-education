package com.roncoo.education.system.service.admin.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单信息-列出
 *
 * @author wujing
 */
@Data
@Accessors(chain = true)
public class AdminSysMenuUserListResp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单集合
     */
    @ApiModelProperty(value = "菜单集合")
    private List<AdminSysMenuUserResp> sysMenu = new ArrayList<>();

}
