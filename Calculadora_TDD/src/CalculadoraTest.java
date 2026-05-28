import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

// AAA
// Arrange - Preparar (montar o cenário)
// Act - Executar o método
// Assert - Conferir o resultado


public class CalculadoraTest {
    @Test
    void somar() {

        Calculadora calculadora = new Calculadora();

        int a = 3;
        int b = 3;

        int result = calculadora.somar(a,b);

        assertEquals(6, result);

    }
}
