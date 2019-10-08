package com.medlemsregister;


/**
 * Subklass av member. Representerar medlemmar mellan 13 och 19 år.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */
public class Junior extends Member {

    public Junior(String name, int age, int memberNumber){
        super(name, age, memberNumber);
    }

    @Override
    public String getInfo() {
        return (super.getInfo() + "\nÄr ungdomsmedlem");
    }

    @Override
    public String makeVisit() {
        String message = super.makeVisit();
        if (getNumberOfVisits() == 15){
            message += (upgradeToVip() + "\nDu får gratis inträde till våra vattendiskon!");
        }
        return message;
    }
}
