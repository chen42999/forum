package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
* 
* @TableName base_userinfo
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseUserInfo implements Serializable {

    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String baseId;
    /**
    * 
    */
    @Size(max= 10,message="编码长度不能超过10")
    @ApiModelProperty("")
    @Length(max= 10,message="编码长度不能超过10")
    private String baseName;
    /**
    * 
    */
    @ApiModelProperty("")
    private String baseSex;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer baseAge;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer baseFatieshu;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer baseHuitieshu;
    /**
    * 
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("")
    @Length(max= 255,message="编码长度不能超过255")
    private String basePhoto;
    /**
    * 
    */
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("")
    @Length(max= 20,message="编码长度不能超过20")
    private String baseShenfenzheng;
    /**
    * 
    */
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("")
    @Length(max= 20,message="编码长度不能超过20")
    private String username;

}
