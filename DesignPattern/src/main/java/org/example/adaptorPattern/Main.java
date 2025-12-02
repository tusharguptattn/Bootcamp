package org.example.adaptorPattern;

public class Main {

    public static void main(String[] args) {
//        AppleCharger appleCharger = new AppleChargerImpl();
        AndroidCharger androidCharger = new AndroidChargerImpl();
        AppleCharger appleCharger = new AdapterCharger(androidCharger);
        ApplePhone applePhone = new ApplePhone(appleCharger);
        applePhone.chargeIPhone();



        AndroidPhone androidPhone = new AndroidPhone(androidCharger);
        androidPhone.chargeAndroid();

    }
}
