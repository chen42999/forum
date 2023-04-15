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
import java.util.Date;

/**
* 主表信息
* @TableName forum_minfo
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForumMinfo implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer minfoId;
    /**
    * 
    */
    @NotBlank(message="[]不能为空")
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String mainType;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer minfoReply;
    /**
    * 
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String minfoBanzhu;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date minfoCreatime;
    /**
    * 
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    @Length(max= 64,message="编码长度不能超过64")
    private String minfoCreatuser;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer minfoOrder;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer minfoSee;
    /**
    * 版块标志图片
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("版块标志图片")
    @Length(max= 255,message="编码长度不能超过255")
    private String minfoPhoto;
    /**
    * 
    */
    @Size(max= 80,message="编码长度不能超过80")
    @ApiModelProperty("")
    @Length(max= 80,message="编码长度不能超过80")
    private String minfoTitle;
    /**
    * 
    */
    @ApiModelProperty("")
    private Integer minfoCount;


}
