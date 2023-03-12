package user.vo;

import lombok.Data;

/**
 * @author: beiyuan
 * @date: 2022/12/15  22:24
 */
@Data
public class FavoriteSaveVo {
    private Integer userId;

    private Integer noteId;

    private String name;
}
