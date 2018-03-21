package hello.model;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class ConfRoomModel {

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Integer;

    private int floor;

    private String name;

    private boolean hdmi;

    private boolean skypeVC;

    private boolean remotes;

    private boolean lan;

    private boolean instruction;

    private boolean labels;

    private String comments;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    //   @NotNull(message = "is required")
    //   @Size(min = 1,message = "is required")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;


    public ConfRoomModel(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public ConfRoomModel() {
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

        public String toString() {
            return "ConfRoomModel.ConfRoomModelBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ")";
        }
    }
