package whatsapp.service.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Message {
    private String message;
    private int messageTimeH;
    private  int messageTimeM;


}
