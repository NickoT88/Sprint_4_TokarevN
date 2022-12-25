package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//класс страницы Заказ оформлен
public class OrderIsProcessed {
    private WebDriver driver;

    public OrderIsProcessed(WebDriver driver){

        this.driver=driver;
    }

    //Локатор поля Заказ оформлен
    private By orderIsProcessed=By.className("Order_ModalHeader__3FDaJ");
    //метод получает текст из поля Заказ оформлен
    public boolean orderIsProcessedTextIsDisplayed(){

        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}
