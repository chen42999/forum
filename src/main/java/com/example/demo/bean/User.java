package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
* 登录信息表
* @TableName sys_login
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer loginId;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @NotNull(message = "不能为NULL")
    @ApiModelProperty("")
    @Length(min = 4, max= 20,message="用户名最低为4位或最多为20位")
    private String username;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String password;
    /**
    * 
    */
    @ApiModelProperty("")
    @NotNull(message = "不能为NULL")
    @NotBlank(message = "不能为空")
    @Length(max= 45,message="编码长度不能超过45")
    private String email;
    /**
    * 
    */
    @ApiModelProperty("")
    @Length(max= 45,message="编码长度不能超过45")
    private String wxname;

    private Set<String> roles;

    public User(Integer userId, String username, String password, String wxname, String email) {
        loginId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.wxname = wxname;
    }
}
