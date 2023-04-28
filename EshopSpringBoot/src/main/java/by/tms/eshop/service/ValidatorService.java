package by.tms.eshop.service;

import by.tms.eshop.model.User;

import java.util.List;

public interface ValidatorService {

    List<String> getValidationErrorMessage(User user, String verifyPassword);
}