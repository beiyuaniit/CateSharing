package user.entity;

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
public class Favorite implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "favorite_id", type = IdType.AUTO)
    private Integer favoriteId;

    private Integer userId;

    private Integer noteId;

    private String name;


}
