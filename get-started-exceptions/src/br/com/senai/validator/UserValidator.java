package br.com.senai.validator;

import br.com.senai.exceptions.ValidatorException;
import br.com.senai.model.UserModel;

public class UserValidator {

    private  UserValidator(){

    }
    public static void verifyModel(final UserModel model) throws ValidatorException {

        if(StringIsBlank(model.getNome()))
            throw new ValidatorException("Informe um nome válido");
        if(model.getNome().length() <=1)
            throw new ValidatorException("O nome deve ter mais que um caractér");
        if(StringIsBlank(model.getEmail()))
            throw new ValidatorException("Informe um e-mail válido");

        if(!(model.getEmail().contains("@")) && (!model.getEmail().contains(".")))
            throw new ValidatorException("Informe um e-mail válido");
    }
    private static boolean StringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}
