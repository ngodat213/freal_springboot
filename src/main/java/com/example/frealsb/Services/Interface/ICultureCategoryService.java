package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.CultureCategory;
import com.example.frealsb.RequestEntities.RequestCultureCategory;

import java.util.List;

public interface ICultureCategoryService {
    // __CURD__ //
    public List<CultureCategory> getAllCultureCategory(String s, int page, int size);
    public CultureCategory getCultureCategory(String id);
    public CultureCategory addCultureCategory(RequestCultureCategory req);
    public CultureCategory updateCultureCategory(RequestCultureCategory req);
    public CultureCategory deleteCultureCategory(String id);
}
