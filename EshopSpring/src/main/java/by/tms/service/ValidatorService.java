package by.tms.service;

import by.tms.model.User;

import java.util.List;

public interface ValidatorService {

    List<String> getValidationErrorMessage(User user, String verifyPassword);
}