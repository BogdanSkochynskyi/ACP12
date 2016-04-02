package ua.artcode.week8.ioc.service;

import ua.artcode.week8.ioc.dao.GeneralDao;
import ua.artcode.week8.ioc.exception.MyAppException;
import ua.artcode.week8.ioc.exception.MyLoginException;
import ua.artcode.week8.ioc.exception.MyValidationException;
import ua.artcode.week8.ioc.model.MyUser;
import ua.artcode.week8.ioc.validator.GeneralValidator;

/**
 * Created by serhii on 02.04.16.
 */
public class MyService {


    private GeneralDao genDao;
    private GeneralValidator validator;


    public String login(String email, String pass) throws MyAppException {

        if(!validator.isValidEmail(email) || !validator.isValidPass(pass)){
            throw new MyValidationException();
        }

        MyUser found = genDao.find(email);

        if(found == null){
            throw new MyLoginException("Wrong email or pass");
        }

        if(found.getPass().equals(pass)){
            return "AccessKey"; // generate AccessKey
        }

        throw new MyLoginException("Wrong email or pass");
    }

    public GeneralDao getGenDao() {
        return genDao;
    }

    public void setGenDao(GeneralDao genDao) {
        this.genDao = genDao;
    }

    public GeneralValidator getValidator() {
        return validator;
    }

    public void setValidator(GeneralValidator validator) {
        this.validator = validator;
    }
}
