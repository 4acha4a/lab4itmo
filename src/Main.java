public class Main {

    public static void main(String[] args) throws CoordinateOutOfBoundsException,CountException {
        Shorty [] sh = new Shorty[5];
        Object [] ob = new Object[5];
        Porridge [] pr = new Porridge[5];
        for (int i = 0; i < sh.length; i++) {
            sh[i] = new Shorty("Коротышка " + (i+1));
            ob[i] = new Object("Мебель");
            pr[i] = new Porridge("Комочек каши");
        }
        Shorty Shpuntik = new Shorty ("Шпунтик") {
            @Override
            public void spin(){
                System.out.println(this + " завертелся волчком");
            }
            public void avoid(Object.PanOfPorridge p){
                System.out.println("О нет, " + this + " слишком близко к " + p);
                System.out.println("Кажется, столкновение неизбежно");
            }
        };
        Shorty Neznaika = new Shorty("Незнайка"){
            @Override
            public void damageothers(Shorty s) {
                if (getAngry()){
                s.hp -= power;
                System.out.println(this + " дал сильного подзатыльника " + s);
                System.out.println(s + " полетел от такого сильного удара");
                s.spin();
                System.out.println(this + " полетел в противоположную сторону");
                }
                else {
                    s.hp-=power;
                    hp-=power;
                    System.out.println(this + " столкнулся с " + s);
                }
            }
            @Override
            public void moveinroom(){
                x += Math.round(Math.random() * 20 - 10);
                checkboundsX();
                y += Math.round(Math.random() * 20 - 10);
                checkboundsY();
                z += Math.round(Math.random() * 20 - 10);
                checkboundsZ();
                System.out.println(this + " летит по комнате");
            }
        };
        Object.PanOfPorridge Pan = new Object.PanOfPorridge("Кастрюля с кашей");
        for (int i = 0; i< sh.length;i++){
            Pan.putPorridge(pr[i]);
            System.out.println("");
        }
        Pan.moveinroom();
        System.out.println("");
        Neznaika.setAngry(true);
        while (Neznaika.distance(Shpuntik)>5){
            System.out.println("");
            Neznaika.approach(Shpuntik);
            System.out.println("");
            Shpuntik.avoidFight(Neznaika);
            Shpuntik.moveinroom();
        }
        System.out.println("");
        Neznaika.damageothers(Shpuntik);
        Neznaika.setAngry(false);
        System.out.println("");
        int k = 0;
        while (k<1){
                Neznaika.moveinroom();
                Shpuntik.moveinroom();
                Pan.moveinroom();
                System.out.println("");
                if (Neznaika.distance(Pan) <= 5) {
                    Neznaika.avoid(Pan);
                    Pan.damageothers(Neznaika);
                    k++;
                }
                if (Shpuntik.distance(Pan) <= 5) {
                    Shpuntik.avoid(Pan);
                    Pan.damageothers(Shpuntik);
                    k++;
                }
        }
        System.out.println("");
        Shorty Donut = new Shorty("Плюющийся пончик",Pan.getX(),Pan.getY(),Pan.getZ()){
            @Override
            public void moveinroom(){
                x += Math.round(Math.random() * 20 - 10);
                checkboundsX();
                y += Math.round(Math.random() * 20 - 10);
                checkboundsY();
                z += Math.round(Math.random() * 20 - 10);
                checkboundsZ();
                System.out.println(this + " летит по комнате");
            }
        };
        if (Pan.distance(Donut)<5){
            Pan.damageothers(Donut);
        }
        System.out.println("");
        for (int i = 0; i<sh.length; i++){
            Pan.outPorridge(pr[i]);
            System.out.println("");
        }
        System.out.println("");
        k = 0;
            while (k<1) {
                for (int i = 0; i < sh.length; i++) {
                    for (int j = 0; j < sh.length; j++) {
                        if (k<1) {
                            Donut.moveinroom();
                            pr[j].moveinroom();
                            ob[j].moveinroom();
                            System.out.println(" ");
                            if (sh[i].distance(pr[j]) <= 25) {
                                sh[i].avoid(pr[j]);
                                sh[i].moveinroom();
                                if (sh[i].distance(pr[j]) <= 10) {
                                    pr[j].damageothers(sh[i]);
                                    if (sh[i].getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло! ");
                                }
                                System.out.println(" ");
                            }
                            if (Neznaika.distance(pr[j]) <= 25) {
                                Neznaika.avoid(pr[j]);
                                Neznaika.moveinroom();
                                if (Neznaika.distance(pr[j]) <= 10) {
                                    pr[j].damageothers(Neznaika);
                                    if (Neznaika.getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло! ");
                                }
                                System.out.println(" ");
                            }
                            if (Shpuntik.distance(pr[j]) <= 25) {
                                Shpuntik.avoid(pr[j]);
                                Shpuntik.moveinroom();
                                if (Shpuntik.distance(pr[j]) <= 10) {
                                    pr[j].damageothers(Shpuntik);
                                    if (Shpuntik.getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло! ");
                                }
                                System.out.println(" ");
                            }
                            if ((sh[i].distance(sh[j]) <= 25) && (i != j)&&(k<1)) {
                                sh[i].avoid(sh[j]);
                                sh[i].moveinroom();
                                sh[j].moveinroom();
                                if (sh[i].distance(sh[j]) <= 5) {
                                    sh[i].damageothers(sh[j]);
                                    if (sh[i].getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло!");
                                }
                                System.out.println(" ");
                            }
                            if ((sh[i].distance(ob[j]) <= 25)&&(k<1)) {
                                sh[i].avoid(ob[j]);
                                sh[i].moveinroom();
                                if (sh[i].distance(ob[j]) <= 5) {
                                    ob[j].damageothers(sh[i]);
                                    if (sh[i].getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло!");
                                }
                                System.out.println(" ");
                            }
                            if ((Neznaika.distance(ob[j]) <= 25)&&(k<1)) {
                                Neznaika.avoid(ob[j]);
                                Neznaika.moveinroom();
                                if (Neznaika.distance(ob[j]) <= 5) {
                                    ob[j].damageothers(Neznaika);
                                    if (Neznaika.getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло!");
                                }
                                System.out.println(" ");
                            }
                            if ((Shpuntik.distance(ob[j]) <= 25)&&(k<1)) {
                                Shpuntik.avoid(ob[j]);
                                Shpuntik.moveinroom();
                                if (Shpuntik.distance(ob[j]) <= 5) {
                                    ob[j].damageothers(sh[i]);
                                    if (Shpuntik.getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло!");
                                }
                                System.out.println(" ");
                            }
                            if ((sh[i].distance(Donut) <= 25)&&(k<1)) {
                                sh[i].avoid(Donut);
                                sh[i].moveinroom();
                                if (sh[i].distance(Donut) <= 5) {
                                    sh[i].damageothers(Donut);
                                    if (sh[i].getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло!");
                                }
                                System.out.println(" ");
                            }
                            if ((sh[i].distance(Neznaika) <= 25)&&(k<1)) {
                                sh[i].avoid(Neznaika);
                                sh[i].moveinroom();
                                if (sh[i].distance(Neznaika) <= 5) {
                                    sh[i].damageothers(Neznaika);
                                    if (sh[i].getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло!");
                                }
                                System.out.println(" ");
                            }
                            if ((sh[i].distance(Shpuntik) <= 25)&&(k<1)) {
                                sh[i].avoid(Shpuntik);
                                sh[i].moveinroom();
                                if (sh[i].distance(Shpuntik) <= 5) {
                                    sh[i].damageothers(Shpuntik);
                                    if (sh[i].getHP()<10) k++;
                                } else {
                                    System.out.println("Фух, пронесло!");
                                }
                                System.out.println(" ");
                            }
                            System.out.println(" ");
                        }
                    }
                }
            }
        Shorty Znaika = new Shorty("Знайка",50,50,50);
        Object Table = new Object("Стол",50,51,50);
        Znaika.setAngry(true);
        if (Znaika.distance(Table)<=5) {
            Table.damageothers(Znaika);
        }
        System.out.println("");
        Neznaika.stop();
        System.out.println("");
        Shpuntik.stop();
        System.out.println("");
        for (Shorty shorty : sh) {
            shorty.stop();
            System.out.println("");
        }
    }
}