package cate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author beiyuan
 * @since 2022-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Step implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "step_id", type = IdType.AUTO)
    private Integer stepId;

    private Integer cateId;

    private Integer orderNo;

    private String description;

    private String pictureAddr;

    private String brief;


}
