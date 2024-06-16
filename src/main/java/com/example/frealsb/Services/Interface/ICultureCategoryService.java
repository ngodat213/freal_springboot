package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.CultureCategory;
import com.example.frealsb.RequestEntities.RequestCultureCategory;

import java.util.List;

public interface ICultureCategoryService {
    // __CURD__ //
    List<CultureCategory> getAllCultureCategory(String s, int page, int size);
    CultureCategory getCultureCategory(String id);
    CultureCategory addCultureCategory(RequestCultureCategory req);
    CultureCategory updateCultureCategory(RequestCultureCategory req);
    CultureCategory deleteCultureCategory(String id);
}
