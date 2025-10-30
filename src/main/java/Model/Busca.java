package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Busca {
    private String description;
    private Double minPrice;
    private Double maxPrice;

}
