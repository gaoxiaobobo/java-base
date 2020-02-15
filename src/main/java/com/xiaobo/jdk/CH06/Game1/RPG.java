package com.xiaobo.jdk.CH06.Game1;

public class RPG {
    public static void main(String[] args) {
        demoSwordsMan();
        demoMagician();
    }

    static void demoSwordsMan() {
        SwordsMan swordsMan = new SwordsMan();
        swordsMan.setName("Justin");
        swordsMan.setLevel(1);
        swordsMan.setBlood(200);
        System.out.printf("劍士：(%s, %d, %d)%n", swordsMan.getName(),
                swordsMan.getLevel(), swordsMan.getBlood());
        showBlood(swordsMan);
    }

    static void demoMagician() {
        Magician magician = new Magician();
        magician.setName("Monica");
        magician.setLevel(1);
        magician.setBlood(100);
        System.out.printf("魔法師：(%s, %d, %d)%n", magician.getName(),
                magician.getLevel(), magician.getBlood());
    }
    static void showBlood(Role r){
        System.out.printf("%s have %d blood.\n",r.getName(),r.getBlood());
    }
}
