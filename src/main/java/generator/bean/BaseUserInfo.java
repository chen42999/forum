package generator.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName base_userinfo
*/
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

    /**
    * 
    */
    private void setBaseId(String baseId){
    this.baseId = baseId;
    }

    /**
    * 
    */
    private void setBaseName(String baseName){
    this.baseName = baseName;
    }

    /**
    * 
    */
    private void setBaseSex(String baseSex){
    this.baseSex = baseSex;
    }

    /**
    * 
    */
    private void setBaseAge(Integer baseAge){
    this.baseAge = baseAge;
    }

    /**
    * 
    */
    private void setBaseFatieshu(Integer baseFatieshu){
    this.baseFatieshu = baseFatieshu;
    }

    /**
    * 
    */
    private void setBaseHuitieshu(Integer baseHuitieshu){
    this.baseHuitieshu = baseHuitieshu;
    }

    /**
    * 
    */
    private void setBasePhoto(String basePhoto){
    this.basePhoto = basePhoto;
    }

    /**
    * 
    */
    private void setBaseShenfenzheng(String baseShenfenzheng){
    this.baseShenfenzheng = baseShenfenzheng;
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
    private String getBaseId(){
    return this.baseId;
    }

    /**
    * 
    */
    private String getBaseName(){
    return this.baseName;
    }

    /**
    * 
    */
    private String getBaseSex(){
    return this.baseSex;
    }

    /**
    * 
    */
    private Integer getBaseAge(){
    return this.baseAge;
    }

    /**
    * 
    */
    private Integer getBaseFatieshu(){
    return this.baseFatieshu;
    }

    /**
    * 
    */
    private Integer getBaseHuitieshu(){
    return this.baseHuitieshu;
    }

    /**
    * 
    */
    private String getBasePhoto(){
    return this.basePhoto;
    }

    /**
    * 
    */
    private String getBaseShenfenzheng(){
    return this.baseShenfenzheng;
    }

    /**
    * 
    */
    private String getUsername(){
    return this.username;
    }

}
