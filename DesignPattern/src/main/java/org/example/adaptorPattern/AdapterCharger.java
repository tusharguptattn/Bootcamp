package org.example.adaptorPattern;

public class AdapterCharger implements AppleCharger{
    private AndroidCharger charger;

    public AdapterCharger(AndroidCharger charger) {
        this.charger = charger;
    }

    @Override
    public void chargePhone() {
        charger.chargeAndroid();
        System.out.println("Your Iphone is charging with adapter from android charger");
    }
}
