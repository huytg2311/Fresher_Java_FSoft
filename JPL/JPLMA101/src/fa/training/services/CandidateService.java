package fa.training.services;

import fa.training.entities.Candidate;
import fa.training.entities.ExperienceCandidate;
import fa.training.entities.FresherCandidate;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CandidateService {

    String FILE_PATH = "src//fa//training//file//Candidate.txt";

    List<Candidate> candidateList = new ArrayList<>();

    public synchronized void writeFresher() throws IOException {
//        candidateList.add(new FresherCandidate("Hieu", "Hoi Ham", LocalDate.parse("2001-10-03"),
//                "Quang Tri", "08129821", "h4@gmail.com", LocalDate.parse("2010-10-10"),
//                "Good", "University"));
//        candidateList.add(new FresherCandidate("Bao", "Bay Bong", LocalDate.parse("2001-10-03"),
//                "Quang Nam", "08129821", "h4@gmail.com", LocalDate.parse("2010-10-10"),
//                "Good", "University"));
//        candidateList.add(new FresherCandidate("Huy", "Hay Ho", LocalDate.parse("2001-10-03"),
//                "Da Nang", "08129821", "h4@gmail.com", LocalDate.parse("2010-10-10"),
//                "Good", "University"));
//        candidateList.add(new ExperienceCandidate("Lam", "Long La", LocalDate.parse("2001-10-03"),
//                "Dong Nai", "08129821", "h4@gmail.com", 2010, "Master"));
//        candidateList.add(new ExperienceCandidate("Ri", "Ron Ren", LocalDate.parse("2001-10-03"),
//                "Da Nang", "08129821", "h4@gmail.com", 2019, "Chicken"));
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        for (Candidate fc: candidateList
             ) {
            try {
                fileWriter.write(fc.toString() + "\n");
            } catch (Exception e) {}
        }
        fileWriter.close();

    }

    public synchronized void readFresher() {
        File file = new File(FILE_PATH);

        try (BufferedReader bufferedReader  = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] candidate = line.split(",");

                   String firstname = candidate[0].split("=")[1];
                   String lastname = candidate[1].split("=")[1];
                   LocalDate birthdate = LocalDate.parse(candidate[2].split("=")[1]);
                   String address = candidate[3].split("=")[1];
                   String phone = candidate[4].split("=")[1];
                   String email = candidate[5].split("=")[1];

                String s1 = candidate[6].substring(0, 15);
                String s2 = candidate[7].substring(0, 18);
                String s3 = " yearExperience";
                String s4 = " professionalSkill";
                if (s1.equals(s3) && s2.equals(s4)) {
                    int yearExperience = Integer.parseInt(candidate[6].split("=")[1]);
                    String professionalSkill = candidate[7].split("=")[1];
                    ExperienceCandidate  experienceCandidate = new ExperienceCandidate(firstname, lastname, birthdate, address, phone, email, yearExperience, professionalSkill);
                    candidateList.add(experienceCandidate);
                } else {
                    LocalDate graduationDate = LocalDate.parse(candidate[6].split("=")[1]);
                    String graduationRank = candidate[7].split("=")[1];
                    String education = candidate[8].split("=")[1];


                    FresherCandidate fresherCandidate = new FresherCandidate(firstname, lastname, birthdate, address, phone, email, graduationDate, graduationRank, education);
                    candidateList.add(fresherCandidate);

                }
            }
            for (Candidate c: candidateList
            ) {
                System.out.println(c.toString());
            }

        } catch (IOException e) {
        }
    }

    public synchronized void listFresher() {
        for (Candidate c: candidateList
        ) {
            System.out.println(c.toString());
        }
    }

}
