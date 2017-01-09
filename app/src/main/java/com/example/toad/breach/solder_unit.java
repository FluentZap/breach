package com.example.toad.breach;

/**
 * Created by Toad on 1/9/2017.
 */

public class solder_Unit {

    /**
     * List of classes and equipment may be moved to another class
     *
     */
    public enum uClassT
    {
        RECRUIT,
        SOLDER,
        MAGE

    }

    public enum uEq_WeaponT
    {
        WOOD_SWORD,
        WOOD_GREATSWORD,
        WOOD_BOW,
        WOOD_MACE,
        WOOD_STAFF
    }

    public int max_hp, hp, max_mp, mp, attack, spirit, defence, resistance, speed, movement;
    public int Level, xp;

    public uEq_WeaponT unit_Weapon;

    public uClassT unit_Class;


    public solder_Unit() {
        unit_Class = uClassT.RECRUIT;
        unit_Weapon = uEq_WeaponT.WOOD_SWORD;
    }


}
