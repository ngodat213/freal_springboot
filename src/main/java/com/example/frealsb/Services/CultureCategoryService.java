package com.example.frealsb.Services;

import com.example.frealsb.Entities.CultureCategory;
import com.example.frealsb.Repositories.CultureCategoryRepository;
import com.example.frealsb.RequestEntities.RequestCultureCategory;
import com.example.frealsb.Services.Interface.ICultureCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CultureCategoryService implements ICultureCategoryService {
    @Autowired
    private CultureCategoryRepository repository;

    @Override
    public List<CultureCategory> getAllCultureCategory(String s, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAllBy(s, pageable);
    }

    @Override
    public CultureCategory getCultureCategory(String id) {
        return repository.findById(id).get();
    }

    @Override
    public CultureCategory addCultureCategory(RequestCultureCategory req) {
        return repository.saveAndFlush(req.toAddData());
    }

    @Override
    public CultureCategory updateCultureCategory(RequestCultureCategory req) {
        return repository.saveAndFlush(req.toUpdateData());
    }

    @Override
    public CultureCategory deleteCultureCategory(String id) {
        CultureCategory c = getCultureCategory(id);
        c.setDeletedAt(new Date());
        return repository.saveAndFlush(c);
    }
}
