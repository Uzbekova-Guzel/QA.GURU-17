package tests.owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverConfigOld {

    public String getBaseUrl() {
        //Зачитываем значение из настроек
        String baseUrl = System.getProperty("baseUrl");
        //Проверяем дефолтное значение
        if (Objects.isNull(baseUrl)) {
            baseUrl = "https://github.com";
        }
        //Возвращаем результат
        return baseUrl;
    }

    public Browser getBrowser() {
        //Зачитываем значение из настроек
        String browser = System.getProperty("browser");
        //Проверяем дефолтное значение
        if (Objects.isNull(browser)) {
            browser = "CHROME";
        }
        //Возвращаем результат с приведением типов
        return Browser.valueOf(browser);
    }

    public URL getRemoteURL() {
        //Зачитываем значение из настроек
        String remoteUrl = System.getProperty("remoteUrl");
        //Проверяем дефолтное значение
        if (Objects.isNull(remoteUrl)) {
            remoteUrl = "http://localhost:4444";
        }
        //Возвращаем результат с приведением типов
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
