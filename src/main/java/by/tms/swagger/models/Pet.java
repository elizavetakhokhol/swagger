package by.tms.swagger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private int id;
    private Category category;
    private List<Tag> tags;
    @NotEmpty
    @NotBlank
    @Size(min = 2)
    private String name;
    private PetStatus petStatus;
}
