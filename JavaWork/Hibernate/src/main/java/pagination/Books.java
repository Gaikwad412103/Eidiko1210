package pagination;

import jakarta.persistence.*;

@Entity
@Table(name = "books_details")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "book_name")
    private String name;
    @Column(name = "book_prize")
    private int prize;

    public Books() {
    }

    public Books(long id, String name, int prize) {
        this.id = id;
        this.name = name;
        this.prize = prize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prize='" + prize + '\'' +
                '}';
    }
}
