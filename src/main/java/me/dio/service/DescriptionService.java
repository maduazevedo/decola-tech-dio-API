package me.dio.service;

import me.dio.model.Description;

public interface DescriptionService {

    Description findDescriptionById (Long id);

    Description createDescription(Description description);

    Description updateDescription(Description description);

    void deleteDescription(Long id);
}
