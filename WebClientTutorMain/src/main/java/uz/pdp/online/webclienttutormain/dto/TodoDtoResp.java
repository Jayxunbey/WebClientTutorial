package uz.pdp.online.webclienttutormain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDtoResp {
    private Long id;
    private UserDtoResp user;
    private String title;
    private boolean completed;

}
