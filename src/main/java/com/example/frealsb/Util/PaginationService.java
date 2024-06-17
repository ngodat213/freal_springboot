package com.example.frealsb.Util;

import com.example.frealsb.Util.Model.PaginationDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PaginationService {

    public Pageable getPageable(PaginationDTO paginationDTO){
        Sort sort = Sort.by(
                Sort.Direction.fromString(paginationDTO.sortDirection()),
                paginationDTO.sortBy()
        );
        return PageRequest.of(paginationDTO.page()-1, paginationDTO.limit(), sort);
    }
    public Pageable getPageable(int page, int limit){
        Sort sort = Sort.by(
                Sort.Direction.fromString("desc"),
                "createdAt"
        );
        return PageRequest.of(page - 1, limit, sort);
    }
    public Pageable getDefaultPageable(){
        Sort sort = Sort.by(
                Sort.Direction.fromString("desc"),
                "createdAt"
        );
        return PageRequest.of(0, 10, sort);
    }

}