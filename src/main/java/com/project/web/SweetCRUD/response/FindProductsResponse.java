package com.project.web.SweetCRUD.response;

import com.project.web.SweetCRUD.dto.ProductDTO;
import com.project.web.SweetCRUD.dto.SalesDto;

public record FindProductsResponse(String code,
                                   String error,
                                   Iterable<ProductDTO> productDTO) {
}
