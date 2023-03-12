package user.vo;

import lombok.Data;

/**
 * @author: beiyuan
 * @date: 2022/12/15  16:35
 */
@Data
public class UserSaveVo {
    private String nickname;

    private String profileAddr;

    private String password;

    private Integer level;

    private String email;

    private String ip;
}
