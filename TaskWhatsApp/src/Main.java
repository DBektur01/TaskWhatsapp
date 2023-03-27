import whatsapp.classes.Profile;
import whatsapp.service.serviceImpl.ProfileServiceImpl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Profile> profiles = new ArrayList<>();
        ProfileServiceImpl profileService = new ProfileServiceImpl();
        Scanner scanner = new Scanner(System.in);
        LocalTime now = LocalTime.now();
        if (now.getHour()>=4&&now.getHour()<=10) {
            System.out.println("Good morning!   A clock -> " + now.getHour()+":"+ now.getMinute());
        }else if (now.getHour()>=11&&now.getHour()<18){
            System.out.println("Good day!   A clock -> " + now.getHour()+":"+ now.getMinute());
        }
        else {
            System.out.println("Good evening!   A clock -> " + now.getHour() + ":" + now.getMinute());
        }
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("""
                    0. Exit
                    1. Install WhatsApp
                    2. Go to profile
                    3. Get all WhatsApp status
                    4. Change profile photo
                    5. Change WhatsApp status
                    6. Add contact
                    7. Send message
                    8. Delete WhatsApp
                    """);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0-> {
                    isRunning = false;
                    System.out.println("Goodbye!");
                }
                case 1->  System.out.println(profiles.add(profileService.installWhatsapp(profiles)));
                case 2-> System.out.println(profileService.goToProfile(profiles));
                case 3-> System.out.println(profileService.getAllWhatsappStatus(profiles));
                case 4-> System.out.println(profileService.changeProfilePhoto(profiles));
                case 5-> System.out.println(profileService.changeWhatsappStatus(profiles));
                case 6-> System.out.println(profileService.addContact(profiles));
                case 7-> System.out.println(profileService.sendMessage(profiles));
                case 8-> {
                    profileService.deleteWhatsapp(profiles);
                    isRunning = false;
                }
                default-> System.out.println("Invalid choice.");
            }
        }
    }
}