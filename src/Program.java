import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student user1 = new Student("Петр", 22, 3.4);
        Student user2 = new Student("Сергей", 17, 4.1);
        Student user3 = new Student("Олег", 19, 4.2);

        try(FileOutputStream fileOutputStream = new FileOutputStream("HW3JJ.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(user1);
            System.out.println("\nОбъект User1 сериализован.");
            objectOutputStream.writeObject(user2);
            System.out.println("Объект User2 сериализован.");
            objectOutputStream.writeObject(user3);
            System.out.println("Объект User3 сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("HW3JJ.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            user1 = (Student)objectInputStream.readObject();
            System.out.println("\nОбъект User1 десериализован.");
            user2 = (Student)objectInputStream.readObject();
            System.out.println("Объект User2 десериализован.");
            user3 = (Student)objectInputStream.readObject();
            System.out.println("Объект User3 десериализован.");
        }

        System.out.println("\nОбъект User1:");
        System.out.println("Имя:          " + user1.getName());
        System.out.println("Возраст:      " + user1.getAge());
        System.out.println("Средний балл: " + user1.getGPA());

        System.out.println("\nОбъект User2:");
        System.out.println("Имя:          " + user2.getName());
        System.out.println("Возраст:      " + user2.getAge());
        System.out.println("Средний балл: " + user2.getGPA());

        System.out.println("\nОбъект User3:");
        System.out.println("Имя:          " + user3.getName());
        System.out.println("Возраст:      " + user3.getAge());
        System.out.println("Средний балл: " + user3.getGPA());
        
    }
}
