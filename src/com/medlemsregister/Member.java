package com.medlemsregister;

/**
 * Klassen representerar en medlem. Denna klass är abstrakt och
 * har flera subklasser.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 *
 */
public abstract class Member {

    private String name;
    private int age;
    private int numberOfVisits;
    private boolean isVip;
    private int memberNumber;


    public Member(String name, int age, int memberNumber) {
        this.name = name;
        this.age = age;
        this.memberNumber = memberNumber;
        this.numberOfVisits = 0;
        this.isVip = false;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public boolean isVip() {
        return isVip;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    /**
     * Registrerar ett besök för medlemmen. Ökar numberOfVisits
     * med 1.
     *
     * @return ett meddelande som talar om hur många gånger
     * medlemmen har besökt simhallen
     */
    public String makeVisit() {

        numberOfVisits++;
        String message = "Du har besökt oss " + numberOfVisits + " gång";
        if (numberOfVisits > 1){
            message += "er";
        }
        return message;

    }

    /**
     * Sätter isVip till true
     *
     * @return ett meddelande som säger att medlemmen har blivit VIP
     */
    public String upgradeToVip() {

        isVip = true;
        return "\nDu är nu VIP-medlem!";

    }

    /**
     * Genererar ett meddelande som beskriver medlemmen. Namn,
     * ålder och antal besök redovisas, plus information om
     * att medlemmen är VIP-medlem om så är fallet.

     * @return ett meddelande som beskriver medlemmen
     */
    public String getInfo() {

        String info = (name + ", " + age + " år.\n" + "Antal besök: " + numberOfVisits);
        if (isVip){
            info += "\nVIPmedlem!";
        }
        return info;
    }
}
