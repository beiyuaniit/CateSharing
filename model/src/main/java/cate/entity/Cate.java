package cate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Cate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cate_id", type = IdType.AUTO)
    private Integer cateId;

    private Integer categoryId;

    private String description;

    private LocalDateTime creatTime;

    private String pictureAddr;

    private String name;


}
