package hello.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Entity
public class ConfRoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int floor;

    private String name;

    private boolean hdmi;

    private boolean skypeVc;

    private boolean remotes;

    private boolean lan;

    private boolean instruction;

    private boolean labels;

    private String comments;



    public ConfRoomModel() {
    }

    public ConfRoomModel(int floor, String name, boolean hdmi, boolean skypeVc, boolean remotes, boolean lan, boolean instruction, boolean labels, String comments) {
        this.floor = floor;
        this.name = name;
        this.hdmi = hdmi;
        this.skypeVc = skypeVc;
        this.remotes = remotes;
        this.lan = lan;
        this.instruction = instruction;
        this.labels = labels;
        this.comments = comments;
    }
}
