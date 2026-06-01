import br.com.senai.dao.UserDAO;
import br.com.senai.exceptions.EmptyStorageException;
import br.com.senai.exceptions.UserNotFoundException;
import br.com.senai.exceptions.ValidatorException;
import br.com.senai.model.MenuOption;
import br.com.senai.model.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static br.com.senai.validator.UserValidator.verifyModel;

public class Main {
    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args){

        while(true){
            System.out.println("Bem vindo ao menu de usuários, selecione a operação desejada ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            var userInput = scanner.nextInt();

            var selectedOption =MenuOption.values()[userInput - 1];

            switch(selectedOption){
                case SAVE ->
                        {
                            boolean cancelLoop = false;
                            while(!cancelLoop){
                            try {
                                var user = dao.save(requestToSave());
                                System.out.printf("Usuário cadastrado: %s", user);
                                cancelLoop = true;
                            } catch (ValidatorException ex){
                                System.out.println(ex.getMessage());
                            }
                            }
                        }
                case UPDATE ->
                        {
                            try {
                                var user = dao.update(requestToUpdate());
                                System.out.printf("Usuário atualizado: %s", user);
                            } catch (UserNotFoundException  | EmptyStorageException ex){
                                System.out.println(ex.getMessage());

                            } finally{
                                System.out.println("===============================");
                            }

                        }
                case DELETE ->
                        {
                            try {
                                dao.delete(requestId());
                                System.out.println("Usuário excluído");
                            } catch (UserNotFoundException  | EmptyStorageException ex){
                                System.out.println(ex.getMessage());

                            }
                        }
                case FIND_BY_ID ->
                        {
                            try{
                            var id = requestId();
                            var user = dao.findById(id);
                            System.out.printf("Usuário ocom id %s: %s", id,user);

                        } catch (UserNotFoundException  | EmptyStorageException ex){
                                System.out.println(ex.getMessage());

                            }
                        }
                case FIND_ALL ->
                        {
                            var users = dao.findAll();
                            System.out.println("Usuários cadastrados");
                            System.out.println("=================================");
                            users.forEach(System.out::println);
                            System.out.println("=================================");

                        }
                case EXIT -> System.exit(0);

                }
            }
        }

    private static long requestId() {
        System.out.println("Informe o identificador do Usuário");
        return scanner.nextLong();
    }
    private static UserModel requestToSave() throws ValidatorException {
      var infoUser = requestUserInfo();
        return new UserModel(0,infoUser.getNome(), infoUser.getEmail(),infoUser.getBirthday() );

    }

    private static UserModel requestUserInfo() {
        System.out.println("Informe o nome do Usuário");
        var name = scanner.next();
        System.out.println("Informe o e-mail do Usuário");
        var email = scanner.next();

        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        UserModel model;
        model = validateInput(name, email, birthday);
        return model;

    }
    private static UserModel validateInput(final String name, final String email, final LocalDate birthday){
        UserModel user = null;
        try {
          user = new UserModel(0, name, email, birthday);
          verifyModel(user);
      } catch (ValidatorException e) {
            System.out.println(e.getMessage());

        }
        return user;
    }

    private static UserModel requestToUpdate() {
        var id = requestId();

        var infoUser = requestUserInfo();

        return new UserModel(id,infoUser.getNome(), infoUser.getEmail(),infoUser.getBirthday() );

    }



}