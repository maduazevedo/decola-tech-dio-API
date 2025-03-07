package me.dio.service.impl;
import me.dio.model.Description;
import me.dio.repository.DescriptionRepository;
import me.dio.repository.ErroRepository;
import me.dio.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DescriptionImpl implements DescriptionService {

    @Autowired
    DescriptionRepository descriptionRepository;
    @Autowired
    ErroRepository erroRepository;

    @Override
    public Description findDescriptionById(Long id) {
        if (descriptionRepository.existsById(id)) {
            return descriptionRepository.findById(id).get();
        } else {
            throw new NoSuchElementException("Description not found");
        }
    }

    @Override
    public Description createDescription(Description description) {
        if (description.getId_description() == null) {
            throw new IllegalArgumentException("Description id can't be null");
        }
        if(descriptionRepository.existsById(description.getId_description())) {
            throw new IllegalArgumentException("Description already exists");
        }
        return descriptionRepository.save(description);
    }

    @Override
    public Description updateDescription(Description description) {

        if(!descriptionRepository.existsById(description.getId_description())) {
            throw new IllegalArgumentException("Description not found to update");
        }
        return descriptionRepository.save(description);
    }

    @Override
    public void deleteDescription(Long id) {
        if (!descriptionRepository.existsById(id)) {
                throw new IllegalArgumentException("Description not found");
            }
            descriptionRepository.deleteById(id);
        }
    }

