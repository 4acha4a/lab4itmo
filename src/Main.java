public class Main {

    public static void main(String[] args) {
        Shorty [] sh = new Shorty[5];
        Object [] ob = new Object[5];
        Porridge [] pr = new Porridge[5];
        for (int i = 0; i < 5; i++) {
            sh[i] = new Shorty("Коротышка " + (i+1));
            ob[i] = new Object("Мебель");
            pr[i] = new Porridge("Комочек каши");
        }
        Shorty Donut = new Shorty("Плюющийся пончик");
        int k = 0;
            while (k<1) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (k<1) {
                            pr[j].moveinroom();
                            ob[j].moveinroom();
                            Donut.moveinroom();
                            System.out.println(" ");
                            if (((sh[i].distance(pr[j]) <= 25))&&(k<1)) {
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
                            System.out.println(" ");
                        }
                    }
                }
            }
        Shorty KnowAll = new Shorty("Знайка",50,50,50);
        Object Table = new Object("Стол",50,51,50);
        KnowAll.setAngry();
        if (KnowAll.distance(Table)<=5) {
            Table.damageothers(KnowAll);
        }
    }
}
