package note.entity;

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
public class Summary implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer summaryId;

    private Integer viewsCount;

    private Integer favoriteCount;


}
