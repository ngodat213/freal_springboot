package com.example.frealsb.Modules.CultureCategory.Service;

import com.example.frealsb.Modules.CultureCategory.Model.CultureCategory;
import com.example.frealsb.Modules.CultureCategory.CultureCategoryRepository;
import com.example.frealsb.Modules.CultureCategory.RequestCultureCategory;
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
        c.setDeleted(true);
        return repository.saveAndFlush(c);
    }
}
