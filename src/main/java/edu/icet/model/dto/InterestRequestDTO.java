package edu.icet.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterestRequestDTO {

    private List<Long> categoryIds;

}
