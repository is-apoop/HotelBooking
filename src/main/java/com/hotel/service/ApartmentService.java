package com.hotel.service;

import com.hotel.dao.CategoryDao;
import com.hotel.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 19.04.2015.
 */
@Service
public class ApartmentService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getAllApartments() {
        return categoryDao.findAll();
    }
}