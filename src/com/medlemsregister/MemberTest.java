package com.medlemsregister;


/**
 * En testklass som kör programmet efter att först ha skapat
 * ett antal medlemmar och registrerat ett antal besök.
 * Klassen används för att lättare kunna testa programmet
 * utan att behöva mata in en massa data först.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */

public class MemberTest {

    public static void main(String[] args){

        MemberController controller = new MemberController();

        controller.addMember("Otto", 88);
        controller.addMember("Elsa", 85);
        controller.addMember("Astrid", 92);
        controller.addMember("Ulla", 68);
        controller.addMember("Johan", 45);
        controller.addMember("Erik", 52);
        controller.addMember("Hanna", 33);
        controller.addMember("Caroline", 24);
        controller.addMember("Tove", 15);
        controller.addMember("Victor", 17);
        controller.addMember("Emma", 14);
        controller.addMember("Linus", 16);

        for (int i = 0; i < 19; i++){
            controller.makeVisit(5);
        }

        for (int i = 0; i < 9; i++){
            controller.makeVisit(3);
        }

        controller.makeVisit(2);

        for (int i = 0; i < 14; i++){
            controller.makeVisit(11);
        }

        controller.run();
    }

}
