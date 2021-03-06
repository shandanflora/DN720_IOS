package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/2/16.
 *
 */
public class SettingActivity {
    private static SettingActivity settingActivity = null;
    private IOSDriver driver = null;

    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")
    private MobileElement title = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")
    private MobileElement back = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
    private MobileElement textViewTimeSchedule = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")
    private MobileElement textViewWorkLog = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")
    private MobileElement textConsumable = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]")
    private MobileElement textViewRename = null;
    @FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]")
    private MobileElement textViewFindDeebot = null;

    private SettingActivity(){

    }

    public static SettingActivity getInstance(){
        if (settingActivity == null){
            settingActivity = new SettingActivity();
        }
        return settingActivity;
    }

    public void init(IOSDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void showActivity(){
        Common.getInstance().showActivity(textViewRename);
    }

    public void clickBack(){
        back.click();
    }

    public void clickWorkLog(){
        //textViewWorkLog.click();
        driver.tap(1, textViewWorkLog, 100);
    }

    public void clickTimeSchedule(){
        //textViewTimeSchedule.click();
        driver.tap(1, textViewTimeSchedule, 100);
    }

    public void clickConsumable(){
        //textViewReset.click();
        driver.tap(1, textConsumable, 100);
    }

    public void clickRename(){
        driver.tap(1, textViewRename, 100);
    }

    private boolean staticUiTranslate(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_more"));
        if (!bTitle) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", title.getText(),
                    tranMap.get("random_deebot_more"), "fail");
        }
        boolean btextViewWorkLog = textViewWorkLog.getText().equalsIgnoreCase(tranMap.get("random_deebot_work_log"));
        if (!btextViewWorkLog) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewWorkLog.getText(),
                    tranMap.get("random_deebot_work_log"), "fail");
        }
        boolean btextViewTimeSchedule = textViewTimeSchedule.getText().equalsIgnoreCase(tranMap.get("random_deebot_appointment"));
        if (!btextViewTimeSchedule) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewTimeSchedule.getText(),
                    tranMap.get("random_deebot_appointment"), "fail");
        }
        boolean btextConsumable = textConsumable.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable"));
        if (!btextConsumable) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textConsumable.getText(),
                    tranMap.get("random_deebot_consumable"), "fail");
        }
        boolean btextViewFindDeebot = textViewFindDeebot.getText().equalsIgnoreCase(tranMap.get("random_deebot_find"));
        if (!btextViewFindDeebot) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewFindDeebot.getText(),
                    tranMap.get("random_deebot_find"), "fail");
        }
        boolean btextViewRename = textViewRename.getText().equalsIgnoreCase(tranMap.get("random_deebot_rename"));
        if (!btextViewRename) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewRename.getText(),
                    tranMap.get("random_deebot_rename"), "fail");
        }
        /*showFirmVersion();
        boolean btextViewFirmware = textViewFirmware.getText().equalsIgnoreCase(tranMap.get("The_host_Settings"));
        if (!btextViewFirmware) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewFirmware.getText(),
                    tranMap.get("The_host_Settings"), "fail");
        }*/
        return bTitle && btextViewWorkLog && btextViewTimeSchedule && btextConsumable
                && btextViewRename /*&& btextViewFirmware*/;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUiTranslate(tranMap);
    }


}
