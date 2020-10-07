package org.example.test;

import org.example.base.BaseTest;
import org.example.page.Scenario_1_PAGE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.constants.constantsLoginPage.*;

/**
 * @author  Ozan Karali
 * @since 07.10.2020
 */

public class Scenario1PAGETest extends BaseTest {
    Scenario_1_PAGE scenario1PAGE;

    private static Logger log = LogManager.getLogger(Scenario1PAGETest.class);
    @BeforeClass
    public static void beforeClass() throws Exception {
        log.info("**************** Test started ****************");
    }

    @Before
    public void before() {
        scenario1PAGE = new Scenario_1_PAGE(getWebDriver());
        log.info("**************** Driver activated ***************");

    }


    @Test
        public void testLogin() throws InterruptedException {
            log.info("**************** Trendyol test Started ***************");
            scenario1PAGE
                    .closePop()  //pop-up kapatıldı
                    .clickLogInButton() //Giriş yap butonuna tıklanıldı
                    .writeEmailAndPassword() //Email ve Password bilgileri girildi
                    .clickSubmitButton(); //Submit Buttona tıklanarak giriş yapıldı.


        // basketItemCount // sepet üstü yazı

            Assert.assertEquals("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da", getWebDriver().getTitle());

            WebDriverWait wait = new WebDriverWait(getWebDriver(),20);
            wait.until(ExpectedConditions.titleIs("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da"));
            Thread.sleep(2000);

            scenario1PAGE
                    .click_All_Tabs() //Tüm tab'lara tek tek tıklandı.
                    .clickTab_COCUK() //Çocuk Tab'ına tıklanıldı ve butik görsellerinin yüklendiği görüldü
                    .clickRandomly(LIST_OF_IMAGES) // Butik listesinden HERHANGİ birine tıklandı
                    .clickRandomly(LIST_OF_PRODUCTS) // Gelen ürünlerden HERHANGİ birine tıklandı
                    .click(ADD_TO_BASKET_BUTTON); // Tıklanılan ürün sepete eklendi

            log.info("**************** PRODUCT ADD THE BASKET *************");
            log.info("**************** SCENARIO FINISHED *************");


    }


    @After
    public void after() throws InterruptedException {
        tearDown();
        log.info("**************** Test Finished ****************");
    }
}
