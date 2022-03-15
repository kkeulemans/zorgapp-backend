package com.example.zorgapp.models;


import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;
    @Column(name = "address")
    String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Doctor getDoctor(){
        return doctor;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
}
