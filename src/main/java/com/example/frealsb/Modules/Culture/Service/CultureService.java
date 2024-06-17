package com.example.frealsb.Modules.Culture.Service;

import com.example.frealsb.Modules.Culture.Model.Culture;
import com.example.frealsb.Modules.Culture.CultureRepository;
import com.example.frealsb.Modules.Culture.Model.RequestCulture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CultureService implements ICultureService {
    // __CURD__ //
    @Autowired
    private CultureRepository _cultureRepository;
    @Override
    public List<Culture> getCultures(String s, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return _cultureRepository.findAllBy(s, pageable);
    }

    @Override
    public Culture getCulture(String id) {
        return _cultureRepository.findById(id).get();
    }

    @Override
    public Culture addCulture(RequestCulture req) {
        return _cultureRepository.save(req.toAddData());
    }

    @Override
    public Culture updateCulture(RequestCulture req) {
        return _cultureRepository.save(req.toUpdateData());
    }

    @Override
    public Culture deleteCulture(String id) {
        Culture culture = getCulture(id);
        culture.setDeleted(true);
        return _cultureRepository.save(culture);
    }
}
