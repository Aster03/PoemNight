package project.ssibam.SuhangProject.repository;

import project.ssibam.SuhangProject.domain.PoemNightMember;

import java.util.ArrayList;

public interface PoemRepository {
    PoemNightMember save(PoemNightMember pm);
    PoemNightMember findById(int id);
    ArrayList<PoemNightMember> findByTitle(String title);
    ArrayList<PoemNightMember> findByAuthor(String author);
    ArrayList<PoemNightMember> findAll();

    //void updateContents(PoemNightMember poemNightMember);
    void deletePoem(PoemNightMember poemNightMember);
}
