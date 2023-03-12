package note.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: beiyuan
 * @date: 2022/12/17  12:02
 */
@Data
public class CommentSaveVo {

    private Integer noteId;

    private String comment;

    private Integer comParentId;

    private Integer fromUserId;
}
