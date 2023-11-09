package tn.esprit.rh.achat.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FournisseurServiceImplTest {

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Test
    public void addFournisseurTest() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCode("ABC123"); // Example code
        // Set other attributes for the Fournisseur

        // Mock the behavior of the repository
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        Fournisseur addedFournisseur = fournisseurService.addFournisseur(fournisseur);

        // Verify that the added Fournisseur matches the input Fournisseur
        assertEquals(fournisseur.getCode(), addedFournisseur.getCode());
        // Add assertions to check other attributes if needed
    }
}
