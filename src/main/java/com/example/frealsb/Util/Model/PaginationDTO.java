package com.example.frealsb.Util.Model;

public record PaginationDTO(
        int page,
        int limit,
        String sortDirection,
        String sortBy
) {
}
