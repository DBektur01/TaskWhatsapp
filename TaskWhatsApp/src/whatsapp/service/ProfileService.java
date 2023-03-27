package whatsapp.service;

import whatsapp.classes.Profile;
import whatsapp.enums.Status;

import java.util.List;

public interface ProfileService {

    Profile installWhatsapp(List<Profile>profileList);

    Profile goToProfile(List<Profile>profileList);

    List<Status> getAllWhatsappStatus(List<Profile>profileList);

    String changeWhatsappStatus(List<Profile>profileList);

    Profile addContact(List<Profile>profileList);

    String changeProfilePhoto(List<Profile>profileList);

    String sendMessage(List<Profile>profileList);

    void deleteWhatsapp(List<Profile>profileList);


}
