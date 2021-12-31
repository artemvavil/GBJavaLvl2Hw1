package homework1;

public class Add {

    public static void main(String[] args) {

    Human human = new Human();
    human.jump();
    human.run();

    Cat cat = new Cat();
    cat.jump();
    cat.run();

    Robot robot = new Robot();
    robot.jump();
    robot.run();

    Participants participants;
    Obstacles obstacles;

    Participants[] participant = new Participants[5];
    Obstacles[] obstacle = new Obstacles[2];

    participant[0] = new Human("Артем", 2, 250);
    participant[1] = new Human("Андрей", 1, 170);
    participant[2] = new Cat("Барсик", 3, 1000);
    participant[3] = new Cat("Мурзик", 4, 500);
    participant[4] = new Robot("ВасилийВИ", 1, 10000);

    obstacle[0] = new Track(1000);
    obstacle[1] = new Wall(1);

    for (int i = 0; i < participant.length; i++) {

        for (int j = 0; j < obstacle.length; j++) {

            participant[i].getOver(obstacle[j]);

            if (!participant[i].getAttempt()) break;
        }
    }


}

}
