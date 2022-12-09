//package com.football_pitches.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "pitches_type")
//public class PitchesType {
//
//    @Id
//    @Column(columnDefinition = "varchar(10)", name = "pitches_id")
//    private String pitchesId;
//
//    private String pitchesName;
//
//    private int price;
//
//    @OneToMany(mappedBy = "pitchesType")
//    private List<PitchesRent> pitchesRentList;
//
//
//
//}
