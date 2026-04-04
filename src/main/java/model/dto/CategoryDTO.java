package model.dto;

import lombok. *;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Set<Long> categoryIds;

}
