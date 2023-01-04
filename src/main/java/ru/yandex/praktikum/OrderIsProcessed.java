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
    private By orderIsProcessed=By.xpath("//div[text()='Заказ оформлен']");
    //метод возвращает истину, если поле Заказ оформлен отображено
    public boolean orderIsProcessedTextIsDisplayed(){

        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}
