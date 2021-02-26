package by.tms.swagger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private int id;
    private Category category;
    private List<Tag> tags;
    private String name;
    private PetStatus petStatus;
}
