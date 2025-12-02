package org.example.adaptorPattern;

public class ApplePhone {
    private AppleCharger charger;

    public ApplePhone(AppleCharger charger) {
        this.charger = charger;
    }

    public void chargeIPhone(){
        charger.chargePhone();

    }
}
