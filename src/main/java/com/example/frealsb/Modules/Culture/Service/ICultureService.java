package com.example.frealsb.Modules.Culture.Service;

import com.example.frealsb.Modules.Culture.Model.Culture;
import com.example.frealsb.Modules.Culture.Model.RequestCulture;

import java.util.List;

public interface ICultureService {
    // __CURD__ //
    List<Culture> getCultures(String s, int page, int size);
    Culture getCulture(String id);
    Culture addCulture(RequestCulture req);
    Culture updateCulture(RequestCulture req);
    Culture deleteCulture(String id);
}
