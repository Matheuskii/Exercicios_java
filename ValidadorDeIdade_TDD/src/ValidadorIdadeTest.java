import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.Assert.*;


public class ValidadorIdadeTest {



    @Test
    @DisplayName("Deve retornar true caso idade seja maior ou igual a 18")
    public void maiorDeIdade_True() {

        int idadeMaior = 19;
        int idadecertinho = 18;


        ValidadorIdade validadorIdade = new ValidadorIdade();

        Assert.assertTrue("Maior que 18 true",validadorIdade.maiorDeIdade(idadeMaior));
        Assert.assertTrue("Igual a 18 anos é true",validadorIdade.maiorDeIdade(idadecertinho));



    }


    @Test
    @DisplayName("Deve retornar false, caso idade menor que 18")
    public void menorDeIdade_False(){
        int idadeMenor = 10;

        ValidadorIdade validadorIdade = new ValidadorIdade();

        Assert.assertFalse("Menor de idade deve ser falso",validadorIdade.maiorDeIdade(idadeMenor));

    }

}