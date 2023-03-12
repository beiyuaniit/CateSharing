package user.vo;

import lombok.Data;

/**
 * @author: beiyuan
 * @date: 2022/12/15  12:10
 */
@Data
public class UserQueryVo {
    private Integer userId;//跟原User的userId保持一致才能注入，用user_id不太行

    private String nickname;

    private String profileAddr;

    private Integer level;

    private String email;

    private String ip;
}
