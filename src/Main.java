public class Main {
    public static void main(String[] args) {
        Competitive[] participent = new Competitive[6];
        participent[0] = new Human();
        participent[1] = new Cat();
        participent[2] = new Robot();
        participent[3] = new Cat("Семен", 7000, 10);
        participent[4] = new Robot("Модель 654L7851", 12000, 8);
        participent[5] = new Human("Егор", 12000, 10);


        Obstacles[] obstacles = new Obstacles[3];
        obstacles[0] = new RunTrack(8000, "Бег на короткую дистанцию");
        obstacles[1] = new Wall(5.f, "Прыжок в высоту с разбега");
        obstacles[2] = new RunTrack(12000, "Бег на длинную дистанцию");
        letsStartCompetition(participent, obstacles);
    }

    public static void letsStartCompetition(Competitive[] participent, Obstacles[] obstacles) {


        for (int i = 0; i < obstacles.length; i++) {

            if (i == 0) {
                System.out.println(String.format("Соревнование №1. %s %.2f метров", obstacles[0].type, obstacles[0].value));
            } else if (i == 1) {
                System.out.println(String.format("Соревнование №2. %s.  Высота %.2f метров", obstacles[1].type,obstacles[1].value));

            } else {
                System.out.println(String.format("Соревнование №3. %s  %.2f метров",obstacles[2].type, obstacles[2].value));
            }
            for (int j = 0; j < participent.length; j++) {
                if (participent[j] == null) {
                   continue;
                }
                System.out.println("Участник № " + (j + 1) + " " + participent[j].getName() + " на старте...");

                if (obstacles[i].isItPossibleToDo(participent[j])) {
                    if (i == obstacles.length - 1) {
                        System.out.println("Участник " + participent[j].getName() + " преодолел все препятствия. Поздравляем");
                    } else {

                        System.out.println("Участник " + participent[j].getName() + " прошел испытание и продолжит соревнование");
                    }
                } else {

                    System.out.println("Участник " + participent[j].getName() + " не прошел испытание и покидает соревнование");
                    participent[j] = null;

                }
            }
        }
        System.out.println("Результаты:");
        for (Competitive participant : participent) {
            if (participant != null) {
                System.out.println("Участник " + participant.getName() + " прошел все испытания");
            }

        }
    }

}
