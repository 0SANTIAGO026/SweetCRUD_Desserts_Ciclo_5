package com.project.web.SweetCRUD.response;

import com.project.web.SweetCRUD.dto.ProductDTO;

public record DetailsProductsResponse(String code,
                                      String error,
                                      ProductDTO productDTO) {
}
