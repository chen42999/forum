package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
* 
* @TableName forum_dictionary
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer dictId;
    /**
    * 
    */
    @Size(max= 45,message="编码长度不能超过45")
    @ApiModelProperty("")
    @Length(max= 45,message="编码长度不能超过45")
    private String dictGroup;
    /**
    * 
    */
    @Size(max= 45,message="编码长度不能超过45")
    @ApiModelProperty("")
    @Length(max= 45,message="编码长度不能超过45")
    private String dictKey;
    /**
    * 
    */
    @Size(max= 45,message="编码长度不能超过45")
    @ApiModelProperty("")
    @Length(max= 45,message="编码长度不能超过45")
    private String dictValue;
    /**
    * 
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String dictParent;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer dictOrder;
    /**
    * 
    */
    @ApiModelProperty("")
    private String dictIsleaf;

}
