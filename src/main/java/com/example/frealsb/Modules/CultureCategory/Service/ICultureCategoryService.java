package com.example.frealsb.Modules.CultureCategory.Service;

import com.example.frealsb.Modules.CultureCategory.Model.CultureCategory;
import com.example.frealsb.Modules.CultureCategory.RequestCultureCategory;

import java.util.List;

public interface ICultureCategoryService {
    // __CURD__ //
    List<CultureCategory> getAllCultureCategory(String s, int page, int size);
    CultureCategory getCultureCategory(String id);
    CultureCategory addCultureCategory(RequestCultureCategory req);
    CultureCategory updateCultureCategory(RequestCultureCategory req);
    CultureCategory deleteCultureCategory(String id);
}
