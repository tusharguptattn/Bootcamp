package org.example.adaptorPattern;

public class AndroidPhone {
    private AndroidCharger charger;

    public AndroidPhone(AndroidCharger charger) {
        this.charger = charger;
    }

    public void chargeAndroid(){
        charger.chargeAndroid();
    }

}
