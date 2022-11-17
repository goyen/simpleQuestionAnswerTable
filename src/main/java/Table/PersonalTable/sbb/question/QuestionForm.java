package Table.PersonalTable.sbb.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "Please Enter The Tilte")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "Please Enter The Content")
    private String content;
}
