package com.medlemsregister;


/**
 * Subklass av member. Representerar medlemmar över 65 år.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */
public class Senior extends Member {

    public Senior(String name, int age, int memberNumber) {
        super(name, age, memberNumber);
    }

    @Override
    public String getInfo() {
        return (super.getInfo() + "\nÄr pensionär");
    }

    @Override
    public String makeVisit() {
        String message = super.makeVisit();
        if (getNumberOfVisits() == 10){
            message += (upgradeToVip() + "\nDu får gå på vattengympa gratis en gång i veckan!");
        }
        return message;
    }
}

