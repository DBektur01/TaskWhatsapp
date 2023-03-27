package whatsapp.service.serviceImpl;

import exception.MyException;
import whatsapp.classes.Profile;
import whatsapp.enums.Image;
import whatsapp.enums.Status;
import whatsapp.service.ProfileService;

import java.time.LocalDateTime;
import java.util.*;

public class ProfileServiceImpl implements ProfileService {
    int id;
    private List<Profile> profileList = new ArrayList<>();
    Profile profile = new Profile();

    @Override
    public Profile installWhatsapp(List<Profile> profileList) {
        boolean isTrue = true;
        boolean checkName = true;
        boolean checkThePhoneNumber = true;
        boolean checkPassword = true;
        Profile profile = new Profile();
        while (isTrue) {
            try {
                while (checkName) {
                    System.out.print("Enter name: ");
                    String name = new Scanner(System.in).nextLine();
                    profile.setName(name);
                    checkName = false;
                }
                while (checkThePhoneNumber) {
                    System.out.print("Enter phone number: ");
                    String phoneNumber = new Scanner(System.in).nextLine();
                    boolean isDigit = false;
                    boolean isDigit1 = false;
                    for (int i = 0; i < phoneNumber.length(); i++) {
                        if (!Character.isDigit(phoneNumber.charAt(i))) {
                            isDigit1 = true;
                        } else {
                            isDigit = true;
                            isDigit1 = false;
                        }
                    }
                    if (isDigit1) {
                        throw new MyException("The phone number must consist of digits");
                    }
                    if (isDigit) {
                        if (phoneNumber.length() == 10 || phoneNumber.length() == 13) {
                            char zeroIndex = phoneNumber.charAt(0);
                            if (zeroIndex == '0' || phoneNumber.contains("+996")) {
                                if (!profileList.isEmpty()) {
                                    boolean isFalse = false;
                                    for (Profile p : profileList) {
                                        if (p.getPhoneNumber().equals(phoneNumber)) {
                                            isFalse = true;
                                        } else {
                                            isFalse = false;
                                            profile.setPhoneNumber(phoneNumber);
                                            checkThePhoneNumber = false;
                                            break;
                                        }
                                    }
                                    if (isFalse) {
                                        throw new MyException("The number you entered already exists");
                                    }
                                } else {
                                    checkThePhoneNumber = false;
                                    profile.setPhoneNumber(phoneNumber);
                                }
                            } else {
                                throw new MyException("The number format is incorrect");
                            }
                        } else {
                            throw new MyException("The length of the number does not consist of 10 or 13 digits");
                        }
                    }
                }
                while (checkPassword) {
                    System.out.println("Enter password: ");
                    String password = new Scanner(System.in).nextLine();
                    if (password.length() >= 8) {
                        if (!password.equals(password.toLowerCase())) {
                            boolean isFalse = false;
                            for (int i = 0; i < password.length(); i++) {
                                if (Character.isDigit(password.charAt(i))) {
                                    profile.setPassword(password);
                                    isFalse = false;
                                    checkPassword = false;
                                    break;
                                } else {
                                    isFalse = true;
                                }
                            }
                            if (isFalse) {
                                checkPassword = true;
                                throw new MyException("The password must contain at least 1 digit");
                            }
                        } else {
                            checkPassword = true;
                            throw new MyException("The password must contain at least 1 capital letter");
                        }
                    } else {
                        checkPassword = true;
                        throw new MyException("The password must be longer than 7 characters");
                    }
                }
                profile.setProfilePhoto(Image.FOOTBALL_IMAGE);
                profile.setStatus(Status.HELLO_I_USE_WHATSAPP);
                profile.setId(++id);
                System.out.println("You have successfully installed WhatsApp");
                return profile;
            } catch (MyException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Profile goToProfile(List<Profile> profileList) {
        System.out.print("Enter name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (Profile profile : profileList) {
            if (profile.getName().equals(name) && profile.getPassword().equals(password)) {
                System.out.println("Id: " + profile.getId() +
                        "\nName: " + profile.getName() +
                        "\nNumber: " + profile.getPhoneNumber() +
                        "\nStatus: " + profile.getStatus() +
                        "\nImage: " + profile.getProfilePhoto() +
                        "\nMessage: " + profile.getMessage() +
                        "\nContact: ");
                for (Profile p1 : profile.getProfiles()) {
                    System.out.println(p1.getName());
                }
                break;
            } else {
                System.out.println(" contact not found !");
            }
        }
        return null;
    }


    @Override
    public List<Status> getAllWhatsappStatus(List<Profile> profileList) {
        System.out.println("WhatsApp Status: ");
        for (Status s : Status.values()) {
            System.out.println(s.toString());
        }
        return null;
    }

    @Override
    public String changeProfilePhoto(List<Profile> profileList) {
        System.out.print("Enter name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (Profile p : profileList) {
            if (p.getName().equals(name) && p.getPassword().equals(password)) {
                System.out.println("Select image");
                System.out.println("""
                        1. Default image      
                        2. BMW image      
                        3. Mountain image  
                        4. Animal image
                        5. Football image  
                        """);
                int selectImg = new Scanner(System.in).nextInt();
                switch (selectImg) {
                    case 1 -> profile.setProfilePhoto(Image.DEFAULT_IMAGE);
                    case 2 -> profile.setProfilePhoto(Image.BMW_IMAGE);
                    case 3 -> profile.setProfilePhoto(Image.MOUNTAIN_IMAGE);
                    case 4 -> profile.setProfilePhoto(Image.ANIMAL_IMAGE);
                    case 5 -> profile.setProfilePhoto(Image.FOOTBALL_IMAGE);
                    default -> System.out.println("Choose 1-5");
                }
            }
        }
        return null;
    }

    @Override
    public String changeWhatsappStatus(List<Profile>profileList) {

                System.out.print("Enter name: ");
                String name = new Scanner(System.in).nextLine();
                System.out.print("Enter password: ");
                String password = new Scanner(System.in).nextLine();
                for (Profile p : profileList) {
                    if (p.getName().equals(name) && p.getPassword().equals(password)) {
                        System.out.println("""
                                1. AT_WORK,
                                2. TO_THE_CINEMA,
                                3. BUSY,
                                4. HELLO_I_USE_WHATSAPP;
                            
                                """);
                        byte selectProfileStatus = new Scanner(System.in).nextByte();
                        switch (selectProfileStatus) {
                            case 1 -> profile.setStatus(Status.HELLO_I_USE_WHATSAPP);
                            case 2 -> p.setStatus(Status.BUSY);
                            case 3 -> p.setStatus(Status.TO_THE_CINEMA);
                            case 4 -> p.setStatus(Status.AT_WORK);
                            default -> System.out.println("Choose from 1 to 4");

                        }
                    } else {
                        System.out.println(" Contact not found !");

                    }
                }

        return null;

    }
    @Override
    public Profile addContact(List<Profile>profileList) {
        System.out.println("Enter name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (Profile p : profileList) {
            if (p.getName().equals(name) && p.getPassword().equals(password)) {
                System.out.println("Enter phone number");
                String phoneNumber = new Scanner(System.in).nextLine();
                for (Profile profile : profileList) {
                    if (profile.getPhoneNumber().equals(phoneNumber)) {
                        p.getProfiles().add(profile);
                        profile.getProfiles().add(p);
                        System.out.println("Successfully added");
                        break;
                    }
                }
                break;
            }
        }
        return null;
    }



    @Override
    public String sendMessage(List<Profile>profileList) {


        Message message = new Message();
        boolean isFalse = false;
        try {
            if (!profileList.isEmpty()) {
                System.out.println("Enter name");
                String name = new Scanner(System.in).nextLine();
                System.out.println("Enter password");
                String password = new Scanner(System.in).nextLine();
                for (Profile p : profileList) {
                    if (p.getName().equals(name) && p.getPassword().equals(password)) {
                        isFalse = false;
                        for (Profile p1:p.getProfiles()) {
                            System.out.println(p1.getName());
                        }
                        System.out.println("Enter name");
                        String nameProfile = new Scanner(System.in).nextLine();
                        for (Profile p1 : p.getProfiles()) {
                            if (p1.getName().equals(nameProfile)) {
                                isFalse = false;
                                System.out.println("Enter your message");
                                String message1 = new Scanner(System.in).nextLine();
                                LocalDateTime localDateTime = LocalDateTime.now();
                                int h = localDateTime.getHour();
                                int m = localDateTime.getMinute();
                                message.setMessage(message1);
                                message.setMessageTimeH(h);
                                message.setMessageTimeM(m);
                                System.out.println("Are you sure you want to send these messages? [y/n]");
                                String send = new Scanner(System.in).nextLine().toLowerCase();
                                if (send.equals("y")) {

                                    System.out.println("Your message has been sent successfully");
                                    break;
                                } else {
                                    System.out.println("Your message has not been sent");
                                    break;
                                }
                            }
                        }
                    } else {
                        isFalse = true;
                    }
                }
                if (isFalse){
                    throw new InputMismatchException("Not found");
                }
            }


        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public void deleteWhatsapp(List<Profile>profileList) {
        boolean checkThePhoneNumber = true;
        while (checkThePhoneNumber) {
            try {
                if (!profileList.isEmpty()) {
                    System.out.println("Enter phone number");
                    String phoneNumber = new Scanner(System.in).nextLine();
                    boolean isDigit3 = false;
                    boolean isDigit1 = false;
                    for (int i = 0; i < phoneNumber.length(); i++) {
                        if (!Character.isDigit(phoneNumber.charAt(i))) {
                            isDigit1 = true;
                        } else {
                            isDigit3 = true;
                            isDigit1 = false;
                        }

                    }
                    if (isDigit1) {
                        throw new MyException("The phone number must consist of digits");
                    }
                    if (isDigit3) {
                        if (phoneNumber.length() == 10 || phoneNumber.length() == 13) {
                            char zeroIndex = phoneNumber.charAt(0);
                            if (zeroIndex == '0' || phoneNumber.contains("+996")) {
                                boolean isFalse = false;
                                for (Profile p : profileList) {
                                    if (!p.getPhoneNumber().equals(phoneNumber)) {
                                        isFalse = true;
                                    } else {
                                        profileList.remove(p);
                                        isFalse = false;
                                        System.out.println("Successfully deleted");
                                        checkThePhoneNumber = false;
                                        break;
                                    }
                                }
                                if (isFalse) {
                                    throw new MyException("The number you entered already exists");
                                }
                            } else {
                                throw new MyException("The number format is incorrect");
                            }
                        } else {
                            throw new MyException("The length of the number does not consist of 10 or 13 digits");
                        }
                    }
                } else {
                    throw new MyException("Contacts is null");
                }

        } catch (MyException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
