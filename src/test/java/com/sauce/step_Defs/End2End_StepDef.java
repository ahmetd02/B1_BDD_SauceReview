package com.sauce.step_Defs;

import com.sauce.pages.CheckOutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class End2End_StepDef {
    LoginPage loginPage=new LoginPage();
    ProductsPage productsPage=new ProductsPage();
    CheckOutPage checkOutPage=new CheckOutPage();
    @When("The user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("The user should be able to login and see {string} header")
    public void theUserShouldBeAbleToLoginAndSeeHeader(String expectedText) {
        productsPage.isDisplayedMethod();
    }

    @And("The user should be able to sort products {string}")
    public void theUserShouldBeAbleToSortProducts(String sortType) {
        productsPage.sortProduct(sortType);
    }

    @When("The user clicks cheapest as {string} and the second costline as {string} products")
    public void theUserClicksCheapestAsAndTheSecondCostlineAsProducts(String cheapest, String secondCost) {
        productsPage.addProducts(cheapest);
        productsPage.addProducts(secondCost);
    }

    @And("The user opens the basket")
    public void theUserOpensTheBasket() {
        productsPage.cartBtn.click();
    }

    @And("The user clicks on checkout button")
    public void theUserClicksOnCheckoutButton() {
        checkOutPage.checkOutBtn.click();
    }

    @And("The user enters details as {string} {string} {string} and finish purchase")
    public void theUserEntersDetailsAsAndFinishPurchase(String firstname, String lastname, String postalCode) {
        checkOutPage.enterDetails(firstname,lastname,postalCode);
    }

    @Then("The user verifies that the items are {string} and total is {string}")
    public void theUserVerifiesThatTheItemsAreAndTotalIs(String totalPrice, String expectedTotal) {
        Assert.assertEquals(expectedTotal,checkOutPage.getTotalPrice(totalPrice));
        System.out.println("expectedTotal = " + expectedTotal);
        System.out.println("totalPrice = " + totalPrice);
    }
}
