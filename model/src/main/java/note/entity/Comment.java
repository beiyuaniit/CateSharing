package note.entity;

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
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer commentId;

    private Integer noteId;

    private String comment;

    private LocalDateTime createTime;

    private Integer comParentId;

    private Integer fromUserId;


}
