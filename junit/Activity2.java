package examples;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Activity2 {

    @Test
    void EnoughFunds(){
        BankAccount bac = new BankAccount(100);
        assertDoesNotThrow(() -> bac.withdraw(100));
    }

    @Test
    void NotEnoughFunds(){
        BankAccount bac = new BankAccount(9);
        Assert.assertThrows(NotEnoughFundsException.class, () -> bac.withdraw(10));

    }

}
