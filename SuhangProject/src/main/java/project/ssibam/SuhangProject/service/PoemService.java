package project.ssibam.SuhangProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import project.ssibam.SuhangProject.domain.PoemNightMember;
import project.ssibam.SuhangProject.repository.PoemRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class PoemService {
    private PoemRepository poemRepository;
    @Autowired
    public PoemService(PoemRepository poemRepository) { this.poemRepository = poemRepository; }

    public int join(PoemNightMember pm) {
        poemRepository.save(pm);
        return pm.getId();
    }

    public PoemNightMember findById(int id) { return poemRepository.findById(id); }
    public ArrayList<PoemNightMember> printMembers() { return poemRepository.findAll(); }
    public ArrayList<PoemNightMember> findByTitle(String title) { return poemRepository.findByTitle(title); }
    public ArrayList<PoemNightMember> findByAuthor(String author) { return poemRepository.findByAuthor(author); }
    //public void updateContents(PoemNightMember poemNightMember) { poemRepository.updateContents(poemNightMember); }
    public void deletePoem(PoemNightMember poemNightMember) { poemRepository.deletePoem(poemNightMember); }
}
