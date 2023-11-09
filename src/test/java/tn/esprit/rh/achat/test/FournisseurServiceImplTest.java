package tn.esprit.rh.achat.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class FournisseurServiceImplTest {

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Test
    public void retrieveAllFournisseursTest() {
        when(fournisseurRepository.findAll())
                .thenReturn(Stream.of(new Fournisseur(), new Fournisseur(), new Fournisseur())
                        .collect(Collectors.toList()));

        assertEquals(3, fournisseurService.retrieveAllFournisseurs().size());
    }

    @Test
    public void addFournisseurTest() {
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        assertEquals(fournisseur, fournisseurService.addFournisseur(fournisseur));
    }

    @Test
    public void deleteFournisseurTest() {
        Fournisseur fournisseur = new Fournisseur();
        Fournisseur fournisseur1 = new Fournisseur();

        fournisseurService.deleteFournisseur(fournisseur.getIdFournisseur());
        fournisseurService.deleteFournisseur(fournisseur1.getIdFournisseur());

        verify(fournisseurRepository, times(2)).deleteById(fournisseur.getIdFournisseur());
    }



    @Test
    public void retrieveFournisseurTest() {
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.findById(fournisseur.getIdFournisseur()))
                .thenReturn(java.util.Optional.of(fournisseur));

        assertEquals(fournisseur.getIdFournisseur(), fournisseurService.retrieveFournisseur(fournisseur.getIdFournisseur()).getIdFournisseur());
    }
}
