package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Culture;
import com.example.frealsb.RequestEntities.RequestCulture;

import java.util.List;

public interface ICultureService {
    // __CURD__ //
    List<Culture> getCultures(String s, int page, int size);
    Culture getCulture(String id);
    Culture addCulture(RequestCulture req);
    Culture updateCulture(RequestCulture req);
    Culture deleteCulture(String id);
}
