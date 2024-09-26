package mapping.one_to_one;

import jakarta.persistence.*;

@Entity
public class Passport {
    @Id
    //@Column(name ="passport_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int passportNo;

    public Passport() {
    }

    public Passport(long id, int passportNo) {
        this.id = id;
        this.passportNo = passportNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passportNo=" + passportNo +
                '}';
    }
}
