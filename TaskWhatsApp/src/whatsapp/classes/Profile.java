package whatsapp.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import whatsapp.enums.Image;
import whatsapp.enums.Status;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private int id;
    private String name;
    private String phoneNumber;
    private String password;
    private Image profilePhoto;
    private Status status;
    private String message;

    private List<Profile> profiles = new ArrayList<>();


    @Override
    public String toString() {
        return "PROFILE:" +
                "\nID: "+id+
                "\nPHONE NUMBER: " + phoneNumber +
                "\nNAME: " + name +
                "\nPASSWORD: " + password +
                "\nPROFILE PHOTO: " + profilePhoto +
                "\nSTATUS: " + status +
                "\nMESSAGE: "+message;
    }
}
