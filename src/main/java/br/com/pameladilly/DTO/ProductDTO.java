package br.com.pameladilly.DTO;

import jakarta.ws.rs.GET;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private String href;
    private Integer position;

}
