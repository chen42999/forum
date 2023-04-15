package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
* 用户较色对照表
* @TableName sys_login_role
*/
public class UserRole implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer loginId;
    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer roleId;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("")
    @Length(max= 20,message="编码长度不能超过20")
    private String username;

    /**
    * 
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 
    */
    private void setLoginId(Integer loginId){
    this.loginId = loginId;
    }

    /**
    * 
    */
    private void setRoleId(Integer roleId){
    this.roleId = roleId;
    }

    /**
    * 
    */
    private void setUsername(String username){
    this.username = username;
    }


    /**
    * 
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 
    */
    private Integer getLoginId(){
    return this.loginId;
    }

    /**
    * 
    */
    private Integer getRoleId(){
    return this.roleId;
    }

    /**
    * 
    */
    private String getUsername(){
    return this.username;
    }

}
