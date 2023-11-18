package br.com.pameladilly.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MenuDTOResponse {

    private String name;
    private List<ProductDTO> products;
}
