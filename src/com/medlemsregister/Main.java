package com.medlemsregister;


/**
 *  Programmet simulerar en simhall med olika typer av medlemmar.
 *  Användaren kan välja att lägga till nya medlemmar, besöka
 *  anläggningen, söka efter medlemmar och visa info på
 *  olika sätt. Den här klassen används bara för att starta
 *  igång programmet.
 *
 * @author Karin Eriksson
 * @version 1.0
 * @since 2019-10-08
 */
public class Main {

    public static void main(String[] args) {

        MemberController controller = new MemberController();

        controller.run();

    }
}
