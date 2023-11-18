package br.com.pameladilly.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDTO {

    private String name;
    private Boolean active;
    private List<Long> products;
}
