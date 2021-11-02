package guru.qa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Register {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void openUrl() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void Register() {
        $("#firstName").setValue("Maxim");
        $("#lastName").setValue("Teryokhin");
        $("#userEmail").setValue("test@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9991111111");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $$(".react-datepicker__day").find(text("12")).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/main/resources/img.jpg"));
        $("#currentAddress").setValue("Russia");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Maxim Teryokhin"), text("test@gmail.com"),
                text("Male"), text("9991111111"), text("12 December,1992"), text("Music"),
                text("img.jpg"), text("Russia"), text("NCR Delhi"));
    }
}