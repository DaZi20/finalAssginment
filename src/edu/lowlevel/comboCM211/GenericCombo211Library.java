/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lowlevel.comboCM211;

/**
 *
 * @author luiri60
 */
public class GenericCombo211Library extends ComboCM211SendAndGet {

    public static final int PIN_20 = 20;
    public static final int PIN_21 = 21;
    public static final int PIN_22 = 22;
    public static final int PIN_23 = 23;
    public static final int PIN_24 = 24;
    public static final int PIN_25 = 25;
    public static final int PIN_26 = 26;
    public static final int PIN_27 = 27;
    public static final int PIN_29 = 29;
    public static final int PIN_30 = 30;
    public static final int PIN_31 = 31;
    public static final int PIN_32 = 32;
    public static final int PIN_33 = 33;
    public static final int PIN_34 = 34;
    public static final int PIN_35 = 35;
    public static final int PIN_36 = 36;

    private boolean value_PIN_20;
    private boolean value_PIN_21;
    private boolean value_PIN_22;
    private boolean value_PIN_23;
    private boolean value_PIN_24;
    private boolean value_PIN_25;
    private boolean value_PIN_26;
    private boolean value_PIN_27;
    private boolean value_PIN_29;
    private boolean value_PIN_30;
    private boolean value_PIN_31;
    private boolean value_PIN_32;
    private boolean value_PIN_33;
    private boolean value_PIN_34;
    private boolean value_PIN_35;
    private boolean value_PIN_36;

    public GenericCombo211Library(String hostName, int port) {
        super(hostName, port);
    }

    public boolean isValue_PIN_20() {
        updateSensors();
        return value_PIN_20;
    }

    public boolean isValue_PIN_21() {
        updateSensors();
        return value_PIN_21;
    }

    public boolean isValue_PIN_22() {
        updateSensors();
        return value_PIN_22;
    }

    public boolean isValue_PIN_23() {
        updateSensors();
        return value_PIN_23;
    }

    public boolean isValue_PIN_24() {
        updateSensors();
        return value_PIN_24;
    }

    public boolean isValue_PIN_25() {
        updateSensors();
        return value_PIN_25;
    }

    public boolean isValue_PIN_26() {
        updateSensors();
        return value_PIN_26;
    }

    public boolean isValue_PIN_27() {
        updateSensors();
        return value_PIN_27;
    }

    public boolean isValue_PIN_29() {
        updateSensors();
        return value_PIN_29;
    }

    public boolean isValue_PIN_30() {
        updateSensors();
        return value_PIN_30;
    }

    public boolean isValue_PIN_31() {
        updateSensors();
        return value_PIN_31;
    }

    public boolean isValue_PIN_32() {
        updateSensors();
        return value_PIN_32;
    }

    public boolean isValue_PIN_33() {
        updateSensors();
        return value_PIN_33;
    }

    public boolean isValue_PIN_34() {
        updateSensors();
        return value_PIN_34;
    }

    public boolean isValue_PIN_35() {
        updateSensors();
        return value_PIN_35;
    }

    public boolean isValue_PIN_36() {
        updateSensors();
        return value_PIN_36;
    }

    public void setValue_PIN_20(boolean value_PIN_20) {
        writePin(PIN_20, value_PIN_20);
    }

    public void setValue_PIN_21(boolean value_PIN_21) {
        writePin(PIN_21, value_PIN_21);
    }

    public void setValue_PIN_22(boolean value_PIN_22) {
        writePin(PIN_22, value_PIN_22);
    }

    public void setValue_PIN_23(boolean value_PIN_23) {
        writePin(PIN_23, value_PIN_23);
    }

    public void setValue_PIN_24(boolean value_PIN_24) {
        writePin(PIN_24, value_PIN_24);
    }

    public void setValue_PIN_25(boolean value_PIN_25) {
        writePin(PIN_25, value_PIN_25);
    }

    public void setValue_PIN_26(boolean value_PIN_26) {
        writePin(PIN_26, value_PIN_26);
    }

    public void setValue_PIN_27(boolean value_PIN_27) {
        writePin(PIN_27, value_PIN_27);
    }

    public void setValue_PIN_29(boolean value_PIN_29) {
        writePin(PIN_29, value_PIN_29);
    }

    public void setValue_PIN_30(boolean value_PIN_30) {
        writePin(PIN_30, value_PIN_30);
    }

    public void setValue_PIN_31(boolean value_PIN_31) {
        writePin(PIN_31, value_PIN_31);
    }

    public void setValue_PIN_32(boolean value_PIN_32) {
        writePin(PIN_32, value_PIN_32);
    }

    public void setValue_PIN_33(boolean value_PIN_33) {
        writePin(PIN_33, value_PIN_33);
    }

    public void setValue_PIN_34(boolean value_PIN_34) {
        writePin(PIN_34, value_PIN_34);
    }

    public void setValue_PIN_35(boolean value_PIN_35) {
        writePin(PIN_35, value_PIN_35);
    }

    public void setValue_PIN_36(boolean value_PIN_36) {
        writePin(PIN_36, value_PIN_36);
    }

    //-------------------- Private functions ----------------------------------
    private void writePin(int pinNumber, boolean value) {
        if (value) {
            sendCommand("wp" + pinNumber);//write pin
        } else {
            sendCommand("cp" + pinNumber);//clear pin
        }
    }

    private byte[] readIOs() {
        return getData();
    }

    private void updateSensors() {

        byte[] ios = readIOs();

        short pins20_27 = ios[0];
        short pins29_36 = ios[1];
        
        for (int i = 7; i >= 0; i--) {

            boolean pins20_27Bool = ((pins20_27 & 128) == 128);
            boolean pins29_36Bool = ((pins29_36 & 128) == 128);
            switch (i) {
                case 0:
                    value_PIN_20 = pins20_27Bool;
                    value_PIN_29 = pins29_36Bool;
                    break;
                case 1:
                    value_PIN_21 = pins20_27Bool;
                    value_PIN_30 = pins29_36Bool;
                    break;
                case 2:
                    value_PIN_22 = pins20_27Bool;
                    value_PIN_31 = pins29_36Bool;
                    break;
                case 3:
                    value_PIN_23 = pins20_27Bool;
                    value_PIN_32 = pins29_36Bool;
                    break;
                case 4:
                    value_PIN_24 = pins20_27Bool;
                    value_PIN_33 = pins29_36Bool;
                    break;
                case 5:
                    value_PIN_25 = pins20_27Bool;
                    value_PIN_34 = pins29_36Bool;
                    break;
                case 6:
                    value_PIN_26 = pins20_27Bool;
                    value_PIN_35 = pins29_36Bool;
                    break;
                case 7:
                    value_PIN_27 = pins20_27Bool;
                    value_PIN_36 = pins29_36Bool;
                    break;
            }
            pins20_27 = (short) (pins20_27 << 1);
            pins29_36 = (short) (pins29_36 << 1);
        }

    }

}
